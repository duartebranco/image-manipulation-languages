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
k = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/kernel00.pgm")
l = []
while (np.any(i > 0)):
    img_draw = i
    if img_draw.ndim == 2:
        Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
    else:
        Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
    k = np.array(k, dtype=np.uint8)
    if i.ndim == 3:
        _temp0 = np.stack([cv2.erode(i[...,c], k, iterations=1) for c in range(i.shape[2])], axis=-1)
    else:
        _temp0 = cv2.erode(i, k, iterations=1)
    i = _temp0
    l.append(i)
img_store = l
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/animation.gif", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'l' is empty. Cannot save GIF to {'examples/animation.gif'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/animation.gif")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/animation.gif")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'l'.")
