package br.ufc.comp.qalc.report;

import br.ufc.comp.qalc.OutputVerbosity;
import br.ufc.comp.qalc.report.messages.Message;
import br.ufc.comp.qalc.report.messages.NewTokenMessage;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Classe especializada no relato de mensagens de reconhecimento de tokens.
 *
 * @see NewTokenMessage
 */
public class TokensReporter extends BasicReporter {

    /**
     * @see BasicReporter
     */
    public TokensReporter(OutputStream stream) {
        super(stream);
    }

    /**
     * @see BasicReporter
     */
    public TokensReporter(OutputStream stream, OutputVerbosity verbosity) {
        super(stream, verbosity);
    }

    @Override
    public void consume(Message message) {
        if(message instanceof NewTokenMessage) {
            try {
                // TODO Alterar para aumentar as informações de acordo com a variável `verbosity`.
                //      - (ID)
                //      - (ID, "lexema")
                //      - (ID, "lexema", L: 1, C: 1-2)
                output.write(String.format("(%s)\n", ((NewTokenMessage)message).getToken().getTokenIdentifier()));
            } catch (IOException e) {
                reportFailure(e);
            }
        }
    }
}
