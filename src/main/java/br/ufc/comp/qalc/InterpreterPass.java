package br.ufc.comp.qalc;

/**
 * Representa cada uma das fases de interpretação da entrada.
 */
public enum InterpreterPass {
    /**
     * Fase de Análise Léxica.
     */
    LEXER,
    /**
     * Fase de Análise Sintática.
     */
    PARSER,
    /**
     * Fase de Análise Semântica.
     */
    SEMANTIC,
    /**
     * Fase de Execução.
     */
    RUNNER,
}
