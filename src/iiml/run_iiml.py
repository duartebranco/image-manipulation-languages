from antlr4 import *
from iimlLexer import iimlLexer
from iimlParser import iimlParser
from IimlEvalVisitor import IimlEvalVisitor

from PIL import Image
import numpy as np
import sys
import os

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

if __name__ == "__main__":
    if len(sys.argv) < 1:
        print("Usage: python3 src/iiml/run_iiml.py <path_to_iiml_file>")
        sys.exit(1)
    
    input_path = sys.argv[1]
    output_path = input_path.replace('.iiml', '.pgm') if input_path.endswith('.iiml') else None
    
    result = run_iiml_program(input_path)
    img_draw = np.array(result) if not isinstance(result, np.ndarray) else result
    
    if img_draw.ndim == 2:
        Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
    
    if output_path:
        os.makedirs(os.path.dirname(output_path) if os.path.dirname(output_path) else '.', exist_ok=True)
        Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).save(output_path)
        print(f"Image saved to {output_path}")