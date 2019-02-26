package br.ufc.comp.qalc.frontend.token;

public class ResultIdentifierToken extends Token {
    protected long resultNumber;

    public ResultIdentifierToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    @Override
    public void interpretAttributes() {
        // TODO Se o lexema ainda existir, desconsiderar o `$` e interpretar o resto como um long,
        //      atribuindo ao campo `resultNumber`.
    }

}
