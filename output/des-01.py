#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/images/sample00.pgm").convert('L'))
k = np.array(Image.open("examples/images/kernel00.pgm").convert('L'))
r = _temp0 = cv2.morphologyEx(i, cv2.MORPH_OPEN, k)
_temp1 = cv2.morphologyEx((_temp0), cv2.MORPH_CLOSE, k)
_temp1
if np.any(r > 0):
    print("Image contains at least one object.")
else:
    print("Image does not contains any object.")
Image.fromarray(r).show()
Image.fromarray(np.clip(r, 0, 255).astype(np.uint8)).save("examples/images/result.pgm")
