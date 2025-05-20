#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + (input("Path: "))).convert('L'))
l = [(100/100), (90/100), (80/100), (70/100), (60/100), (50/100), (40/100), (30/100), (20/100), (10/100)]
r = i * p
Image.fromarray(r).show()
