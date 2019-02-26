package br.ufc.comp.qalc.frontend.token;

public class EOFToken extends Token {
    public EOFToken(long start) {
        this.positionStart = this.positionEnd = start;
        this.stringValue = null;
    }
}
