package de.exxcellent.challenge.elaborate.reader;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>} 04.02.2019
 */
public class FilenameUtils {
    
    public static String getFileEnding( String filename ) {
        return filename.substring(filename.lastIndexOf(".")+1, filename.length());
    }
}
