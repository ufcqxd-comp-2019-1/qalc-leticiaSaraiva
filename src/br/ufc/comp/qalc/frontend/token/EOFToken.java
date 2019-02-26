package br.ufc.comp.qalc.frontend.token;

public class EOFToken extends Token {
    public EOFToken(long line, long start) {
        super(line, start, start);
    }
}
