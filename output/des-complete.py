#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2
import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../src/iiml')))
from src.iiml.run_iiml import run_iiml_program

i = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/sample00.pgm")
k = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/sample01.pgm")
gt = i > k
img_draw = gt
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
lt = i < k
img_draw = lt
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
eq = i == k
img_draw = eq
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
neq = i != k
img_draw = neq
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
and_img = (i > 0.5) & (k > 0.5)
img_draw = and_img
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
or_img = ((i > 0.5)) | ((k > 0.5))
img_draw = or_img
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
not_img = ~(i > 0.5)
img_draw = not_img
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
if np.any(i > 0.5):
    print("Há pelo menos um pixel acima de 0.5")
if np.all(i > 0.5):
    print("Todos os pixeis acima de 0.5")
else:
    print("Nem todos os pixeis acima de 0.5")
n_white = np.sum(i == 1)
print("Pixeis brancos: " + str(n_white))
n_black = np.sum(i == 0)
print("Pixeis pretos: " + str(n_black))
if n_white > n_black:
    print("Mais brancos que pretos")
else:
    print("Mais pretos que brancos")
numbers = [1, 2, 3, 4]
numbers.append(5)
print("Lista: " + str(numbers))
l2d = [[1, 2], [3, 4]]
print("Elemento (1,2): " + str(l2d[1][1]))
img1 = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/sample00.pgm")
img2 = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/sample01.pgm")
imgs = [img1, img2]
img_store = imgs
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/anim.gif", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'imgs' is empty. Cannot save GIF to {'examples/images/anim.gif'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/images/anim.gif")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/images/anim.gif")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'imgs'.")
for x in numbers:
    print("Elemento: " + str(x))
nk = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/kernel00.pgm")
nk = np.array(nk, dtype=np.uint8)
_temp0 = cv2.morphologyEx((i * 255).astype(np.uint8), cv2.MORPH_TOPHAT, nk).astype(np.float32) / 255.0
top_hat = _temp0
img_draw = top_hat
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
nk = np.array(nk, dtype=np.uint8)
_temp1 = cv2.morphologyEx((i * 255).astype(np.uint8), cv2.MORPH_BLACKHAT, nk).astype(np.float32) / 255.0
black_hat = _temp1
img_draw = black_hat
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
