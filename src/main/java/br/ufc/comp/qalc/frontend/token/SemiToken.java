package br.ufc.comp.qalc.frontend.token;

/**
 * Classe que representa um token do tipo (SEMI).
 */
public class SemiToken extends Token{

    public SemiToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    /**
     * Obtém o símbolo associado ao token.
     *
     * @return Símbolo especial associado.
     */
    public String getSemi() {
        interpretAttributes();

        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "SEMI";
    }

}

