package br.ufc.comp.qalc.frontend;

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

    public Token getNextToken() {
        // TODO
        return null;
    }

    public Token getCurrentToken() {
        return currentToken;
    }
}
