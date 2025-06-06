#!/bin/bash
set -e

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "Cleaning IIML (Python)..."
cd "$SCRIPT_DIR/../src/iiml"
antlr4-clean -python

echo "Cleaning IML (Java)..."
cd "$SCRIPT_DIR/../src/iml"
antlr4-clean

echo "Clean complete."