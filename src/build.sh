#!/bin/bash
source "$(dirname "$0")/.env"
shopt -s expand_aliases
set -e

echo "Building IIML (Python)..."
cd "$SCRIPT_DIR/iiml/"
antlr4-build -python

echo "Building IML (Java)..."
cd "$SCRIPT_DIR/iml"
antlr4-build

echo "Build complete."
