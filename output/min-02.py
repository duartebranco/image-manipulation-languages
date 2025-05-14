#!/usr/bin/env python3
from PIL import Image
import numpy as np

i0 = np.array(Image.open("examples/images/sample00.pgm").convert('L'))
i1 = np.array(Image.open("examples/images/sample01.pgm").convert('L'))
i0cols = i0.shape[1]
i1cols = i1.shape[1]
if i1cols:
    i0 = np.repeat(i0, int(null), axis=1)
i0rows = i0.shape[0]
i1rows = i1.shape[0]
if i1rows:
    i0 = np.repeat(i0, int(null), axis=0)
r = (((i0 * (30/100)) + (70/100)) * i1)
Image.fromarray(r).save("examples/images/blend.pgm")
