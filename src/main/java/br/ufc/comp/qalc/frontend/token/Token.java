package br.ufc.comp.qalc.frontend.token;

public abstract class Token {
    protected String stringValue;

    protected long columnStart;
    protected long columnEnd;
    protected long lineNum;

    protected Token(long line, long start, String value) throws IllegalArgumentException {
        if(value == null || value.length() == 0)
            throw new IllegalArgumentException("O lexema não pode ser vazio.");

        columnStart = start;
        columnEnd = start + value.length() - 1;
        lineNum = line;

        stringValue = value;
    }

    protected Token(long line, long start, long end) {
        columnStart = start;
        columnEnd = end;
        lineNum = line;

        stringValue = null;
    }

    public void interpretAttributes() {
        return;
    }

    /**
     * Deve retornar a {@link String} representando o identificador do token,
     * segundo as convenções de nomenclatura definidas na especificação
     * da linguagem.
     *
     * IMPORTANTE: Não incluir os parênteses!
     *
     * EXEMPLO: (PLUS) => "PLUS".
     *
     * @return identificador do token.
     */
    public abstract String getTokenIdentifier();
}
