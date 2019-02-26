package br.ufc.comp.qalc.frontend;

import java.io.BufferedReader;
import java.io.IOException;

public class Source {

    public static final char EOF = (char) 0;    // end-of-file character

    private BufferedReader reader;  // reader for the source program

    private long currentLine;       // current source line number
    private long currentColumn;     // current source line position
    private long currentPosition;   // current character offset from source beginning

    private char currentChar;
             
    /**
      * Constructor.
      * @param reader the reader for the source program
      * @throws IOException if an I/O error occurred
      */
    public Source(BufferedReader reader) {
        this.currentLine = 1;
        this.currentColumn = 0;
        this.currentPosition = 0;

        this.currentChar = EOF;

        this.reader = reader;
    }

    public void rewind() throws IOException {
        reader.reset();

        this.currentLine = 1;
        this.currentColumn = 0;
        this.currentPosition = 0;

        this.currentChar = EOF;
    }

    public char advance() throws IOException {
        final int nextChar = reader.read();

        if(nextChar > 0) {
            this.currentChar = (char) nextChar;

            ++this.currentPosition;

            if(nextChar == '\n') {
                ++this.currentLine;
                this.currentColumn = 0;
            } else {
                ++this.currentColumn;
            }
        } else {
            this.currentChar = EOF;
        }

        return this.currentChar;
    }

    public char getCurrentChar() {
        return this.currentChar;
    }

    public long getCurrentLine() {
        return this.currentLine;
    }

    public long getCurrentColumn() {
        return currentColumn;
    }

    public long getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Close the source.
     * @throws Exception if an error occurred.
     */
    public void close() throws IOException {
        if (reader != null) {
            try {
                reader.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
    }
}
