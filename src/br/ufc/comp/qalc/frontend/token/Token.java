package br.ufc.comp.qalc.frontend.token;

public class Token {
    protected String stringValue;

    protected long positionStart;
    protected long positionEnd;

    public Token(long start, long end, String value) {
        positionStart = start;
        positionEnd = end;

        stringValue = value;
    }

    public void interpretAtributes() {
        return;
    }
}
