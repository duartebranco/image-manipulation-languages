# C PROJ - IML

## Build

   ```bash
   cd src/iiml
   antlr4-build -python
   cd ../iml
   antlr4-build
   for f in ../../examples/*.iml; do java imlMain "$f"; done
   ```

## Clean

   ```bash
   cd src/iiml
   antlr4-clean -python
   cd ../iml
   antlr4-clean
   ```

### Tests

- [x] `min-01.iml`
- [x] `min-02.iml`
- [ ] `min-03.iml` (preciso 2ª gramatica)
- [x] `des-01.iml`
- [x] `des-02.iml`
- [x] `des-03.iml`
- [ ] `des-04.iml` (preciso 2ª gramatica)
- [x] `des-05.iml`
- [ ] `min-01.iiml`(2ª gramatica)
