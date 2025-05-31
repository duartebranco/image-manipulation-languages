import sys
import os
from antlr4 import * # type: ignore
from iimlLexer import iimlLexer
from iimlParser import iimlParser
from IimlEvalVisitor import IimlEvalVisitor
from PIL import Image
import numpy as np

def main(argv):
    if len(argv) < 2:
        print("Usage: python iimlMain.py <inputfile>")
        return
        
    input_file = argv[1]
    
    try:
        input_stream = FileStream(input_file)
        lexer = iimlLexer(input_stream)
        stream = CommonTokenStream(lexer)
        parser = iimlParser(stream)
        tree = parser.program()
        
        if parser.getNumberOfSyntaxErrors() == 0:
            visitor = IimlEvalVisitor()
            visitor.visit(tree)
            
            # Get the final image
            if "image" in visitor.vars:
                img = visitor.vars["image"]
                
                # Save and display the image
                output_file = input_file.replace('.iiml', '.pgm')
                img_uint8 = np.clip(img * 255, 0, 255).astype(np.uint8)
                Image.fromarray(img_uint8).save(output_file)
                print(f"Image saved to {output_file}")
                
                # Display the image
                Image.fromarray(img_uint8).show()
            else:
                print("No image was created")
        else:
            print(f"Syntax errors found: {parser.getNumberOfSyntaxErrors()}")
            
    except Exception as e:
        print(f"Error: {e}")

if __name__ == '__main__':
    main(sys.argv)