# rules to the game

## 0. Create Grammar and test
### test (after building)
antlr4-build
echo "coisas para testar" | antlr4-test -gui
antlr4-clean
## 1. Create Visitor

antlr4-visitor <Grammer-g4-filename> <nome-visitor> <visitor-type>

## (1.1 Create Listener)

antlr4-listener <Grammer-g4-filename> <nome-listener>

## 2. Create Main

antlr4-main <Grammer-g4-filename> <first-start-rule-name> -v <nome-visitor>
                                                          -l <nome-listener>

## 3. Build

antlr4-build

## 4. Run and test

antlr4-run - CtrlD
ou 
echo "coisas" | antlr4-run
ou

antlr4-test [<Grammar> <rule>] [-tokens | -tree | -gui]


