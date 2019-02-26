package br.ufc.comp.qalc.frontend.token;

public class NumberToken extends Token {
    protected double numericValue;

    public NumberToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    @Override
    public void interpretAttributes() {
        if(stringValue != null) {
            numericValue = Double.parseDouble(stringValue);
            stringValue = null;
        }
    }

    @Override
    public String getTokenIdentifier() {
        return "NUML";
    }
}
