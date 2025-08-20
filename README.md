# IML & IIML - Image Manipulation Languages

Two domain-specific programming languages for **image processing** and **mathematical morphology operations**.

**IML (Image Manipulation Language)** - A **compiled language** for advanced image processing

**iiml (Interpreted Image Manipulation Language)** - A simpler **interpreted language** for basic image creation

## Languages

### IML - Compiled Language
IML is a feature-rich language that compiles to `Python`, designed for complex image processing tasks including mathematical morphology, pixel operations, and image analysis.

**Key Features:**
- Mathematical morphology operations (open, close, dilate, erode, top/black hat)
- Pixel-wise arithmetic and boolean operations (`.+`, `.-`, `.*`, `.>`, `.&`, etc.)
- Image transformations (flip, scale, rotate)
- Control flow (if/else, for/until loops, try/catch, functions)
- Image analysis (pixel counting, conditional checks)
- Support for multiple data types: `image`, `number`, `string`, `percentage`, `boolean`, `list`
- File I/O for PGM, PPM, and other image formats
- GIF animation creation

**Example:**
```iml
// Load images and apply morphological operations
image i is load from "images/sample00.pgm"
image k is load from "images/kernel00.pgm"

// Clean noise with opening then closing
image clean is (i open by k) close by k

// Check if image contains objects
if any pixel clean .> 0 then
    output "Image contains objects."
else
    output "No objects found."
done

draw clean
clean store into "images/result.pgm"
```

### IIML - Interpreted Language
IIML is a simpler language for creating images with basic geometric shapes, executed directly without compilation.

**Key Features:**
- Image canvas creation with custom size and background
- Shape drawing (circle, rectangle, cross, plus)
- Basic variable manipulation and user input
- Simple control flow

**Example:**
```iiml
// Create a 100x100 image with black background
image size 100 by 100 background 0

// Draw a white circle in the center
place circle radius 30 at 50 50 with intensity 1
```

## Project Structure

```
├── src/
│   ├── iml/                        # IML compiler (Java + ANTLR4)
│   │   ├── iml.g4                  # IML grammar
│   │   ├── imlMain.java            # Main compiler class
│   │   ├── CodeGenVisitor.java     # Visitor for generating Python code
│   │   └── ...
│   ├── iiml/                       # IIML interpreter (Python + ANTLR4)
│   │   ├── iiml.g4                 # IIML grammar
│   │   ├── iimlMain.py             # Main interpreter
│   │   ├── IimlEvalVisitor.py      # Expression evaluator
│   │   └── ...
│   ├── build.sh                    # Build both languages
│   ├── compile.sh                  # Compile IML to Python
│   └── run.sh                      # Execute generated Python
├── examples/                       # Example programs
│   ├── *.iml                       # IML example files
│   ├── *.iiml                      # IIML example files
│   └── images/                     # Sample images and outputs
├── output/                         # Generated Python files
└── doc/                            # Project documentation
```

## Prerequisites

- **Java 11+** (for IML compiler)
- **Python 3.8+** (for IIML interpreter and runtime)

### Python Dependencies
```bash
pip install numpy opencv-python
```

## Quick Start

### 1. Build the Languages
```bash
cd src
./build.sh
```

### 2. Run IML Programs
```bash
# Compile IML to Python
./compile.sh ../examples/min-01.iml

# Execute the generated Python
./run.sh ../output/min-01.py
```

### 3. Run IIML Programs
```bash
cd iiml
python3 iimlMain.py ../../examples/min-01.iiml
```

### 4. Clean Compiled Files
```bash
cd src
./clean.sh
```

## Usage Examples

### Mathematical Morphology (IML)
```iml
image i is load from "images/noisy.pgm"
image kernel is load from "images/kernel.pgm"

// Remove small noise with opening
image opened is i open by kernel

// Fill small holes with closing
image cleaned is opened close by kernel

draw cleaned
cleaned store into "images/clean.pgm"
```

### Pixel Analysis (IML)
```iml
image img is load from "images/binary.pgm"

// Count white and black pixels
number whites is count pixel 1 in img
number blacks is count pixel 0 in img

output "White pixels: " + string(whites)
output "Black pixels: " + string(blacks)

// Check image properties
if all pixel img .> 0.5 then
    output "Image is mostly white"
done
```

### Shape Creation (IIML)
```iiml
// Create 200x200 canvas
image size 200 by 200 background 0

// Draw shapes
place circle radius 50 at 100 100 with intensity 0.8
place rect width 40 height 60 at 150 50 with intensity 0.6
```

## Language Reference

### IML Data Types
- `image` - 2D grayscale/color image arrays
- `number` - Floating-point numbers
- `string` - Text strings
- `percentage` - Values with % suffix (e.g., `50%`)
- `boolean` - `true`/`false` values
- `list of T` - Dynamic arrays of type T

### IML Operators
- **Arithmetic**: `+`, `-`, `*`, `/`
- **Pixel-wise**: `.*`, `.+`, `.-`, `.|`
- **Comparison**: `>`, `<`, `>=`, `<=`, `==`, `!=`
- **Pixel comparison**: `.>`, `.<`, `.==`, `.!=`
- **Boolean**: `.&` (and), `.|` (or), `.!` (not)
- **Morphology**: `open by`, `close by`, `dilate by`, `erode by`
- **Advanced**: `top hat by`, `black hat by`

### File Formats Supported
- **PGM** - Grayscale images
- **PPM** - Color images
- **GIF** - Animations (for image lists)

## Advanced Features

### Functions (IML)
```iml
function enhance(image img, number factor) returns image is
    image result is img .* factor
    return result
end

image enhanced is enhance(load from "images/dark.pgm", 2.0)
```

### Animation (IML)
```iml
image frame1 is load from "images/f1.pgm"
image frame2 is load from "images/f2.pgm"
list of image animation is [frame1, frame2]
animation store into "images/movie.gif"
```

### Error Handling (IML)
```iml
try
    image img is load from "images/missing.pgm"
catch
    output "Failed to load image"
end
```
