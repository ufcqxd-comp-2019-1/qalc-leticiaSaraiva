package br.ufc.comp.qalc.report;

public class Message {
    protected MessageType type;
    protected String content;

    public Message(MessageType type, String content){
        this.type = type;
        this.content = content;
    }
}
