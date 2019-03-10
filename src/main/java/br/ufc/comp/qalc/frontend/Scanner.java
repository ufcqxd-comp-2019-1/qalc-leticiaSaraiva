package br.ufc.comp.qalc.frontend;

import br.ufc.comp.qalc.frontend.token.*;

import java.io.IOException;

/**
 * Analisador Léxico da linguagem.
 * <p>
 * Funciona como uma fonte de tokens, de onde o Analisador Sintático
 * deverá ler.
 *
 * @see Source
 */
public class Scanner {

    /**
     * Último token reconhecido.
     */
    protected Token currentToken;
    /**
     * Fonte de caracteres de onde extrair os tokens.
     */
    protected Source source;

    /**
     * Constrói um Analisador Léxico a partir de uma fonte de caracteres.
     *
     * @param sourceStream Fonte a ser utilizada.
     */
    public Scanner(Source sourceStream) {
        // FIXME Lidar corretamente com as exceções.
        this.source = sourceStream;
    }

    /**
     * Consome caracteres da fonte até que eles componham um lexema de
     * um dos tokens da linguagem, coinstrói um objeto representando esse
     * token associado ao lexema lido e o retorna.
     *
     * @return Token reconhecido.
     * @throws IOException Caso haja problema na leitura da fonte.
     */
    public Token getNextToken() throws IOException {
        // TODO Reconhecimento de tokens

        if (source.getCurrentChar() == Source.EOF) { //EOFToken
            return new EOFToken(source.getCurrentLine(), source.getCurrentColumn());

        } else if (Character.isDigit(source.getCurrentChar())) { // NumberToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            do {
                lexema.append(source.getCurrentChar());
                source.advance();
            } while (Character.isDigit(source.getCurrentChar()));

            if(source.getCurrentChar() == '.'){     //Aceitar números fracionários
                lexema.append(source.getCurrentChar());     //Adiciona o ponto
                source.advance();       //Avança

                while (Character.isDigit(source.getCurrentChar())) { //Enquanto for número ele adiciona
                    lexema.append(source.getCurrentChar());
                    source.advance();
                }
            }

            String stringValue = lexema.toString();

            return new NumberToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '@'){ //FunctionIdentifierToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            do{
                lexema.append(source.getCurrentChar());
                source.advance();
            }while(Character.isLetterOrDigit(source.getCurrentChar()));

            String stringValue = lexema.toString();

            return new FunctionIdentifierToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '$'){
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar());
            source.advance();

            if(Character.isLetter(source.getCurrentChar())){    //VariableIdentifierToken
                do{
                    lexema.append(source.getCurrentChar());
                    source.advance();
                }while(Character.isLetter(source.getCurrentChar()));

                String stringValue = lexema.toString();

                return new VariableIdentifierToken(currentLine, lexemeStart, stringValue);

            }else{                                              //ResultIdentifierToken
                if(source.getCurrentChar() == '?'){
                    lexema.append(source.getCurrentChar());
                    source.advance();

                    String stringValue = lexema.toString();
                    return new ResultIdentifierToken(currentLine, lexemeStart, stringValue);
                }else {
                    int isZero = 0; //Contador para os números 0's

                    do {
                        if (source.getCurrentChar() == '0') {
                            isZero++;
                        }
                        lexema.append(source.getCurrentChar());
                        source.advance();
                    } while (Character.isDigit(source.getCurrentChar()));

                    String stringValue = lexema.toString();

                    if (isZero != stringValue.length()) { //Se ele não for formado apenas por zeros (0's)
                        return new ResultIdentifierToken(currentLine, lexemeStart, stringValue);
                    }
                }
            }

        }else if(source.getCurrentChar() == '='){   //AtribToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new AtribToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '+'){   //PlusToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new PlusToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '-'){   //MinusToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new MinusToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '*'){   //TimesToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new TimesToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '/'){   //DivToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new DivToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '%'){   //ModToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new ModToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '^'){   //PowToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new PowToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '('){   //LParenToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new LParenToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == ')'){   //RParenToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new RParenToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == ','){   //CommaToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new CommaToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == ';'){   //SemiToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();
            lexema.append(source.getCurrentChar());
            source.advance();

            String stringValue = lexema.toString();

            return new SemiToken(currentLine, lexemeStart, stringValue);

        }else if(source.getCurrentChar() == '#'){   //CommentToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            do{
                lexema.append(source.getCurrentChar());
                source.advance();
            }while(source.getCurrentChar() != '\n' );

            String stringValue = lexema.toString();

            return new CommentToken(currentLine, lexemeStart, stringValue);

        }else if(Character.isWhitespace(source.getCurrentChar())){   //WhiteToken
            StringBuilder lexema = new StringBuilder();

            long currentLine = source.getCurrentLine();
            long lexemeStart = source.getCurrentColumn();

            lexema.append(source.getCurrentChar()); //Adiciona apenas um espaço em branco
            do{
                source.advance();
            }while(Character.isWhitespace(source.getCurrentChar()));

            String stringValue = lexema.toString();

            return new WhiteToken(currentLine, lexemeStart, stringValue);

        }

        // TODO Recuperação de erros.


        return null;
    }

    /**
     * Obtém o último token reconhecido.
     *
     * @return O último token reconhecido.
     */
    public Token getCurrentToken() {
        return currentToken;
    }
}