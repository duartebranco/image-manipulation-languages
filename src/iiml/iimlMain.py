import sys
from antlr4 import *
from iimlLexer import iimlLexer
from iimlParser import iimlParser
from IimlEvalVisitor import IimlEvalVisitor

def main(argv):
   visitor0 = IimlEvalVisitor()
   input_stream = StdinStream()
   lexer = iimlLexer(input_stream)
   stream = CommonTokenStream(lexer)
   parser = iimlParser(stream)
   tree = parser.program()
   if parser.getNumberOfSyntaxErrors() == 0:
      visitor0.visit(tree)

if __name__ == '__main__':
   main(sys.argv)
