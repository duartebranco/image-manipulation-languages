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
    echo -e "1. Clean ANTLR generated files (both iiml and iml)"
    echo -e "2. Generate ANTLR files with visitor (iiml)"
    echo -e "3. Generate ANTLR files with visitor and compile (iml)"
    echo -e "4. Run iiml interpreter (select file)"
    echo -e "5. Run iml compiler (select file)"
    echo -e "6. Display parse tree GUI for iiml file"
    echo -e "7. Display parse tree GUI for iml file"
    echo -e "8. Run Python output file"
    echo -e "0. Exit"
    echo -e "${BLUE}===============================================${NC}"
    echo -e "Enter your choice: "
}

# Add this new function to run Python output files
run_output_python() {
    # Check if output directory exists
    if [ ! -d "output" ]; then
        echo -e "${RED}Error: Output directory not found. Have you compiled any IML files yet?${NC}"
        return
    fi
    
    # Count Python files in output directory
    py_files=(output/*.py)
    py_count=${#py_files[@]}
    
    if [ $py_count -eq 0 ]; then
        echo -e "${RED}No Python output files found in output/ directory.${NC}"
        return
    fi
    
    echo -e "${YELLOW}Select a Python file to run:${NC}"
    
    # List available Python files
    for ((i=0; i<$py_count; i++)); do
        filename=$(basename "${py_files[$i]}")
        echo -e "$((i+1)). $filename"
    done
    
    echo -e "0. Enter custom file path"
    read -r choice
    
    if [ "$choice" -eq 0 ]; then
        echo -e "${YELLOW}Enter the path to your Python file:${NC}"
        read -r py_file
    elif [ "$choice" -ge 1 ] && [ "$choice" -le $py_count ]; then
        py_file="${py_files[$((choice-1))]}"
    else
        echo -e "${RED}Invalid option. Returning to main menu.${NC}"
        return
    fi
    
    if [ -f "$py_file" ]; then
        echo -e "${YELLOW}Running Python file: $py_file${NC}"
        python3 "$py_file"
    else
        echo -e "${RED}File not found: $py_file${NC}"
    fi
}

clean_all() {
    echo -e "${YELLOW}Cleaning all ANTLR generated files...${NC}"
    # Clean IIML files
    cd src/iiml
    rm -f *.tokens *.interp iimlLexer.py iimlParser.py iimlVisitor.py
    cd ../..
    
    # Clean IML files
    cd src/iml
    rm -f *.tokens *.interp imlLexer.java imlParser.java imlBaseListener.java imlListener.java imlBaseVisitor.java imlVisitor.java
    rm -f *.class
    cd ../..
    
    echo -e "${GREEN}All ANTLR files cleaned successfully!${NC}"
}

generate_iiml() {
    echo -e "${YELLOW}Generating IIML ANTLR files with visitor for Python...${NC}"
    java -jar lib/antlr-4.13.1-complete.jar -Dlanguage=Python3 -visitor -no-listener src/iiml/iiml.g4
    echo -e "${GREEN}IIML ANTLR files generated successfully!${NC}"
}

generate_and_compile_iml() {
    echo -e "${YELLOW}Generating IML ANTLR files with visitor...${NC}"
    java -jar lib/antlr-4.13.1-complete.jar -visitor src/iml/iml.g4
    echo -e "${GREEN}IML ANTLR files generated successfully!${NC}"
    
    echo -e "${YELLOW}Compiling IML Java files...${NC}"
    mkdir -p bin
    javac -cp lib/antlr-4.13.1-complete.jar -d bin src/iml/*.java 2> compile_iml_errors.log
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}IML compilation successful!${NC}"
    else
        echo -e "${RED}IML compilation failed! See compile_iml_errors.log for details.${NC}"
        cat compile_iml_errors.log
    fi
}

run_iiml() {
    echo -e "${YELLOW}Select an IIML file to run:${NC}"
    echo -e "1. min-01.iiml"
    echo -e "2. min-iiml-01.iiml"
    echo -e "3. min-iiml-02.iiml"
    echo -e "4. des-iiml-01.iiml"
    echo -e "0. Enter custom file path"
    read -r choice
    
    case $choice in
        1) iiml_file="examples/min-01.iiml" ;;
        2) iiml_file="examples/min-iiml-01.iiml" ;;
        3) iiml_file="examples/min-iiml-02.iiml" ;;
        4) iiml_file="examples/des-iiml-01.iiml" ;;
        0)
            echo -e "${YELLOW}Enter the path to your IIML file:${NC}"
            read -r iiml_file
            ;;
        *)
            echo -e "${RED}Invalid option. Returning to main menu.${NC}"
            return
            ;;
    esac
    
    if [ -f "$iiml_file" ]; then
        echo -e "${YELLOW}Running IIML interpreter with $iiml_file...${NC}"
        cd src/iiml
        python3 run_iiml.py ../../"$iiml_file"
        cd ../..
    else
        echo -e "${RED}File not found: $iiml_file${NC}"
    fi
}

run_iml() {
    # Check if examples directory exists
    if [ ! -d "examples" ]; then
        echo -e "${RED}Error: Examples directory not found.${NC}"
        return
    fi
    
    # Count IML files in examples directory
    iml_files=(examples/*.iml)
    iml_count=${#iml_files[@]}
    
    if [ $iml_count -eq 0 ]; then
        echo -e "${RED}No IML files found in examples/ directory.${NC}"
        return
    fi
    
    echo -e "${YELLOW}Select an IML file to run:${NC}"
    
    # List available IML files
    for ((i=0; i<$iml_count; i++)); do
        filename=$(basename "${iml_files[$i]}")
        echo -e "$((i+1)). $filename"
    done
    
    echo -e "0. Enter custom file path"
    read -r choice
    
    if [ "$choice" -eq 0 ]; then
        echo -e "${YELLOW}Enter the path to your IML file:${NC}"
        read -r iml_file
    elif [ "$choice" -ge 1 ] && [ "$choice" -le $iml_count ]; then
        iml_file="${iml_files[$((choice-1))]}"
    else
        echo -e "${RED}Invalid option. Returning to main menu.${NC}"
        return
    fi
    
    if [ -f "$iml_file" ]; then
        echo -e "${YELLOW}Running IML compiler with $iml_file...${NC}"
        java -cp lib/antlr-4.13.1-complete.jar:bin imlMain "$iml_file"
    else
        echo -e "${RED}File not found: $iml_file${NC}"
    fi
}

display_iiml_tree() {
    echo -e "${YELLOW}Select an IIML file to display parse tree:${NC}"
    echo -e "1. min-01.iiml"
    echo -e "2. min-iiml-01.iiml"
    echo -e "3. min-iiml-02.iiml"
    echo -e "4. des-iiml-01.iiml"
    echo -e "0. Enter custom file path"
    read -r choice
    
    case $choice in
        1) iiml_file="examples/min-01.iiml" ;;
        2) iiml_file="examples/min-iiml-01.iiml" ;;
        3) iiml_file="examples/min-iiml-02.iiml" ;;
        4) iiml_file="examples/des-iiml-01.iiml" ;;
        0)
            echo -e "${YELLOW}Enter the path to your IIML file:${NC}"
            read -r iiml_file
            ;;
        *)
            echo -e "${RED}Invalid option. Returning to main menu.${NC}"
            return
            ;;
    esac
    
    if [ -f "$iiml_file" ]; then
        echo -e "${YELLOW}Displaying parse tree for $iiml_file...${NC}"
        cd src/iiml
        python3 -c "from antlr4 import *; from iimlLexer import iimlLexer; from iimlParser import iimlParser; input_stream = FileStream('../../$iiml_file'); lexer = iimlLexer(input_stream); stream = CommonTokenStream(lexer); parser = iimlParser(stream); tree = parser.program(); print(tree.toStringTree(recog=parser))"
        cd ../..
    else
        echo -e "${RED}File not found: $iiml_file${NC}"
    fi
}

display_iml_tree() {
    echo -e "${YELLOW}Select an IML file to display parse tree:${NC}"
    echo -e "1. min-01.iml"
    echo -e "2. Enter custom file path"
    read -r choice
    
    case $choice in
        1) iml_file="examples/min-01.iml" ;;
        2)
            echo -e "${YELLOW}Enter the path to your IML file:${NC}"
            read -r iml_file
            ;;
        *)
            echo -e "${RED}Invalid option. Returning to main menu.${NC}"
            return
            ;;
    esac
    
    if [ -f "$iml_file" ]; then
        echo -e "${YELLOW}Displaying parse tree for $iml_file...${NC}"
        java -cp lib/antlr-4.13.1-complete.jar:bin org.antlr.v4.gui.TestRig iml program -gui "$iml_file"
    else
        echo -e "${RED}File not found: $iml_file${NC}"
    fi
}

# Main Loop
# Check if in correct directory
if [ ! -d "src/iiml" ] || [ ! -d "src/iml" ]; then
    echo -e "${RED}Error: This script must be run from the project root directory.${NC}"
    exit 1
fi

# Check if Python and antlr4-python3-runtime is installed
if ! command -v python3 &> /dev/null; then
    echo -e "${RED}Error: Python 3 is not installed or not in PATH.${NC}"
    exit 1
fi

if ! python3 -c "import antlr4" &> /dev/null; then
    echo -e "${YELLOW}Warning: antlr4-python3-runtime is not installed.${NC}"
    echo -e "${YELLOW}Installing antlr4-python3-runtime...${NC}"
    pip3 install antlr4-python3-runtime
    
    if [ $? -ne 0 ]; then
        echo -e "${RED}Error: Failed to install antlr4-python3-runtime. Please install it manually:${NC}"
        echo -e "${YELLOW}pip3 install antlr4-python3-runtime${NC}"
    fi
fi

while true; do
    show_menu
    read -r choice
    
    case $choice in
        1) clean_all ;;
        2) generate_iiml ;;
        3) generate_and_compile_iml ;;
        4) run_iiml ;;
        5) run_iml ;;
        6) display_iiml_tree ;;
        7) display_iml_tree ;;
        8) run_output_python ;;
        0) echo -e "${GREEN}Exiting script. Goodbye!${NC}" ; exit 0 ;;
        *) echo -e "${RED}Invalid option. Please try again.${NC}" ; sleep 2 ;;
    esac
    
    echo
    echo -e "${YELLOW}Press Enter to continue...${NC}"
    read -r
done