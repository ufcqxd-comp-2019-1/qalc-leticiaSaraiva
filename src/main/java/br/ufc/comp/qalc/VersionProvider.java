package br.ufc.comp.qalc;

import picocli.CommandLine;

public final class VersionProvider implements CommandLine.IVersionProvider {

    public static final String[] versionInfo = new String[]{
            "@|bold Interpretador QALC|@ 0.1.0 (@|underline Lexer|@)",
            "QXD0025 - Compiladores - 2019.1"
    };

    @Override
    public String[] getVersion() throws Exception {
        return VersionProvider.versionInfo;
    }
}
