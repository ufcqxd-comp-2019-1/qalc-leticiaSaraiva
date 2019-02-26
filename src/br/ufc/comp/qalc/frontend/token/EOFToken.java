package br.ufc.comp.qalc.frontend.token;

public class EOFToken extends Token {
    public EOFToken(long start) {
        this.columnStart = this.columnEnd = start;
        this.stringValue = null;
    }
}
