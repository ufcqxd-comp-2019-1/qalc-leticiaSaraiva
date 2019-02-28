package br.ufc.comp.qalc.report.messages;

import br.ufc.comp.qalc.report.MessageConsumer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BasicReporter implements MessageConsumer {

    protected OutputStreamWriter output;

    public BasicReporter(OutputStream stream) {
        this.output = new OutputStreamWriter(stream);
    }

    @Override
    public void consume(Message message) {
        try {
            output.write(String.format(
                    "[%s](%s): %s\n",
                    message.getType(),
                    message.getClass().getSimpleName(),
                    message.getContent()
            ));
        } catch (IOException e) {
            reportFailure(e);
        }
    }

    protected void reportFailure(IOException e) {
        System.err.println("Erro ao reportar mensagem.");
        e.printStackTrace();
    }
}
