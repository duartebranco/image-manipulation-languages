#!/usr/bin/env python3
from PIL import Image
import numpy as np

i = np.array(Image.open("examples/images/sample00.pgm").convert('L'))
print(i)
Image.fromarray(i).show()
Image.fromarray(np.clip(i, 0, 255).astype(np.uint8)).save("examples/images/copy_sample00.pgm")
