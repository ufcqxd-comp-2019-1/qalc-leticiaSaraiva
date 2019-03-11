package br.ufc.comp.qalc.frontend.token;

/**
 * Classe que representa um token do tipo (ERROR).
 */
public class ErrorToken extends Token{

    public ErrorToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    /**
     * Obtém o erro.
     *
     * @return Erro.
     */
    public String getError() {
        interpretAttributes();

        return stringValue;
    }

    /**Obtém a identificação do token.
     *
     * @return ERROR, linha e colunas onde o erro aconteceu e caracteres que reportaram erro.
     */
    @Override
    public String getTokenIdentifier() {
        return "ERROR: L: " + getLineNumber() + ", C: " + getColumnStart() + "-" + getColumnEnd() + "; " + getError();
    }

}
