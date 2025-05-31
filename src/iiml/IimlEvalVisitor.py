from antlr4 import * # type: ignore
from iimlParser import iimlParser
from iimlVisitor import iimlVisitor
import numpy as np

class IimlEvalVisitor(iimlVisitor):
   def __init__(self):
      super().__init__()
      self.vars = {}

   def visitProgram(self, ctx:iimlParser.ProgramContext):
      for stmt in ctx.statement():
         self.visit(stmt)
      return self.vars

   def visitVariableDeclaration(self, ctx:iimlParser.VariableDeclarationContext):
      var_type = ctx.type_().getText()
      var_name = ctx.ID().getText()
      value = self.visit(ctx.expression())
      self.vars[var_name] = value
      return value

   def visitAssignment(self, ctx:iimlParser.AssignmentContext):
      var_name = ctx.ID().getText()
      value = self.visit(ctx.expression())
      self.vars[var_name] = value
      return value

   def visitOutputStatement(self, ctx:iimlParser.OutputStatementContext):
      value = self.visit(ctx.expression())
      print(value)
      return value

   def visitImageStatement(self, ctx:iimlParser.ImageStatementContext):
      width = int(self.visit(ctx.expression(0)))
      height = int(self.visit(ctx.expression(1)))
      background = float(self.visit(ctx.expression(2)))
    
      # Create numpy array with correct dimensions (height, width)
      img = np.full((height, width), background, dtype=float)
      self.vars["image"] = img
      return img

   def visitPrimary(self, ctx:iimlParser.PrimaryContext):
      if ctx.ID():
         return self.vars[ctx.ID().getText()]
      if ctx.NUMBER():
         return float(ctx.NUMBER().getText())
      if ctx.PERCENTAGE():
         return float(ctx.PERCENTAGE().getText()[:-1]) / 100
      if ctx.STRING():
         return ctx.STRING().getText()[1:-1]
      if ctx.list_():
         return self.visit(ctx.list_())

   def visitArithmeticAddSubExpr(self, ctx:iimlParser.ArithmeticAddSubExprContext):
      left = self.visit(ctx.left)
      right = self.visit(ctx.right)
      
      # Get the operator token text directly from the child at index 1 (between left and right)
      op_text = ctx.getChild(1).getText()
      if op_text == '+':
         return left + right
      else:  # Must be '-'
         return left - right

   def visitArithmeticMulDivExpr(self, ctx:iimlParser.ArithmeticMulDivExprContext):
      left = self.visit(ctx.left)
      right = self.visit(ctx.right)
      
      # Get the operator token text directly from the child at index 1 (between left and right)
      op_text = ctx.getChild(1).getText()
      if op_text == '*':
         return left * right
      else:  # Must be '/'
         if right == 0:  # Add division by zero check
               raise RuntimeError("Division by zero")
         return left / right

   def visitReadExpr(self, ctx:iimlParser.ReadExprContext):
      prompt = ctx.STRING().getText()[1:-1]
      return input(prompt)

   def visitNumberConversionExpr(self, ctx:iimlParser.NumberConversionExprContext):
      return float(self.visit(ctx.expression()))

   def visitStringConversionExpr(self, ctx:iimlParser.StringConversionExprContext):
      return str(self.visit(ctx.expression()))

   def visitList(self, ctx:iimlParser.ListContext):
      return [self.visit(expr) for expr in ctx.expression()]
   
   def visitPlaceStatement(self, ctx:iimlParser.PlaceStatementContext):
    if "image" not in self.vars:
        raise RuntimeError("No active image to draw on")
    
    shape = ctx.shape().getText()
    radius = int(self.visit(ctx.expression(0)))
    centerX = int(self.visit(ctx.expression(1)))
    centerY = int(self.visit(ctx.expression(2)))
    intensity = float(self.visit(ctx.expression(3)))
    
    img = self.vars["image"]
    height, width = img.shape  # Note: numpy arrays are (height, width)
    
    # Create meshgrid for efficient vectorized operations
    y, x = np.ogrid[:height, :width]
    
    if shape == "circle":
        # Circle equation: (x-center_x)^2 + (y-center_y)^2 <= r^2
        mask = (x - centerX)**2 + (y - centerY)**2 <= radius**2
        img[mask] = intensity
    
    elif shape == "rect":
        # Rectangle with sides 2*radius
        x_min, x_max = max(0, centerX - radius), min(width, centerX + radius)
        y_min, y_max = max(0, centerY - radius), min(height, centerY + radius)
        img[y_min:y_max, x_min:x_max] = intensity
    
    elif shape == "cross":
        thickness = max(1, radius//5)
        
        # Draw the cross diagonals
        for y_pos in range(max(0, centerY - radius), min(height, centerY + radius)):
            for x_pos in range(max(0, centerX - radius), min(width, centerX + radius)):
                # Check if point is on either diagonal with thickness
                dx, dy = x_pos - centerX, y_pos - centerY
                if abs(dx - dy) <= thickness or abs(dx + dy) <= thickness:
                    img[y_pos, x_pos] = intensity
    
    elif shape == "plus":
        thickness = max(1, radius//5)
        
        # Horizontal line
        x_min, x_max = max(0, centerX - radius), min(width, centerX + radius)
        y_min, y_max = max(0, centerY - thickness), min(height, centerY + thickness)
        img[y_min:y_max, x_min:x_max] = intensity
        
        # Vertical line
        x_min, x_max = max(0, centerX - thickness), min(width, centerX + thickness)
        y_min, y_max = max(0, centerY - radius), min(height, centerY + radius)
        img[y_min:y_max, x_min:x_max] = intensity
    
    else:
        raise RuntimeError(f"Unknown shape: {shape}")
    
    return img