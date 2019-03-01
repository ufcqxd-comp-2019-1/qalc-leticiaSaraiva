package br.ufc.comp.qalc;

import picocli.CommandLine;

import java.io.File;

/**
 * Classe principal do interpretador.
 *
 * Contém a função {@link QALC.main} e as definições de interpretação
 * dos parâmetros de execução.
 */
@CommandLine.Command(
        description = "Interpretador para a linguagem QALC.",
        headerHeading = "Uso:%n",
        synopsisHeading = "\t",
        descriptionHeading = "%nDescrição:%n\t",
        parameterListHeading = "%nParâmetros:%n",
        optionListHeading = "%nOpções:%n"
)
public class QALC {

    @CommandLine.Option(
            names = {"-h", "-?", "--help"},
            description = "Exibe este texto de ajuda e sai.",
            usageHelp = true
    )
    boolean helpRequested = false;

    @CommandLine.Option(
            names = {"-v", "--version"},
            description = "Exibe informações de versão e sai.",
            versionHelp = true
    )
    boolean versionRequested = false;

    /**
     * Indica a última fase que o usuário deseja executar no interpretador.
     */
    @CommandLine.Option(
            names = {"-s", "--stop-at"},
            paramLabel = "PHASE",
            description = "Informa a última fase a ser executada na interpretação da entrada." +
                    "\n@|bold Valores válidos:|@ ${COMPLETION-CANDIDATES}." +
                    "\n@|bold Valor padrão:|@ @|underline ${DEFAULT-VALUE}|@."
    )
    InterpreterPass stopAt = InterpreterPass.RUNNER;

    /**
     * Indica o nível de detalhamento a ser usado no arquivo de saída, se solicitado.
     */
    @CommandLine.Option(
            names = {"-o", "--output-verbosity"},
            paramLabel = "VERBOSITY",
            description = "Controla a quantidade de informação a ser incluída no arquivo de saída." +
                    "\n@|bold Valores válidos:|@ ${COMPLETION-CANDIDATES}." +
                    "\n@|bold Valor padrão:|@ @|underline ${DEFAULT-VALUE}|@."
    )
    OutputVerbosity outputVerbosity = OutputVerbosity.ESSENTIAL;

    /**
     * Indica o arquivo de onde ler a entrada.
     *
     * O valor {@code null} significa que a entrada deve ser lida da
     * entrada-padrão ({@code System.out}).
     */
    @CommandLine.Parameters(
            paramLabel = "FILE",
            index = "0",
            arity = "0..1",
            description = "Informa o arquivo a ser usado como entrada. Caso não seja informado, lê da entrada-padrão."
    )
    File readFrom = null;

    public static void main(String[] args) {
        QALC qalc = new QALC();
        CommandLine cmd = new CommandLine(qalc);

        try {
            cmd.setOverwrittenOptionsAllowed(true);
            cmd.parse(args);
            if (cmd.isUsageHelpRequested()) {
                cmd.usage(System.out);
            } else if (cmd.isVersionHelpRequested()) {
                cmd.printVersionHelp(System.out);
            } else {
                // Alterar esta porção do código
                // ---->

                // NOTE: A ordem em que a enumeração foi definida indica a progressão das fases.
                //       Então, comparamos a posição dos valores para saber se a fase que deveríamos executar
                //       está antes da fase em que o usuário deseja parar.
                if (qalc.stopAt.ordinal() >= InterpreterPass.LEXER.ordinal()) {
                    // Fase de Análise Léxica deve ser executada
                    // TODO
                }

                // <----
            }
        } catch (CommandLine.UnmatchedArgumentException ex) {
            System.err.println("[!] No máximo um arquivo deve ser informado como entrada.");
            System.err.println("\tParâmetros ignorados:");

            for(String param : cmd.getUnmatchedArguments()) {
                System.err.println("\t:: "+param);
            }
            System.err.println();

            if (!CommandLine.UnmatchedArgumentException.printSuggestions(ex, System.err)) {
                ex.getCommandLine().usage(System.err);
            }
        } catch (CommandLine.ParameterException ex) {
            System.err.println(ex.getMessage());
        }
    }
}