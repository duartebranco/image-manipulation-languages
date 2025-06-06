#!/bin/bash
set -e

echo "Converting all IML tests..."
cd src/iml
for f in ../../examples/*.iml; do
    echo "Processing $f"
    java imlMain "$f"
done

echo "IML Tests converted."