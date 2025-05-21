#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + (input("Path: "))).convert('L')) / 255.0
k = run_iiml_program(input("Path: "))
d = cv2.dilate(i, k, iterations=1)
e = cv2.erode(i, k, iterations=1)
r = d - e
p = r
print(null)
if isinstance(r, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame, 0, 255).astype(np.uint8)) for _frame in r]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/edges.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'r' is empty. Cannot save GIF to {'examples/images/edges.pgm'}")
elif isinstance(r, np.ndarray):
    Image.fromarray(np.clip(r, 0, 255).astype(np.uint8)).save("examples/images/edges.pgm")
else:
    print(f"Error: Cannot store type {type(r)} as image/GIF for expression 'r'.")
