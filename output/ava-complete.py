#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

def soma(a, b):
    res = a + b
    return res

x = soma(3, 4)
print(str(x))
try:
    i = np.array(Image.open("examples/" + ("images/nao_existe.ppm")).convert('L')) / 255.0
except Exception as e:
    print("File not found.")
    exit()
