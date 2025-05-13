import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class imlMain {
   public static void main(String[] args) {
      if (args.length==0) {
         System.err.println("usage: java imlMain <source.iml>");
         System.exit(1);
      }
      try {
         // read from file rather than stdin:
         CharStream input = CharStreams.fromFileName(args[0]);
         imlLexer lexer   = new imlLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         imlParser parser = new imlParser(tokens);
         ParseTree tree    = parser.program();

         if (parser.getNumberOfSyntaxErrors() == 0) {
            CodeGenVisitor visitor0 = new CodeGenVisitor();
            visitor0.visit(tree);

            // write Python to out.py:
            String py = visitor0.getCode();
            Files.writeString(Path.of("out.py"), py);
            System.out.println("→ generated out.py");
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
   }
}
