#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + (input("Path: "))).convert('L')) / 255.0
k = []
k.append([0, 1, 0])
k.append([1, 1, 1])
k.append([0, 1, 0])
k = np.array(k, dtype=np.uint8)
_temp0 = cv2.morphologyEx((i * 255).astype(np.uint8), cv2.MORPH_TOPHAT, k).astype(np.float32) / 255.0
t = _temp0
k = np.array(k, dtype=np.uint8)
_temp1 = cv2.morphologyEx((i * 255).astype(np.uint8), cv2.MORPH_BLACKHAT, k).astype(np.float32) / 255.0
b = _temp1
r = i + t - b
if isinstance(r, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame, 0, 255).astype(np.uint8)) for _frame in r]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/enhanced.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'r' is empty. Cannot save GIF to {'examples/images/enhanced.pgm'}")
elif isinstance(r, np.ndarray):
    Image.fromarray(np.clip((r) * 255, 0, 255).astype(np.uint8)).save("examples/images/enhanced.pgm")
else:
    print(f"Error: Cannot store type {type(r)} as image/GIF for expression 'r'.")
