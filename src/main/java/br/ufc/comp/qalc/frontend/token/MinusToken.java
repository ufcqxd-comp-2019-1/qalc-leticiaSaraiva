package br.ufc.comp.qalc.frontend.token;

/**
 * Classe que representa um token do tipo (MINUS).
 */
public class MinusToken extends Token{

    public MinusToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    /**
     * Obtém o operador associado ao token.
     *
     * @return Operador associado.
     */
    public String getMinusOperator() {
        interpretAttributes();

        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "MINUS";
    }

}

