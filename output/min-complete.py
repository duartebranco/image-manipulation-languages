#!/usr/bin/env python3
from PIL import Image
import numpy as np
import cv2

i = np.array(Image.open("examples/" + ("images/sample00.pgm")).convert('L')) / 255.0
k = np.array(Image.open("examples/" + ("images/sample01.pgm")).convert('L')) / 255.0
nk = np.array(Image.open("examples/" + ("images/kernel00.pgm")).convert('L')) / 255.0
nk = np.array(nk, dtype=np.uint8)
_temp0 = cv2.morphologyEx(i, cv2.MORPH_OPEN, nk)
nk = np.array(nk, dtype=np.uint8)
_temp1 = cv2.morphologyEx((_temp0), cv2.MORPH_CLOSE, nk)
i2 = _temp1
Image.fromarray(np.clip((i2) * 255, 0, 255).astype(np.uint8)).show()
nk = np.array(nk, dtype=np.uint8)
_temp2 = cv2.morphologyEx(i, cv2.MORPH_OPEN, nk)
opened = _temp2
Image.fromarray(np.clip((opened) * 255, 0, 255).astype(np.uint8)).show()
nk = np.array(nk, dtype=np.uint8)
_temp3 = cv2.morphologyEx(i, cv2.MORPH_CLOSE, nk)
closed = _temp3
Image.fromarray(np.clip((closed) * 255, 0, 255).astype(np.uint8)).show()
nk = np.array(nk, dtype=np.uint8)
_temp4 = cv2.erode(i, nk, iterations=1)
eroded = _temp4
Image.fromarray(np.clip((eroded) * 255, 0, 255).astype(np.uint8)).show()
nk = np.array(nk, dtype=np.uint8)
_temp5 = cv2.dilate(i, nk, iterations=1)
dilated = _temp5
Image.fromarray(np.clip((dilated) * 255, 0, 255).astype(np.uint8)).show()
sum = i + k
Image.fromarray(np.clip((sum) * 255, 0, 255).astype(np.uint8)).show()
diff = i - k
Image.fromarray(np.clip((diff) * 255, 0, 255).astype(np.uint8)).show()
prod = i * k
Image.fromarray(np.clip((prod) * 255, 0, 255).astype(np.uint8)).show()
div = i / k
Image.fromarray(np.clip((div) * 255, 0, 255).astype(np.uint8)).show()
neg = 1.0 - i
Image.fromarray(np.clip((neg) * 255, 0, 255).astype(np.uint8)).show()
_temp6 = np.flipud(i)
flippedV = _temp6
Image.fromarray(np.clip((flippedV) * 255, 0, 255).astype(np.uint8)).show()
_temp7 = np.fliplr(i)
flippedH = _temp7
Image.fromarray(np.clip((flippedH) * 255, 0, 255).astype(np.uint8)).show()
_temp8 = np.flipud(np.fliplr(i))
flipped = _temp8
Image.fromarray(np.clip((flipped) * 255, 0, 255).astype(np.uint8)).show()
scaledV = np.array(Image.fromarray(i).resize((i.shape[1], int(i.shape[0] * (50/100)))))
Image.fromarray(np.clip((scaledV) * 255, 0, 255).astype(np.uint8)).show()
scaledH = np.array(Image.fromarray(i).resize((int(i.shape[1] * (50/100)), i.shape[0])))
Image.fromarray(np.clip((scaledH) * 255, 0, 255).astype(np.uint8)).show()
scaled = np.array(Image.fromarray(i).resize((int(i.shape[1] * (50/100)), int(i.shape[0] * (50/100)))))
Image.fromarray(np.clip((scaled) * 255, 0, 255).astype(np.uint8)).show()
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
Image.fromarray(np.clip((kernel) * 255, 0, 255).astype(np.uint8)).show()
result = (i * (50/100)) + (k * (50/100))
if isinstance(result, list):
    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in result]
    if _pil_images_for_gif:
        _pil_images_for_gif[0].save("examples/images/blended_result.pgm", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)
    else:
        print(f"Warning: Image list 'result' is empty. Cannot save GIF to {'examples/images/blended_result.pgm'}")
elif isinstance(result, np.ndarray):
    Image.fromarray(np.clip((result) * 255, 0, 255).astype(np.uint8)).save("examples/images/blended_result.pgm")
else:
    print(f"Error: Cannot store type {type(result)} as image/GIF for expression 'result'.")
Image.fromarray(np.clip((result) * 255, 0, 255).astype(np.uint8)).show()
