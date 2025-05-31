#!/bin/bash
set -e

echo "Cleaning IIML (Python)..."
cd src/iiml
antlr4-clean -python &&

echo "Cleaning IML (Java)..."
cd ../iml
antlr4-clean

echo "Clean complete."