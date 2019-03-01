package br.ufc.comp.qalc;

/**
 * Representa os níveis de detalhamento que o interpretador aceita
 * quanto às informações inseridas no arquivo de saída solicitado.
 *
 * <dl>
 * <dt>ESSENTIAL</dt>
 * <dd>- O nível mínimo. Apenas as informações essenciais serão inseridas.</dd>
 * <dt>ADDITIONAL_INFO</dt>
 * <dd>- Nível intermediário. Maiores detalhes serão inseridos, como informações
 * de localização, por exemplo.</dd>
 * <dt>EVERYTHING</dt>
 * <dd>- O nível máximo. Todas as informações serão inseridas.</dd>
 * </dl>
 * <p>
 * O tipo de informação que cada nível representa depende de qual fase da interpretação
 * da entrada será a responsável pela emissão da saída.
 */
public enum OutputVerbosity {
    /**
     * Apenas as informações essenciais serão inseridas.
     */
    ESSENTIAL,
    /**
     * Maiores detalhes serão inseridos.
     */
    ADDITIONAL_INFO,
    /**
     * Todas as informações serão inseridas.
     */
    EVERYTHING,
}
