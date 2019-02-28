package br.ufc.comp.qalc.report;

import br.ufc.comp.qalc.report.messages.Message;
import br.ufc.comp.qalc.report.messages.NewTokenMessage;

import java.io.IOException;
import java.io.OutputStream;

public class TokensReporter extends BasicReporter {

    public TokensReporter(OutputStream stream) {
        super(stream);
    }

    @Override
    public void consume(Message message) {
        if(message instanceof NewTokenMessage) {
            try {
                // TODO Alterar para informar também os lexemas (apenas os que forem necessários).
                //      Formato: (ID, "lexema") ou (ID)
                output.write(String.format("(%s)\n", ((NewTokenMessage)message).getToken().getTokenIdentifier()));
            } catch (IOException e) {
                reportFailure(e);
            }
        }
    }
}
