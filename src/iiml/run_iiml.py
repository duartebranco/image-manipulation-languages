from antlr4 import * # type: ignore
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
    if len(sys.argv) < 2:
        print("Usage: python3 src/iiml/run_iiml.py <path_to_iiml_file>")
        sys.exit(1)
    
    input_path = sys.argv[1]
    output_path = input_path.replace('.iiml', '.pgm') if input_path.endswith('.iiml') else input_path + '.pgm'
    
    result = run_iiml_program(input_path)
    
    # Make sure we have an image to display
    if result is None or not isinstance(result, (np.ndarray, list)):
        print("Error: No image was generated")
        sys.exit(1)
    
    # Convert to numpy array if it's a list
    img_draw = np.array(result) if not isinstance(result, np.ndarray) else result
    
    # Print image info for debugging
    print(f"Image shape: {img_draw.shape}")
    print(f"Image min value: {np.min(img_draw)}, max value: {np.max(img_draw)}")
    
    # Make sure image is 2D (grayscale)
    if img_draw.ndim == 2:
        # Scale to 0-255 and convert to uint8
        img_display = np.clip(img_draw * 255, 0, 255).astype(np.uint8)
        
        # Display image
        img_pil = Image.fromarray(img_display)
        img_pil.show()
        
        # Save image
        os.makedirs(os.path.dirname(output_path) if os.path.dirname(output_path) else '.', exist_ok=True)
        img_pil.save(output_path)
        print(f"Image saved to {output_path}")
    else:
        print(f"Error: Expected 2D image but got shape {img_draw.shape}")