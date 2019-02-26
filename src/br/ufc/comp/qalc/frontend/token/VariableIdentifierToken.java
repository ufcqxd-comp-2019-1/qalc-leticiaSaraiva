package br.ufc.comp.qalc.frontend.token;

public class VariableIdentifierToken extends Token {

    public VariableIdentifierToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    @Override
    public void interpretAttributes() {
        // TODO Se o lexema ainda existir e ainda não tiver sido interpretado, descartar o `$`.
    }

}
