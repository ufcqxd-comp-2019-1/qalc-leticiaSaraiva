package br.ufc.comp.qalc.report.messages;

/**
 * Representa os possíveis tipos de evento que podem originar mensagens
 * dentro do interpretador.
 */
public enum MessageType {
    /** Notas ao usuário. Representam observações não-críticas. */
    NOTE,
    /** Avisos ao usuário. Representam observações que podem afetar a interpretação da entrada. */
    WARNING,
    /** Erros ao usuário. Representam problemas críticos que impedem a interpretação da entrada. */
    ERROR,
    /** Informações da Análise Léxica. */
    SCANNING,
    /** Informações da Análise Sintática. */
    PARSING,
    /** Informações da Análise Semântica. */
    SEMANTICS,
    /** Informações da Execução */
    RUNTIME;
}
