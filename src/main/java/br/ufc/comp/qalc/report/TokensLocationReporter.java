package br.ufc.comp.qalc.report;

import br.ufc.comp.qalc.report.messages.Message;

import java.io.OutputStream;

public class TokensLocationReporter extends TokensReporter {
    public TokensLocationReporter(OutputStream stream) {
        super(stream);
    }

    @Override
    public void consume(Message message) {
        // TODO
    }
}
