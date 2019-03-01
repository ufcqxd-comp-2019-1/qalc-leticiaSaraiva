package br.ufc.comp.qalc.report.messages;

/**
 * Representa uma mensagem a ser enviada através do {@link br.ufc.comp.qalc.report.MessageCenter}
 * e recebida por um {@link br.ufc.comp.qalc.report.MessageConsumer}.
 * <p>
 * As mensagens funcionam como um canal de informação de eventos ocorridos no
 * funcionamento do interpretador, de forma que a responsabilidade de reportar esses
 * eventos (como erros, alertas, etc.) seja delegado a outras classes que não
 * as que os observaram.
 */
public class Message {
    protected final MessageCategory category;
    protected final String content;

    /**
     * Constrói uma mensagem especificando a categoria e o conteúdo textual.
     *
     * @param category Categoria de evento que originou a mensagem.
     * @param content  Conteúdo textual associado à mensagem.
     */
    public Message(MessageCategory category, String content) {
        this.category = category;
        this.content = content;
    }

    /**
     * Obtém a categoria de evento que originou a mensagem.
     *
     * @return Tipo da mensagem.
     */
    public MessageCategory getCategory() {
        return category;
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
