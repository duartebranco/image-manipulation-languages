#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)(input("Path: "))
l = [(100/100), (90/100), (80/100), (70/100), (60/100), (50/100), (40/100), (30/100), (20/100), (10/100)]
for p in l:
    r = i * p
    img_draw = r
    if img_draw.ndim == 2:
        Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
    else:
        Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
