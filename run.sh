#!/bin/bash

# Console colors
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m'

# Main Menu
show_menu() {
    clear
    echo -e "${BLUE}===============================================${NC}"
    echo -e "${GREEN}      ANTLR Build and Run Script Menu${NC}"
    echo -e "${BLUE}===============================================${NC}"
    echo -e "1. Clean ANTLR generated files (iiml)"
    echo -e "2. Clean ANTLR generated files (iml)"
    echo -e "3. Generate ANTLR files with visitor (iiml)"
    echo -e "4. Generate ANTLR files with visitor (iml)"
    echo -e "5. Compile IIML Java files only"
    echo -e "6. Compile IML Java files only" 
    echo -e "7. Compile all Java files"
    echo -e "8. Run iiml interpreter (min-01.iiml example)"
    echo -e "9. Run iiml interpreter (custom input file)"
    echo -e "10. Run iml compiler (min-01.iml example)"
    echo -e "11. Run iml compiler (custom input file)"
    echo -e "12. Display parse tree GUI for iiml file"
    echo -e "13. Display parse tree GUI for iml file"
    echo -e "0. Exit"
    echo -e "${BLUE}===============================================${NC}"
    echo -e "Enter your choice: "
}

clean_iiml() {
    echo -e "${YELLOW}Cleaning IIML generated files...${NC}"
    cd src/iiml
    rm -f *.tokens *.interp iimlLexer.java iimlParser.java iimlBaseListener.java iimlListener.java iimlBaseVisitor.java iimlVisitor.java
    rm -f *.class
    cd ../..
    echo -e "${GREEN}IIML files cleaned successfully!${NC}"
}

clean_iml() {
    echo -e "${YELLOW}Cleaning IML generated files...${NC}"
    cd src/iml
    rm -f *.tokens *.interp imlLexer.java imlParser.java imlBaseListener.java imlListener.java imlBaseVisitor.java imlVisitor.java
    rm -f *.class
    cd ../..
    echo -e "${GREEN}IML files cleaned successfully!${NC}"
}

generate_iiml() {
    echo -e "${YELLOW}Generating IIML ANTLR files with visitor...${NC}"
    java -jar lib/antlr-4.13.1-complete.jar -visitor -no-listener src/iiml/iiml.g4
    echo -e "${GREEN}IIML ANTLR files generated successfully!${NC}"
}

generate_iml() {
    echo -e "${YELLOW}Generating IML ANTLR files with visitor...${NC}"
    java -jar lib/antlr-4.13.1-complete.jar -visitor -no-listener src/iml/iml.g4
    echo -e "${GREEN}IML ANTLR files generated successfully!${NC}"
}

compile_iiml() {
    echo -e "${YELLOW}Compiling IIML Java files only...${NC}"
    javac -cp lib/antlr-4.13.1-complete.jar -d bin src/iiml/*.java 2> compile_iiml_errors.log
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}IIML compilation successful!${NC}"
    else
        echo -e "${RED}IIML compilation failed! See compile_iiml_errors.log for details.${NC}"
        cat compile_iiml_errors.log
    fi
}

compile_iml() {
    echo -e "${YELLOW}Compiling IML Java files only...${NC}"
    javac -cp lib/antlr-4.13.1-complete.jar -d bin src/iml/*.java 2> compile_iml_errors.log
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}IML compilation successful!${NC}"
    else
        echo -e "${RED}IML compilation failed! See compile_iml_errors.log for details.${NC}"
        cat compile_iml_errors.log
    fi
}

compile_files() {
    echo -e "${YELLOW}Compiling all Java files...${NC}"
    javac -cp lib/antlr-4.13.1-complete.jar -d bin src/iiml/*.java src/iml/*.java 2> compile_errors.log
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}Compilation successful!${NC}"
    else
        echo -e "${RED}Compilation failed! See compile_errors.log for details.${NC}"
        cat compile_errors.log
    fi
}

run_iiml_example() {
    echo -e "${YELLOW}Running IIML interpreter with default example...${NC}"
    java -cp lib/antlr-4.13.1-complete.jar:bin iimlMain examples/min-01.iiml
}

run_iiml_custom() {
    echo -e "${YELLOW}Enter the path to your IIML file:${NC}"
    read iiml_file
    
    if [ -f "$iiml_file" ]; then
        echo -e "${YELLOW}Running IIML interpreter with $iiml_file...${NC}"
        java -cp lib/antlr-4.13.1-complete.jar:bin iimlMain "$iiml_file"
    else
        echo -e "${RED}File not found: $iiml_file${NC}"
    fi
}

run_iml_example() {
    echo -e "${YELLOW}Running IML compiler with default example...${NC}"
    java -cp lib/antlr-4.13.1-complete.jar:bin imlMain examples/min-01.iml
}

run_iml_custom() {
    echo -e "${YELLOW}Enter the path to your IML file:${NC}"
    read iml_file
    
    if [ -f "$iml_file" ]; then
        echo -e "${YELLOW}Running IML compiler with $iml_file...${NC}"
        java -cp lib/antlr-4.13.1-complete.jar:bin imlMain "$iml_file"
    else
        echo -e "${RED}File not found: $iml_file${NC}"
    fi
}

display_iiml_tree() {
    echo -e "${YELLOW}Enter the path to your IIML file:${NC}"
    read iiml_file
    
    if [ -f "$iiml_file" ]; then
        echo -e "${YELLOW}Displaying parse tree for $iiml_file...${NC}"
        java -cp lib/antlr-4.13.1-complete.jar:bin org.antlr.v4.gui.TestRig iiml program -gui "$iiml_file"
    else
        echo -e "${RED}File not found: $iiml_file${NC}"
    fi
}

display_iml_tree() {
    echo -e "${YELLOW}Enter the path to your IML file:${NC}"
    read iml_file
    
    if [ -f "$iml_file" ]; then
        echo -e "${YELLOW}Displaying parse tree for $iml_file...${NC}"
        java -cp lib/antlr-4.13.1-complete.jar:bin org.antlr.v4.gui.TestRig iml program -gui "$iml_file"
    else
        echo -e "${RED}File not found: $iml_file${NC}"
    fi
}

# Main Loop
while true; do
    show_menu
    read -r choice
    
    case $choice in
        1) clean_iiml ;;
        2) clean_iml ;;
        3) generate_iiml ;;
        4) generate_iml ;;
        5) compile_iiml ;;
        6) compile_iml ;;
        7) compile_files ;;
        8) run_iiml_example ;;
        9) run_iiml_custom ;;
        10) run_iml_example ;;
        11) run_iml_custom ;;
        12) display_iiml_tree ;;
        13) display_iml_tree ;;
        0) echo -e "${GREEN}Exiting script. Goodbye!${NC}" ; exit 0 ;;
        *) echo -e "${RED}Invalid option. Please try again.${NC}" ; sleep 2 ;;
    esac
    
    echo
    echo -e "${YELLOW}Press Enter to continue...${NC}"
    read -r
done

# fuck it we ball