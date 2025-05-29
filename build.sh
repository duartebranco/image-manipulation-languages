#!/bin/bash
set -e

echo "Building IIML (Python)..."
cd src/iiml
antlr4-build -python

echo "Building IML (Java)..."
cd ../iml
antlr4-build

echo "Build complete."