package br.ufc.comp.qalc.frontend.token;

/**
 * Classe que representa um token do tipo (WHITE).
 */
public class WhiteToken extends Token{

    public WhiteToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    /**
     * Obtém o espaço associado ao token.
     *
     * @return Espaço em branco.
     */
    public String getWhiteSpace() {
        interpretAttributes();

        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "WHITE";
    }

}
