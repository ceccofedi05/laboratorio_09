package it.unibo.mvc;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILE = "output.txt";
    private File current = new File(HOME + File.separator + DEFAULT_FILE);

    /**
     *  method for setting a File as current file.
     * 
     * @param currentFile the file where to write
     */
    public void setCurrentFile(final File currentFile) {
        this.current = currentFile;
    }

    /**
     * method for getting the current File.
     * 
     * @return the current file
     */
    public File getCurrentFile() {
        return current;
    }

    /**
     * method for getting the path (in form of String) of the current `File`.
     * 
     * @return the current file path
     */
    public String getCurrentFilePath() {
        return this.current.getPath();
    }

    /**
     * method that gets a `String` as input and saves its content on the current file.
     * 
     * @param input the text to save
     * @throws java.io.IOException if the writing fails
     */
    public void saveContentToFile(final String input) throws java.io.IOException {
        try (PrintStream ps = new PrintStream(this.current, StandardCharsets.UTF_8)) {
            ps.println(input);
        }
    }
}
