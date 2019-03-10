package br.ufc.comp.qalc.frontend.token;

/**
 * Classe que representa um token do tipo (COM).
 */
public class CommentToken extends Token{

    public CommentToken(long line, long start, String value) throws IllegalArgumentException {
        super(line, start, value);
    }

    /**
     * Para este tipo de token, descarta o {@code #} do lexema, caso não tenha sido descartado ainda.
     *
     * @see Token#interpretAttributes()
     */
    @Override
    public void interpretAttributes() {
        if (stringValue != null && stringValue.charAt(0) == '#') {
            stringValue = stringValue.substring(1);
        }
    }

    /**
     * Obtém o comentário associado ao token.
     *
     * @return Comentário.
     */
    public String getComment() {
        interpretAttributes();

        return stringValue;
    }

    @Override
    public String getTokenIdentifier() {
        return "COM";
    }

}
