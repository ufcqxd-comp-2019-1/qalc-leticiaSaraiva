package br.ufc.comp.qalc.report;

import br.ufc.comp.qalc.report.messages.Message;

public interface MessageConsumer {

    public void consume(Message message);

}
