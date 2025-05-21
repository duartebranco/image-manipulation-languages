# C PROJ - IML

## TEST iml

   ```bash
    cd src/iml
    antlr4-build
    java imlMain ../../examples/***
    cd ../..
    python3 output/***
   ```

## TODO

### IML - Linguagem Compilada

#### Características mínimas

- [ ] Suporte ao tipo `image`, com representação em tons de cinzento no intervalo `[0, 1]`
- [ ] Instruções:
  - [x] `image i is load from "ficheiro.pgm"`
  - [x] `i store into "ficheiro.pgm"`
  - [x] `draw i`
  - [x] `output expr`
  - [x] `read "mensagem"`
  - [ ] Execução da linguagem IIML com `run from "ficheiro.iiml"`
- [ ] Operações pixel a pixel:
  - [ ] `.+`, `.-`, `.*`, etc.
- [ ] Operações de escala e flip:
  - [ ] `-*`, `|*`, `+*`, `-`, `|`, `+`
- [ ] Operações morfológicas:
  - [ ] `erode`, `dilate`, `open`, `close`
- [ ] Expressões aritméticas padrão (`+`, `-`, `*`, `/`) para `number` e `percentage`
- [ ] Concatenar strings com `+`
- [ ] Conversões: `number("10")`, `string(10)`
- [ ] Sistema de tipos com verificação semântica
- [ ] Suporte a `if`, `for`, `until`
  
#### Características desejáveis

- [ ] Expressões booleanas com operadores de comparação e lógicos
- [ ] Instruções condicionais com expressões booleanas
- [ ] Operadores:
  - [x] `any pixel expr > n`
  - [ ] `all pixel expr > n`
  - [ ] `count pixel expr in imagem`
- [ ] Suporte ao tipo `list of T`
- [ ] Operações com listas (acesso, adição, remoção)
- [ ] Listas de listas (para matrizes)
- [ ] Indexação recursiva
- [ ] Exportar lista de imagens como `.gif`
- [ ] Instruções iterativas: `for`, `until`
- [ ] Operações morfológicas adicionais: `top hat`, `black hat`
  
#### Características avançadas

- [ ] Funções com variáveis locais
- [ ] Tabela de símbolos com resolução de contextos
- [ ] Tratamento de erros (e.g., `File not found`)
- [ ] Suporte a imagens a cores (RGB) com as mesmas operações

#### Testes

- [x] `min-01.iml`
- [x] `min-02.iml`
- [ ] `min-03.iml` (preciso 2ª gramatica)
- [x] `des-01.iml`
- [x] `des-02.iml`
- [x] `des-03.iml`
- [ ] `des-04.iml` (preciso 2ª gramatica)
- [x] `des-05.iml`
- [ ] `min-01.iiml`