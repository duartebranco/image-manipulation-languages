#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

def soma(a, b):
    x = a + b
    print("x local na função soma: " + str(x))
    return x

def usaGlobal():
    print("x global dentro da função usaGlobal: " + str(x))
    y = x + 1
    print("y local: " + str(y))
    return y

def testLocalScope():
    z = 99
    print("z local: " + str(z))
    return z

x = 10
print("x global antes: " + str(x))
res = soma(3, 4)
print("resultado de soma(3, 4): " + str(res))
print("x global depois: " + str(x))
y = usaGlobal()
print("y global: " + str(y))
z = 5
print("z global antes: " + str(z))
zFunc = testLocalScope()
print("z global depois: " + str(z))
print("z retornado pela função: " + str(zFunc))
rgb = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/color_sample.ppm")
img_draw = rgb
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
img_store = rgb
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/rgb_copy.ppm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'rgb' is empty. Cannot save GIF to {'examples/images/rgb_copy.ppm'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/images/rgb_copy.ppm")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/images/rgb_copy.ppm")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'rgb'.")
rgb_neg = 1.0 - rgb
img_draw = rgb_neg
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
rgb_bright = rgb + 0.2
img_draw = rgb_bright
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
rgb_dark = rgb - 0.2
img_draw = rgb_dark
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
_temp0 = np.fliplr(rgb)
rgb_flipH = _temp0
img_draw = rgb_flipH
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
_temp1 = np.flipud(rgb)
rgb_flipV = _temp1
img_draw = rgb_flipV
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
if rgb.ndim == 2:
    _temp2 = np.array(Image.fromarray(np.clip((rgb) * 255, 0, 255).astype(np.uint8)).resize((int(rgb.shape[1] * 0.5), int(rgb.shape[0] * 0.5)))) / 255.0
else:
    _temp2 = np.array(Image.fromarray(np.clip((rgb) * 255, 0, 255).astype(np.uint8), mode='RGB').resize((int(rgb.shape[1] * 0.5), int(rgb.shape[0] * 0.5)))) / 255.0
rgb_scaled = _temp2
img_draw = rgb_scaled
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
r_channel = rgb[0]
g_channel = rgb[1]
b_channel = rgb[2]
img_draw = r_channel
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
img_draw = g_channel
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
img_draw = b_channel
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
kernel = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/kernel00.pgm")
kernel = np.array(kernel, dtype=np.uint8)
if rgb.ndim == 3:
    _temp3 = np.stack([cv2.erode(rgb[...,c], kernel, iterations=1) for c in range(rgb.shape[2])], axis=-1)
else:
    _temp3 = cv2.erode(rgb, kernel, iterations=1)
rgb_eroded = _temp3
img_draw = rgb_eroded
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
kernel = np.array(kernel, dtype=np.uint8)
_temp4 = cv2.dilate(rgb, kernel, iterations=1)
rgb_dilated = _temp4
img_draw = rgb_dilated
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
kernel = np.array(kernel, dtype=np.uint8)
_temp5 = cv2.morphologyEx(rgb, cv2.MORPH_OPEN, kernel)
rgb_opened = _temp5
img_draw = rgb_opened
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
kernel = np.array(kernel, dtype=np.uint8)
_temp6 = cv2.morphologyEx(rgb, cv2.MORPH_CLOSE, kernel)
rgb_closed = _temp6
img_draw = rgb_closed
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
kernel = np.array(kernel, dtype=np.uint8)
_temp7 = cv2.morphologyEx((rgb * 255).astype(np.uint8), cv2.MORPH_TOPHAT, kernel).astype(np.float32) / 255.0
rgb_tophat = _temp7
img_draw = rgb_tophat
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
kernel = np.array(kernel, dtype=np.uint8)
_temp8 = cv2.morphologyEx((rgb * 255).astype(np.uint8), cv2.MORPH_BLACKHAT, kernel).astype(np.float32) / 255.0
rgb_blackhat = _temp8
img_draw = rgb_blackhat
if img_draw.ndim == 2:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()
else:
    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()
img_store = rgb_neg
if isinstance(img_store, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/rgb_neg.ppm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'rgb_neg' is empty. Cannot save GIF to {'examples/images/rgb_neg.ppm'}")
elif isinstance(img_store, np.ndarray):
    if img_store.ndim == 2:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save("examples/images/rgb_neg.ppm")
    else:
        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save("examples/images/rgb_neg.ppm")
else:
    print(f"Error: Cannot store type {type(img_store)} as image/GIF for expression 'rgb_neg'.")
try:
    i = (lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)("images/nao_existe.ppm")
except Exception as e:
    print("File not found.")
    exit()
