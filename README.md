# C PROJ - IML

## 2 Grammars

iml.g4
iiml.g4

### TEST iml

cd src/iml
antlr4-build
java imlMain ../../examples/***
cd ../..
python3 output/***
