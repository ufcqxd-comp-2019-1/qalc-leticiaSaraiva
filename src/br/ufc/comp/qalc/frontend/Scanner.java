package br.ufc.comp.qalc.frontend;

import br.ufc.comp.qalc.frontend.token.Token;

public class Scanner {

    protected Token currentToken;
    protected Source source;

    public Scanner(Source sourceStream){
        this.source = sourceStream;
        this.source.rewind();
        this.source.advance();
    }

    public Token getNextToken() {
        // TODO
    }

    public Token getCurrentToken() {
        return currentToken;
    }
}
