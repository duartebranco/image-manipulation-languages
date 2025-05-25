#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
k = np.array(Image.open("examples/" + ("images/sample01.pgm")).convert('L')) / 255.0
gt = i > k
Image.fromarray(np.clip((gt) * 255, 0, 255).astype(np.uint8)).show()
lt = i < k
Image.fromarray(np.clip((lt) * 255, 0, 255).astype(np.uint8)).show()
eq = i == k
Image.fromarray(np.clip((eq) * 255, 0, 255).astype(np.uint8)).show()
neq = i != k
Image.fromarray(np.clip((neq) * 255, 0, 255).astype(np.uint8)).show()
and_img = (i > 0.5) & (k > 0.5)
Image.fromarray(np.clip((and_img) * 255, 0, 255).astype(np.uint8)).show()
or_img = ((i > 0.5)) | ((k > 0.5))
Image.fromarray(np.clip((or_img) * 255, 0, 255).astype(np.uint8)).show()
not_img = ~(i > 0.5)
Image.fromarray(np.clip((not_img) * 255, 0, 255).astype(np.uint8)).show()
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
img1 = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
img2 = np.array(Image.open("examples/" + ("images/sample01.pgm")).convert('L')) / 255.0
imgs = [img1, img2]
if isinstance(imgs, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in imgs]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/anim.gif", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'imgs' is empty. Cannot save GIF to {'examples/images/anim.gif'}")
elif isinstance(imgs, np.ndarray):
    Image.fromarray(np.clip((imgs) * 255, 0, 255).astype(np.uint8)).save("examples/images/anim.gif")
else:
    print(f"Error: Cannot store type {type(imgs)} as image/GIF for expression 'imgs'.")
for x in numbers:
    print("Elemento: " + str(x))
nk = np.array(Image.open("examples/" + ("images/kernel00.pgm")).convert('L')) / 255.0
nk = np.array(nk, dtype=np.uint8)
_temp0 = cv2.morphologyEx((i * 255).astype(np.uint8), cv2.MORPH_TOPHAT, nk).astype(np.float32) / 255.0
top_hat = _temp0
Image.fromarray(np.clip((top_hat) * 255, 0, 255).astype(np.uint8)).show()
nk = np.array(nk, dtype=np.uint8)
_temp1 = cv2.morphologyEx((i * 255).astype(np.uint8), cv2.MORPH_BLACKHAT, nk).astype(np.float32) / 255.0
black_hat = _temp1
Image.fromarray(np.clip((black_hat) * 255, 0, 255).astype(np.uint8)).show()
