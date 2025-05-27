# Generated from src/iiml/iiml.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .iimlParser import iimlParser
else:
    from iimlParser import iimlParser

# This class defines a complete generic visitor for a parse tree produced by iimlParser.

class iimlVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by iimlParser#program.
    def visitProgram(self, ctx:iimlParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#statement.
    def visitStatement(self, ctx:iimlParser.StatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#variableDeclaration.
    def visitVariableDeclaration(self, ctx:iimlParser.VariableDeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#assignment.
    def visitAssignment(self, ctx:iimlParser.AssignmentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#outputStatement.
    def visitOutputStatement(self, ctx:iimlParser.OutputStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#imageStatement.
    def visitImageStatement(self, ctx:iimlParser.ImageStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#placeStatement.
    def visitPlaceStatement(self, ctx:iimlParser.PlaceStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#shape.
    def visitShape(self, ctx:iimlParser.ShapeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#stringConversionExpr.
    def visitStringConversionExpr(self, ctx:iimlParser.StringConversionExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#arithmeticMulDivExpr.
    def visitArithmeticMulDivExpr(self, ctx:iimlParser.ArithmeticMulDivExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#primaryExpr.
    def visitPrimaryExpr(self, ctx:iimlParser.PrimaryExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#readExpr.
    def visitReadExpr(self, ctx:iimlParser.ReadExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#arithmeticAddSubExpr.
    def visitArithmeticAddSubExpr(self, ctx:iimlParser.ArithmeticAddSubExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#parenExpr.
    def visitParenExpr(self, ctx:iimlParser.ParenExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#numberConversionExpr.
    def visitNumberConversionExpr(self, ctx:iimlParser.NumberConversionExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#primary.
    def visitPrimary(self, ctx:iimlParser.PrimaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#list.
    def visitList(self, ctx:iimlParser.ListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by iimlParser#type.
    def visitType(self, ctx:iimlParser.TypeContext):
        return self.visitChildren(ctx)



del iimlParser