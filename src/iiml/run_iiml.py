from antlr4 import *
from iimlLexer import iimlLexer
from iimlParser import iimlParser
from IimlEvalVisitor import IimlEvalVisitor

def run_iiml_program(path):
    with open(path, "r") as f:
        code = f.read()
    input_stream = InputStream(code)
    lexer = iimlLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = iimlParser(stream)
    tree = parser.program()
    visitor = IimlEvalVisitor()
    result = visitor.visit(tree)
    # Por convenção, devolve a variável 'image' se existir
    return getattr(visitor, "vars", {}).get("image", result)