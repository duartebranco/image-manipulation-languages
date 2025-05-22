#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
k = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
k = np.array(k, dtype=np.uint8)
_temp0 = cv2.morphologyEx(i, cv2.MORPH_OPEN, k)
k = np.array(k, dtype=np.uint8)
_temp1 = cv2.morphologyEx((_temp0), cv2.MORPH_CLOSE, k)
i2 = _temp1
blend = i * (30/100) + (70/100) * i2
_temp2 = np.flipud(i)
flippedV = _temp2
_temp3 = np.fliplr(i)
flippedH = _temp3
_temp4 = np.flipud(np.fliplr(i))
flipped = _temp4
Image.fromarray(np.clip((flipped) * 255, 0, 255).astype(np.uint8)).show()
scaledV = np.array(Image.fromarray(i).resize((i.shape[1], int(i.shape[0] * (50/100)))))
scaledH = np.array(Image.fromarray(i).resize((int(i.shape[1] * (50/100)), i.shape[0])))
scaled = np.array(Image.fromarray(i).resize((int(i.shape[1] * (50/100)), int(i.shape[0] * (50/100)))))
