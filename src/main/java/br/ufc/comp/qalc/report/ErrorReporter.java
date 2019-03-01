package br.ufc.comp.qalc.report;

import br.ufc.comp.qalc.OutputVerbosity;
import br.ufc.comp.qalc.report.messages.Message;

import java.io.OutputStream;

/**
 * Classe especializada no relato de mensagens de erro.
 *
 * @see br.ufc.comp.qalc.report.messages.MessageType#ERROR
 */
public class ErrorReporter extends BasicReporter {
    /**
     * @see BasicReporter
     */
    public ErrorReporter(OutputStream stream) {
        super(stream);
    }

    /**
     * @see BasicReporter
     */
    public ErrorReporter(OutputStream stream, OutputVerbosity verbosity) {
        super(stream, verbosity);
    }

    @Override
    public void consume(Message message) {
        // TODO
    }
}