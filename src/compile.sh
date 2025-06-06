#!/bin/bash
set -e

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Check if filepath argument is provided
if [ $# -eq 0 ]; then
    echo "Usage: $0 <filepath>"
    echo "Example: $0 ../examples/min-01.iml"
    exit 1
fi

filepath="$1"

# Check if file exists
if [ ! -f "$filepath" ]; then
    echo "Error: File '$filepath' not found."
    exit 1
fi

# Convert filepath to absolute path
absolute_filepath="$(cd "$(dirname "$filepath")" && pwd)/$(basename "$filepath")"

# Change to the iml directory and run imlMain
cd "$SCRIPT_DIR/iml/"
java imlMain "$absolute_filepath"