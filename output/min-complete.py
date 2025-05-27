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
nk = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/kernel00.pgm")
nk = np.array(nk, dtype=np.uint8)
_temp0 = cv2.morphologyEx(i, cv2.MORPH_OPEN, nk)
nk = np.array(nk, dtype=np.uint8)
_temp1 = cv2.morphologyEx((_temp0), cv2.MORPH_CLOSE, nk)
i2 = _temp1
img_draw = i2
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
nk = np.array(nk, dtype=np.uint8)
_temp2 = cv2.morphologyEx(i, cv2.MORPH_OPEN, nk)
opened = _temp2
img_draw = opened
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
nk = np.array(nk, dtype=np.uint8)
_temp3 = cv2.morphologyEx(i, cv2.MORPH_CLOSE, nk)
closed = _temp3
img_draw = closed
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
nk = np.array(nk, dtype=np.uint8)
if i.ndim == 3:
    _temp4 = np.stack([cv2.erode(i[...,c], nk, iterations=1) for c in range(i.shape[2])], axis=-1)
else:
    _temp4 = cv2.erode(i, nk, iterations=1)
eroded = _temp4
img_draw = eroded
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
nk = np.array(nk, dtype=np.uint8)
_temp5 = cv2.dilate(i, nk, iterations=1)
dilated = _temp5
img_draw = dilated
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
sum = i + k
img_draw = sum
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
diff = i - k
img_draw = diff
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
prod = i * k
img_draw = prod
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
div = i / k
img_draw = div
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
neg = 1.0 - i
img_draw = neg
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
_temp6 = np.flipud(i)
flippedV = _temp6
img_draw = flippedV
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
_temp7 = np.fliplr(i)
flippedH = _temp7
img_draw = flippedH
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
_temp8 = np.flipud(np.fliplr(i))
flipped = _temp8
img_draw = flipped
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
if i.ndim == 2:
    _temp9 = np.array(Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8)).resize((i.shape[1], int(i.shape[0] * (50/100))))) / 255.0
else:
    _temp9 = np.array(Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8), mode='RGB').resize((i.shape[1], int(i.shape[0] * (50/100))))) / 255.0
scaledV = _temp9
img_draw = scaledV
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
if i.ndim == 2:
    _temp10 = np.array(Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8)).resize((int(i.shape[1] * (50/100)), i.shape[0]))) / 255.0
else:
    _temp10 = np.array(Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8), mode='RGB').resize((int(i.shape[1] * (50/100)), i.shape[0]))) / 255.0
scaledH = _temp10
img_draw = scaledH
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
if i.ndim == 2:
    _temp11 = np.array(Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8)).resize((int(i.shape[1] * (50/100)), int(i.shape[0] * (50/100))))) / 255.0
else:
    _temp11 = np.array(Image.fromarray(np.clip((i) * 255, 0, 255).astype(np.uint8), mode='RGB').resize((int(i.shape[1] * (50/100)), int(i.shape[0] * (50/100))))) / 255.0
scaled = _temp11
img_draw = scaled
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
n = 42
p = (30/100)
s = "Hello"
b = True
soma = n + 8
p2 = p + (20/100)
mult = n * 2
p3 = p * 2
s2 = str(n)
print(s2)
n2 = float("10")
print(n2)
s3 = "Cols: " + str(i.shape[1]) + ", Rows: " + str(i.shape[0])
print(s3)
print("Introduza um número:")
userNum = float(input("Número: "))
print(userNum)
cols = i.shape[1]
rws = i.shape[0]
print("Dimensões: " + str(cols) + " x " + str(rws))
if np.any(i > 0):
    print("Image is not empty")
else:
    print("Image is blank")
counter = 0
while (counter == 3):
    print(counter)
    counter = counter + 1
for x in [1, 2, 3]:
    print(x)
kernel = run_iiml_program("examples/min-01.iiml")
img_draw = kernel
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
result = (i * (50/100)) + (k * (50/100))
img_store = result
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/blended_result.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'result' is empty. Cannot save GIF to {'examples/images/blended_result.pgm'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/images/blended_result.pgm")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/images/blended_result.pgm")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'result'.")
img_draw = result
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
