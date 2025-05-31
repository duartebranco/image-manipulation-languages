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
   
   def visitParenExpr(self, ctx:iimlParser.ParenExprContext):
    return self.visit(ctx.expression())

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
   
   # Add these methods to your existing IimlEvalVisitor class
   
   def visitPlaceStatement(self, ctx:iimlParser.PlaceStatementContext):
      if "image" not in self.vars:
         raise RuntimeError("No active image to draw on")
      
      shape = ctx.shape().getText()
      img = self.vars["image"]
      height, width = img.shape  # Note: numpy arrays are (height, width)
      
      # Initialize variables with default values to avoid "possibly unbound" error
      shape_width = 0
      shape_height = 0
      radius = 0
      size_type = "radius"  # Default size type
      
      # Get shape size (either radius or width/height)
      if ctx.shapeSize().getChild(0).getText() == "radius":
         # Using radius
         radius = int(self.visit(ctx.shapeSize().expression(0)))
         size_type = "radius"
      else:
         # Using width/height
         shape_width = int(self.visit(ctx.shapeSize().expression(0)))
         shape_height = int(self.visit(ctx.shapeSize().expression(1)))
         # Convert width/height to equivalent radius for simplicity
         radius = max(shape_width, shape_height) // 2
         size_type = "width_height"
      
      # Get center position
      centerX = int(self.visit(ctx.expression(0)))
      centerY = int(self.visit(ctx.expression(1)))
      
      # Get intensity
      intensity = float(self.visit(ctx.expression(2)))
      
      # Draw shape based on shape type
      if shape == "circle":
         # Circle equation: (x-center_x)^2 + (y-center_y)^2 <= r^2
         y, x = np.ogrid[:height, :width]
         mask = (x - centerX)**2 + (y - centerY)**2 <= radius**2
         img[mask] = intensity
      
      elif shape == "rect":
         if size_type == "radius":
               # Rectangle with sides 2*radius
               x_min, x_max = max(0, centerX - radius), min(width, centerX + radius)
               y_min, y_max = max(0, centerY - radius), min(height, centerY + radius)
         else:
               # Rectangle with specific width/height
               x_min = max(0, centerX - shape_width // 2)
               x_max = min(width, centerX + (shape_width - shape_width // 2))
               y_min = max(0, centerY - shape_height // 2)
               y_max = min(height, centerY + (shape_height - shape_height // 2))
         
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

   def visitForStatement(self, ctx:iimlParser.ForStatementContext):
      # Get the iterable collection
      collection = self.visit(ctx.forControl().expression())
      
      # Get the iteration variable name
      var_name = ctx.forControl().ID().getText()
      
      # Determine the variable type if specified
      var_type = None
      if ctx.forControl().forType():
         var_type = ctx.forControl().forType().getText()
      
      # Store the original value of the variable if it exists
      original_value = self.vars.get(var_name, None)
      
      # Iterate over the collection
      for item in collection:
         # Assign the current item to the iteration variable
         self.vars[var_name] = item
         
         # Execute the loop body (a single statement)
         self.visit(ctx.statement())
      
      # Restore the original value or remove if it didn't exist before
      if original_value is not None:
         self.vars[var_name] = original_value
      else:
         self.vars.pop(var_name, None)
      
      return None

   def visitIndexExpr(self, ctx:iimlParser.IndexExprContext):
      # Get the list or array
      container = self.visit(ctx.expression(0))
      # Get the index
      index = int(self.visit(ctx.expression(1)))
      
      # Handle lists, numpy arrays, or other indexable objects
      if isinstance(container, (list, np.ndarray)):
         if 0 <= index < len(container):
               return container[index]
         else:
               raise RuntimeError(f"Index {index} out of bounds for container of length {len(container)}")
      else:
         raise RuntimeError(f"Cannot index into object of type {type(container)}")