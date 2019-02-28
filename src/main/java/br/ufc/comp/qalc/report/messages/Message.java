package br.ufc.comp.qalc.report.messages;

/**
 * Representa uma mensagem a ser enviada através do {@link br.ufc.comp.qalc.report.MessageCenter}
 * e recebida por um {@link br.ufc.comp.qalc.report.MessageConsumer}.
 *
 * As mensagens funcionam como um canal de informação de eventos ocorridos no
 * funcionamento do interpretador, de forma que a responsabilidade de reportar esses
 * eventos (como erros, alertas, etc.) seja delegado a outras classes que não
 * as que os observaram.
 */
public class Message {
    protected MessageType type;
    protected String content;

    /**
     * Constrói uma mensagem especificando o tipo e o conteúdo textual.
     *
     * @param type Tipo de evento que originou a mensagem.
     * @param content Conteúdo textual associado à mensagem.
     */
    public Message(MessageType type, String content){
        this.type = type;
        this.content = content;
    }

    /**
     * Obtém o tipo de evento que originou a mensagem.
     *
     * @return Tipo da mensagem.
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Obtém o conteúdo associado à mensagem.
     *
     * @return Conteúdo da mensagem.
     */
    public String getContent() {
        return content;
    }
}
