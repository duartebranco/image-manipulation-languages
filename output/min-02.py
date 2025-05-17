#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i0 = np.array(Image.open("examples/images/sample00.pgm").convert('L'))
i1 = np.array(Image.open("examples/images/sample01.pgm").convert('L'))
i0cols = i0.shape[1]
i1cols = i1.shape[1]
if i0cols != i1cols:
    i0 = np.array(Image.fromarray(i0).resize((int(i0.shape[1] * (i0cols)), i0.shape[0])))
i0rows = i0.shape[0]
i1rows = i1.shape[0]
if i0rows != i1rows:
    i0 = np.array(Image.fromarray(i0).resize((i0.shape[1], int(i0.shape[0] * (i0rows)))))
r = i0 * (30/100) + (70/100) * i1
Image.fromarray(np.clip(r, 0, 255).astype(np.uint8)).save("examples/images/blend.pgm")
