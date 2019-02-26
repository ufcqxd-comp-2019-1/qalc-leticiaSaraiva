package br.ufc.comp.qalc.frontend.token;

public class EOFToken extends Token {
    public EOFToken(long line, long start) {
        this.columnStart = this.columnEnd = start;
        this.lineNum = line;
        this.stringValue = null;
    }
}
