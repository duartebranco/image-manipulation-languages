# IML & IIML - Image Manipulation Languages

Two domain-specific programming languages for **image processing** and **mathematical morphology operations**:

- **IML (Image Manipulation Language)** - A **compiled language** for advanced image processing
- **IIML (Interpreted Image Manipulation Language)** - A simpler **interpreted language** for basic image creation

This project uses **ANTLR4** to define the **grammar syntax** through `.g4` grammar files, and to automatically generate **lexers** and **parsers** for both Java and Python targets.

For IML, ANTLR4 generates Java-based lexer/parser components that feed into a custom `CodeGenVisitor` (Visitor) class, which implements a [**transpiler**](https://en.wikipedia.org/wiki/Source-to-source_compiler) that converts IML source code into executable Python code.

For IIML, ANTLR4 generates Python-based parsing components that work with a custom `IimlEvalVisitor` to create a direct **interpreter** that executes image creation commands in real-time.

ANTLR4 is already installed and configured in the project as a wrapper made by Professor Miguel Oliveira e Silva.

## Languages

### IML - Compiled Language

IML is a feature-rich language that compiles to `Python`, designed for complex image processing tasks including mathematical morphology, pixel operations, and image analysis.

For this project, our Professor divided the language features into these three categories:

**Minimal Features:**

- Load and save grayscale images (`.pgm`) (`load`, `store`)
- Support for multiple data types (`image`, `number`, `string`, `percentage`, `boolean`, `list`)
- Pixel-wise arithmetic operations (`.+`, `.-`, `.*`, `.|`)
- Morphological operations (`erode`, `dilate`, `open`, `close`)
- Image flipping (vertical, horizontal, both) (`-`, `|`, `+`)
- Image scaling (vertical, horizontal, both) (`|*`, `-*`, `+*`)
- Standard arithmetic expressions (`+`, `*`) and string concatenation
- Input/output instructions
- Type conversion
- Draw images (`draw`)
- Execute secondary interpreted language (iiml) (`run`)
- Conditional (`if`, `else`, `done`)

**Desirable Features:**

- Pixel Order Relation and Boolean Operators (`.>`, `.<`, `.==`, `.!=`, `.&`, `.|`, `.!`) (greater than, less than, equals, not equal to, and, or, not)
- `any` pixel and `all` pixel operators
- `count` pixel in operator
- Lists with insertion/removal of elements and indexing
- GIF animation creation, using lists of images
- For and Until loops (`for`, `until`)
- Additional morphology: `top-hat`, `black-hat`

**Advanced Features:**

- Functions and local variables
- Runtime error handling (e.g., file not found)
- Support for RGB color images with full operations

### IIML - Interpreted Language

IIML is a simpler language for creating images with basic geometric shapes, executed directly without compilation.

**Key Features:**

- Image canvas creation with custom size and background
- Shape drawing (`circle`, `rect`, `cross`, `plus`)
- Basic variable manipulation and user input
- Simple control flow

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
# Compile .iml files into .py (python) files
./compile.sh ../examples/min-01.iml

# Execute the converted python files
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

## Code Examples

All code examples (`.iml` and `.iiml`) for the project can be found in the `examples/` directory.

## Documentation

All documentation for the project can be found in the `doc/` directory, including a `Assignment.pdf` and a `Report.pdf`, which are written in Portuguese.

## Project Structure

```
├── src/
│   ├── bin/                        # ANTLR wrapper scripts
│   ├── lib/                        # ANTLR libraries
│   ├── iml/                        # IML
│   │   ├── iml.g4                  # IML grammar
│   │   ├── imlMain.java            # Main compiler class
│   │   ├── CodeGenVisitor.java     # Visitor for generating Python code
│   │   └── ...
│   ├── iiml/                       # IIML
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
