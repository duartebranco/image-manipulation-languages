#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
k = np.array(Image.open("examples/" + ("images/kernel00.pgm")).convert('L')) / 255.0
k = np.array(k, dtype=np.uint8)
_temp0 = cv2.morphologyEx(i, cv2.MORPH_OPEN, k)
k = np.array(k, dtype=np.uint8)
_temp1 = cv2.morphologyEx((_temp0), cv2.MORPH_CLOSE, k)
r = _temp1
if np.any(r > 0):
    print("Image contains at least one object.")
else:
    print("Image does not contains any object.")
Image.fromarray(np.clip((r) * 255, 0, 255).astype(np.uint8)).show()
if isinstance(r, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in r]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/result.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'r' is empty. Cannot save GIF to {'examples/images/result.pgm'}")
elif isinstance(r, np.ndarray):
    Image.fromarray(np.clip((r) * 255, 0, 255).astype(np.uint8)).save("examples/images/result.pgm")
else:
    print(f"Error: Cannot store type {type(r)} as image/GIF for expression 'r'.")
