#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i0 = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/sample00.pgm")
i1 = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/sample01.pgm")
i0cols = i0.shape[1]
i1cols = i1.shape[1]
if i0cols != i1cols:
    if i0.ndim == 2:
        _temp0 = np.array(Image.fromarray(np.clip((i0) * 255, 0, 255).astype(np.uint8)).resize((int(i0.shape[1] * (i1cols / i0cols)), i0.shape[0]))) / 255.0
    else:
        _temp0 = np.array(Image.fromarray(np.clip((i0) * 255, 0, 255).astype(np.uint8), mode='RGB').resize((int(i0.shape[1] * (i1cols / i0cols)), i0.shape[0]))) / 255.0
    i0 = _temp0
i0rows = i0.shape[0]
i1rows = i1.shape[0]
if i0rows != i1rows:
    if i0.ndim == 2:
        _temp1 = np.array(Image.fromarray(np.clip((i0) * 255, 0, 255).astype(np.uint8)).resize((i0.shape[1], int(i0.shape[0] * (i1rows / i0rows))))) / 255.0
    else:
        _temp1 = np.array(Image.fromarray(np.clip((i0) * 255, 0, 255).astype(np.uint8), mode='RGB').resize((i0.shape[1], int(i0.shape[0] * (i1rows / i0rows))))) / 255.0
    i0 = _temp1
r = i0 * (30/100) + (70/100) * i1
img_store = r
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/blend.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'r' is empty. Cannot save GIF to {'examples/images/blend.pgm'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/images/blend.pgm")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/images/blend.pgm")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'r'.")
