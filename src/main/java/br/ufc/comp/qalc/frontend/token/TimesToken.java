package br.ufc.comp.qalc.frontend.token;

/**
 * Classe que representa um token do tipo (TIMES).
 */
public class TimesToken extends Token{

    public TimesToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    /**
     * Obtém o operador associado ao token.
     *
     * @return Operador associado.
     */
    public String getTimesOperator() {
        interpretAttributes();

        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "TIMES";
    }

}
