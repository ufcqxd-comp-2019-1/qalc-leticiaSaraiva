package br.ufc.comp.qalc.frontend.token;

public class Token {
    protected String stringValue;

    protected long columnStart;
    protected long columnEnd;
    protected long lineNum;

    protected Token(long line, long start, String value) throws IllegalArgumentException {
        if(value == null || value.length() == 0)
            throw new IllegalArgumentException("O lexema não pode ser vazio.");

        columnStart = start;
        columnEnd = start + value.length() - 1;
        lineNum = line;

        stringValue = value;
    }

    protected Token(long line, long start, long end) {
        columnStart = start;
        columnEnd = end;
        lineNum = line;

        stringValue = null;
    }

    public void interpretAttributes() {
        return;
    }
}
