#!/bin/bash
source "$(dirname "$0")/.env"
shopt -s expand_aliases
set -e

echo "Cleaning IIML (Python)..."
cd "$SCRIPT_DIR/../src/iiml"
antlr4-clean -python

echo "Cleaning IML (Java)..."
cd "$SCRIPT_DIR/../src/iml"
antlr4-clean

echo "Clean complete."
