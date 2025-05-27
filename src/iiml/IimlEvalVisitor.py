from antlr4 import *
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
      var_type = ctx.type_().getText() if hasattr(ctx, "type_") else ctx.type().getText()
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
      img = np.full((width, height), background, dtype=float)
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
      if ctx.operator.text == '+':
         return left + right
      else:
         return left - right

   def visitArithmeticMulDivExpr(self, ctx:iimlParser.ArithmeticMulDivExprContext):
      left = self.visit(ctx.left)
      right = self.visit(ctx.right)
      if ctx.operator.text == '*':
         return left * right
      else:
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