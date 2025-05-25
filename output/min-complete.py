#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
k = np.array(Image.open("examples/" + ("images/sample01.pgm")).convert('L')) / 255.0
nk = np.array(Image.open("examples/" + ("images/kernel00.pgm")).convert('L')) / 255.0
n = 42
s2 = str(n)
print(s2)
n2 = float("10")
print(n2)
