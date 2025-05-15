#!/usr/bin/env python3
from PIL import Image
import numpy as np

i = np.array(Image.open("examples/images/sample03.pgm").convert('L'))
k = input("Path: ")
r = k
Image.fromarray(np.clip(r, 0, 255).astype(np.uint8)).save("examples/images/clean.pgm")
