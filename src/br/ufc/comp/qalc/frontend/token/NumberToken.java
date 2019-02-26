package br.ufc.comp.qalc.frontend.token;

public class NumberToken extends Token {
    protected double numericValue;

    public NumberToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);

        // FIXME Calcular valor numérico e apagar lexema
    }
}
