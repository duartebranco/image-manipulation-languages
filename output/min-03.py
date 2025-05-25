#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/sample03.pgm")
k = run_iiml_program(input("Path: "))
k = np.array(k, dtype=np.uint8)
_temp0 = cv2.morphologyEx(i, cv2.MORPH_OPEN, k)
k = np.array(k, dtype=np.uint8)
_temp1 = cv2.morphologyEx((_temp0), cv2.MORPH_CLOSE, k)
r = _temp1
img_store = r
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/clean.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'r' is empty. Cannot save GIF to {'examples/images/clean.pgm'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/images/clean.pgm")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/images/clean.pgm")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'r'.")
