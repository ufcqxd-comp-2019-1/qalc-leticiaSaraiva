package br.ufc.comp.qalc.report.messages;

import br.ufc.comp.qalc.frontend.token.Token;

public class NewTokenMessage extends Message {

    protected Token token;

    public NewTokenMessage(Token newToken) {
        super(MessageType.SCANNING, null);

        this.token = newToken;
    }

    public Token getToken() {
        return token;
    }

}
