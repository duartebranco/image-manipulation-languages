#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
print(i)
Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8)).show()
if isinstance(i, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame, 0, 255).astype(np.uint8)) for _frame in i]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/copy_sample00.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'i' is empty. Cannot save GIF to {'examples/images/copy_sample00.pgm'}")
elif isinstance(i, np.ndarray):
    Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8)).save("examples/images/copy_sample00.pgm")
else:
    print(f"Error: Cannot store type {type(i)} as image/GIF for expression 'i'.")
