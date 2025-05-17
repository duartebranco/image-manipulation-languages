#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/images/sample03.pgm").convert('L'))
k = input("Path: ")
r = _temp0 = cv2.morphologyEx(i, cv2.MORPH_OPEN, k)
_temp1 = cv2.morphologyEx((_temp0), cv2.MORPH_CLOSE, k)
_temp1
Image.fromarray(np.clip(r, 0, 255).astype(np.uint8)).save("examples/images/clean.pgm")
