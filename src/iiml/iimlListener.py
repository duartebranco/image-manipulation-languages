# Generated from iiml.g4 by ANTLR 4.13.2
from antlr4 import *
if "." in __name__:
    from .iimlParser import iimlParser
else:
    from iimlParser import iimlParser

# This class defines a complete listener for a parse tree produced by iimlParser.
class iimlListener(ParseTreeListener):

    # Enter a parse tree produced by iimlParser#program.
    def enterProgram(self, ctx:iimlParser.ProgramContext):
        pass

    # Exit a parse tree produced by iimlParser#program.
    def exitProgram(self, ctx:iimlParser.ProgramContext):
        pass


    # Enter a parse tree produced by iimlParser#statement.
    def enterStatement(self, ctx:iimlParser.StatementContext):
        pass

    # Exit a parse tree produced by iimlParser#statement.
    def exitStatement(self, ctx:iimlParser.StatementContext):
        pass


    # Enter a parse tree produced by iimlParser#variableDeclaration.
    def enterVariableDeclaration(self, ctx:iimlParser.VariableDeclarationContext):
        pass

    # Exit a parse tree produced by iimlParser#variableDeclaration.
    def exitVariableDeclaration(self, ctx:iimlParser.VariableDeclarationContext):
        pass


    # Enter a parse tree produced by iimlParser#assignment.
    def enterAssignment(self, ctx:iimlParser.AssignmentContext):
        pass

    # Exit a parse tree produced by iimlParser#assignment.
    def exitAssignment(self, ctx:iimlParser.AssignmentContext):
        pass


    # Enter a parse tree produced by iimlParser#outputStatement.
    def enterOutputStatement(self, ctx:iimlParser.OutputStatementContext):
        pass

    # Exit a parse tree produced by iimlParser#outputStatement.
    def exitOutputStatement(self, ctx:iimlParser.OutputStatementContext):
        pass


    # Enter a parse tree produced by iimlParser#imageStatement.
    def enterImageStatement(self, ctx:iimlParser.ImageStatementContext):
        pass

    # Exit a parse tree produced by iimlParser#imageStatement.
    def exitImageStatement(self, ctx:iimlParser.ImageStatementContext):
        pass


    # Enter a parse tree produced by iimlParser#placeStatement.
    def enterPlaceStatement(self, ctx:iimlParser.PlaceStatementContext):
        pass

    # Exit a parse tree produced by iimlParser#placeStatement.
    def exitPlaceStatement(self, ctx:iimlParser.PlaceStatementContext):
        pass


    # Enter a parse tree produced by iimlParser#shapeSize.
    def enterShapeSize(self, ctx:iimlParser.ShapeSizeContext):
        pass

    # Exit a parse tree produced by iimlParser#shapeSize.
    def exitShapeSize(self, ctx:iimlParser.ShapeSizeContext):
        pass


    # Enter a parse tree produced by iimlParser#forStatement.
    def enterForStatement(self, ctx:iimlParser.ForStatementContext):
        pass

    # Exit a parse tree produced by iimlParser#forStatement.
    def exitForStatement(self, ctx:iimlParser.ForStatementContext):
        pass


    # Enter a parse tree produced by iimlParser#forControl.
    def enterForControl(self, ctx:iimlParser.ForControlContext):
        pass

    # Exit a parse tree produced by iimlParser#forControl.
    def exitForControl(self, ctx:iimlParser.ForControlContext):
        pass


    # Enter a parse tree produced by iimlParser#forType.
    def enterForType(self, ctx:iimlParser.ForTypeContext):
        pass

    # Exit a parse tree produced by iimlParser#forType.
    def exitForType(self, ctx:iimlParser.ForTypeContext):
        pass


    # Enter a parse tree produced by iimlParser#shape.
    def enterShape(self, ctx:iimlParser.ShapeContext):
        pass

    # Exit a parse tree produced by iimlParser#shape.
    def exitShape(self, ctx:iimlParser.ShapeContext):
        pass


    # Enter a parse tree produced by iimlParser#stringConversionExpr.
    def enterStringConversionExpr(self, ctx:iimlParser.StringConversionExprContext):
        pass

    # Exit a parse tree produced by iimlParser#stringConversionExpr.
    def exitStringConversionExpr(self, ctx:iimlParser.StringConversionExprContext):
        pass


    # Enter a parse tree produced by iimlParser#indexExpr.
    def enterIndexExpr(self, ctx:iimlParser.IndexExprContext):
        pass

    # Exit a parse tree produced by iimlParser#indexExpr.
    def exitIndexExpr(self, ctx:iimlParser.IndexExprContext):
        pass


    # Enter a parse tree produced by iimlParser#arithmeticMulDivExpr.
    def enterArithmeticMulDivExpr(self, ctx:iimlParser.ArithmeticMulDivExprContext):
        pass

    # Exit a parse tree produced by iimlParser#arithmeticMulDivExpr.
    def exitArithmeticMulDivExpr(self, ctx:iimlParser.ArithmeticMulDivExprContext):
        pass


    # Enter a parse tree produced by iimlParser#primaryExpr.
    def enterPrimaryExpr(self, ctx:iimlParser.PrimaryExprContext):
        pass

    # Exit a parse tree produced by iimlParser#primaryExpr.
    def exitPrimaryExpr(self, ctx:iimlParser.PrimaryExprContext):
        pass


    # Enter a parse tree produced by iimlParser#readExpr.
    def enterReadExpr(self, ctx:iimlParser.ReadExprContext):
        pass

    # Exit a parse tree produced by iimlParser#readExpr.
    def exitReadExpr(self, ctx:iimlParser.ReadExprContext):
        pass


    # Enter a parse tree produced by iimlParser#arithmeticAddSubExpr.
    def enterArithmeticAddSubExpr(self, ctx:iimlParser.ArithmeticAddSubExprContext):
        pass

    # Exit a parse tree produced by iimlParser#arithmeticAddSubExpr.
    def exitArithmeticAddSubExpr(self, ctx:iimlParser.ArithmeticAddSubExprContext):
        pass


    # Enter a parse tree produced by iimlParser#parenExpr.
    def enterParenExpr(self, ctx:iimlParser.ParenExprContext):
        pass

    # Exit a parse tree produced by iimlParser#parenExpr.
    def exitParenExpr(self, ctx:iimlParser.ParenExprContext):
        pass


    # Enter a parse tree produced by iimlParser#numberConversionExpr.
    def enterNumberConversionExpr(self, ctx:iimlParser.NumberConversionExprContext):
        pass

    # Exit a parse tree produced by iimlParser#numberConversionExpr.
    def exitNumberConversionExpr(self, ctx:iimlParser.NumberConversionExprContext):
        pass


    # Enter a parse tree produced by iimlParser#primary.
    def enterPrimary(self, ctx:iimlParser.PrimaryContext):
        pass

    # Exit a parse tree produced by iimlParser#primary.
    def exitPrimary(self, ctx:iimlParser.PrimaryContext):
        pass


    # Enter a parse tree produced by iimlParser#list.
    def enterList(self, ctx:iimlParser.ListContext):
        pass

    # Exit a parse tree produced by iimlParser#list.
    def exitList(self, ctx:iimlParser.ListContext):
        pass


    # Enter a parse tree produced by iimlParser#type.
    def enterType(self, ctx:iimlParser.TypeContext):
        pass

    # Exit a parse tree produced by iimlParser#type.
    def exitType(self, ctx:iimlParser.TypeContext):
        pass



del iimlParser