package br.ufc.comp.qalc.report.messages;

/**
 * Representa as possíveis categorias de eventos que podem originar mensagens
 * dentro do interpretador.
 */
public enum MessageCategory {
    /**
     * Notas ao usuário. Representam observações não-críticas.
     */
    NOTE,
    /**
     * Avisos ao usuário. Representam observações que podem afetar a interpretação da entrada.
     */
    WARNING,
    /**
     * Erros ao usuário. Representam problemas críticos que impedem a interpretação da entrada.
     */
    ERROR,
    /**
     * Informações da Análise Léxica.
     */
    SCANNING,
    /**
     * Informações da Análise Sintática.
     */
    PARSING,
    /**
     * Informações da Análise Semântica.
     */
    SEMANTICS,
    /**
     * Informações da Execução
     */
    RUNTIME;
}
