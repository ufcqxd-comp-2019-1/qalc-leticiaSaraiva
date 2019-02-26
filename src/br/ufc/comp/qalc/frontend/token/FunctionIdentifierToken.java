package br.ufc.comp.qalc.frontend.token;

public class FunctionIdentifierToken extends Token {

    public FunctionIdentifierToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    @Override
    public void interpretAttributes() {
        if(stringValue != null && stringValue.charAt(0) == '@') {
            stringValue = stringValue.substring(1);
        }
    }

}
