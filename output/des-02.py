#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + (input("Path: "))).convert('L')) / 255.0
k = np.array(Image.open("examples/" + ("images/kernel00.pgm")).convert('L')) / 255.0
l = []
while (np.any(i > 0)):
    Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8)).show()
    k = np.array(k, dtype=np.uint8)
    _temp0 = cv2.erode(i, k, iterations=1)
    i = _temp0
    l.append(i)
if isinstance(l, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame, 0, 255).astype(np.uint8)) for _frame in l]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/animation.gif", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'l' is empty. Cannot save GIF to {'examples/animation.gif'}")
elif isinstance(l, np.ndarray):
    Image.fromarray(np.clip((l) * 255, 0, 255).astype(np.uint8)).save("examples/animation.gif")
else:
    print(f"Error: Cannot store type {type(l)} as image/GIF for expression 'l'.")
