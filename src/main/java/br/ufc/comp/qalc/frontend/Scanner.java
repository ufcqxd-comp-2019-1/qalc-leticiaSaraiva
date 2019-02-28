package br.ufc.comp.qalc.frontend;

import br.ufc.comp.qalc.frontend.token.EOFToken;
import br.ufc.comp.qalc.frontend.token.NumberToken;
import br.ufc.comp.qalc.frontend.token.Token;

import java.io.IOException;

public class Scanner {

    protected Token currentToken;
    protected Source source;

    public Scanner(Source sourceStream) throws IOException {
        // FIXME Lidar corretamente com as exceções.
        this.source = sourceStream;
        this.source.rewind();
        this.source.advance();
    }

    public Token getNextToken() throws IOException {
        // TODO

        if(source.getCurrentChar() == Source.EOF) {
            return new EOFToken(source.getCurrentLine(), source.getCurrentColumn());
        } else if(Character.isDigit(source.getCurrentChar())) { // NumberToken
                StringBuilder lexema = new StringBuilder();

                long currentLine = source.getCurrentLine();
                long lexemaStart = source.getCurrentColumn();

                do {
                    lexema.append(source.getCurrentChar());
                    source.advance();
                } while(Character.isDigit(source.getCurrentChar()));

                String stringValue = lexema.toString();

                return new NumberToken(currentLine, lexemaStart, stringValue);
        }

        return null;
    }

    public Token getCurrentToken() {
        return currentToken;
    }
}








