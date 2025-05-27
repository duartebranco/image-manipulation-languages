#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2
import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../src/iiml')))
from src.iiml.run_iiml import run_iiml_program

i = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)(input("Path: "))
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
img_store = r
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/enhanced.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'r' is empty. Cannot save GIF to {'examples/images/enhanced.pgm'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/images/enhanced.pgm")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/images/enhanced.pgm")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'r'.")
