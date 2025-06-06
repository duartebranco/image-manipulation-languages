#!/bin/bash
set -e

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "Building IIML (Python)..."
cd "$SCRIPT_DIR/iiml/"
antlr4-build -python

echo "Building IML (Java)..."
cd "$SCRIPT_DIR/iml"
antlr4-build

echo "Build complete."