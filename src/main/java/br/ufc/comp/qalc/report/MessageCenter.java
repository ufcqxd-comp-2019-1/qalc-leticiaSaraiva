package br.ufc.comp.qalc.report;

import br.ufc.comp.qalc.report.messages.Message;
import br.ufc.comp.qalc.report.messages.MessageType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MessageCenter {
    private MessageCenter() {}

    private static HashMap<MessageType, List<MessageConsumer>> mapping;

    static {
        mapping = new HashMap<>();
    }

    public static void registerConsumerFor(MessageType type, MessageConsumer consumer) {
        List<MessageConsumer> list = mapping.get(type);

        if(list == null) {
            list = new ArrayList<>();
            list.add(consumer);
            mapping.put(type, list);
        } else {
            list.add(consumer);
        }
    }

    public static void deliver(Message message) {
        List<MessageConsumer> list = mapping.get(message.getType());

        for (MessageConsumer consumer : list) {
            consumer.consume(message);
        }
    }
}
