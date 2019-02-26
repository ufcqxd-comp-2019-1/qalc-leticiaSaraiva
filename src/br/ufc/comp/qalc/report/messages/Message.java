package br.ufc.comp.qalc.report.messages;

public class Message {
    protected MessageType type;
    protected String content;

    public Message(MessageType type, String content){
        this.type = type;
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
