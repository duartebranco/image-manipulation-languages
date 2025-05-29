# C PROJ - IML

## Build

   ```bash
   cd src/iiml
   antlr4-build -python
   cd ../iml
   antlr4-build
   ```

or run `build.sh`

## Clean

   ```bash
   cd src/iiml
   antlr4-clean -python
   cd ../iml
   antlr4-clean
   ```

or run `clean.sh`

### Tests

To convert all iml tests:
   ```bash
   cd src/iml
   for f in ../../examples/*.iml; do java imlMain "$f"; done
   ```

or run `tests.sh`

- [x] `min-01.iml`
- [x] `min-02.iml`
- [x] `min-02-new.iml`
- [ ] `min-03.iml` (preciso 2ª gramatica)
- [x] `min-03-new.iml`
- [ ] `min-04.iml` (preciso 2ª gramatica)
- [x] `des-01.iml`
- [x] `des-02.iml`
- [x] `des-03.iml`
- [ ] `des-04.iml` (preciso 2ª gramatica)
- [x] `des-05.iml`
- [x] `des-06.iml`
- [ ] `min-01.iiml`(2ª gramatica)
- [ ] `min-iiml-01.iiml`(2ª gramatica)
- [ ] `min-iiml-02.iiml`(2ª gramatica)
- [ ] `des-iiml-01.iiml`(2ª gramatica)
