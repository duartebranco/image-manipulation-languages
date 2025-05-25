#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i0 = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
i1 = np.array(Image.open("examples/" + ("images/sample01.pgm")).convert('L')) / 255.0
i0cols = i0.shape[1]
i1cols = i1.shape[1]
if i0cols != i1cols:
    i0 = np.array(Image.fromarray(i0).resize((int(i0.shape[1] * (i1cols / i0cols)), i0.shape[0])))
i0rows = i0.shape[0]
i1rows = i1.shape[0]
if i0rows != i1rows:
    i0 = np.array(Image.fromarray(i0).resize((i0.shape[1], int(i0.shape[0] * (i1rows / i0rows)))))
r = i0 * (30/100) + (70/100) * i1
if isinstance(r, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in r]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/blend.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'r' is empty. Cannot save GIF to {'examples/images/blend.pgm'}")
elif isinstance(r, np.ndarray):
    Image.fromarray(np.clip((r) * 255, 0, 255).astype(np.uint8)).save("examples/images/blend.pgm")
else:
    print(f"Error: Cannot store type {type(r)} as image/GIF for expression 'r'.")
