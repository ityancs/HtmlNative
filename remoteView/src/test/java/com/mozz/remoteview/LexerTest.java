package com.mozz.remoteview;

import com.mozz.remoteview.reader.StringCodeReader;
import com.mozz.remoteview.token.Token;

import org.junit.Test;

import java.io.EOFException;
import java.io.IOException;

import static com.mozz.remoteview.CodeToTest.codeScriptFirst;
import static com.mozz.remoteview.CodeToTest.codeTemplateOnly;

public class LexerTest {

    private static final String TAG = "RV_LexerTest";

    @Test
    public void testLexerSimple() throws Exception {
        LexerDebugger(codeTemplateOnly);
    }

    private void LexerDebugger(String code) throws IOException, RVSyntaxError {

        debug("code:");
        debug(code + "\n\ntoken list is:\n");

        Lexer lexer = new Lexer(new StringCodeReader(code));

        while (true) {
            try {
                Token t = lexer.scan();
                debug("---> " + t.toString());
            } catch (EOFException e) {
               break;
            } catch (RVSyntaxError sytaxError) {
                sytaxError.printStackTrace();
                break;

            }
        }
    }

    private void debug(String msg) {
        System.out.println(msg);
    }

}