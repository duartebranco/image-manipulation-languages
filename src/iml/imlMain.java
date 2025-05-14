import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
         String srcFile = args[0];
         CharStream input = CharStreams.fromFileName(srcFile);
         imlLexer lexer   = new imlLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         imlParser parser = new imlParser(tokens);
         ParseTree tree    = parser.program();

         if (parser.getNumberOfSyntaxErrors() == 0) {
            CodeGenVisitor visitor0 = new CodeGenVisitor();
            visitor0.visit(tree);
            // write Python
            String py = visitor0.getCode();
            String base = Paths.get(srcFile).getFileName().toString();
            base = base.substring(0, base.lastIndexOf('.'));         
            Path outDir = Paths.get("../../output");
            Files.createDirectories(outDir);
            Path outFile = outDir.resolve(base + ".py");
            Files.writeString(outFile, py);
            System.out.println("→ generated " + outFile);
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
