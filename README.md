# C PROJ - IML

## TEST iml

   ```bash
    cd src/iml
    antlr4-build
    java imlMain ../../examples/***
    cd ../..
    python3 output/***
   ```

### Testes

for f in ../../examples/{min-0{1..3},des-0{1..5}}.iml; do java imlMain "$f"; done

- [x] `min-01.iml`
- [x] `min-02.iml`
- [ ] `min-03.iml` (preciso 2ª gramatica)
- [x] `des-01.iml`
- [x] `des-02.iml`
- [x] `des-03.iml`
- [ ] `des-04.iml` (preciso 2ª gramatica)
- [x] `des-05.iml`
- [ ] `min-01.iiml`(2ª gramatica)
