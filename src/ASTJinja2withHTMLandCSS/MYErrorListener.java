package ASTJinja2withHTMLandCSS;

import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

public class MYErrorListener extends BaseErrorListener {
    public static boolean hasError=false;
    public String path;

    public MYErrorListener(String path) {
        this.path=path;
    }

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e) {
        hasError =true;
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        System.err.println("Syntax Error! in file: " + path);
        System.err.println("Token "+"\""+((Token)offendingSymbol).getText()+"\""
                           +
                            "(line"+line+ ", column "+(charPositionInLine+1)+")"
                           +": "+msg);
        System.err.println("Rule Stack"+stack);


    }
}
