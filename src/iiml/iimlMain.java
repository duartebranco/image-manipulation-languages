import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings("unused")
public class iimlMain {
   public static void main(String[] args) {
      if (args.length==0) {
         System.err.println("usage: java iimlMain <source.iiml>");
         System.exit(1);
      }
      try {
         // read from file rather than stdin:
         String srcFile = args[0];
         CharStream input = CharStreams.fromFileName(srcFile);
         // create a lexer that feeds off of input CharStream:
         iimlLexer lexer = new iimlLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         iimlParser parser = new iimlParser(tokens);
         // replace error listener:
         parser.removeErrorListeners(); // remove ConsoleErrorListener
         parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
                                   int line, int charPositionInLine, String msg, RecognitionException e) {
               System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
               throw new RuntimeException("Syntax error");
            }
         });
         
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // Create and run the interpreter with the source file name
            iimlInterpreter interpreter = new iimlInterpreter(srcFile);
            interpreter.visit(tree);
            interpreter.execute();
            System.out.println("Execution completed successfully.");
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RuntimeException e) {
         System.err.println("Runtime error: " + e.getMessage());
         System.exit(1);
      }
   }
}