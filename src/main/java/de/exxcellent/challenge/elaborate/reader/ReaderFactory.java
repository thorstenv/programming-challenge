package de.exxcellent.challenge.elaborate.reader;

import static de.exxcellent.challenge.elaborate.defines.Defines.CSV;
import de.exxcellent.challenge.elaborate.exceptions.FileTypeNotYetSupportedException;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>} 04.02.2019
 *
 */
public class ReaderFactory {

    public static IReader getReaderForFileType(String filename) throws FileTypeNotYetSupportedException {
        String fileEnding = FilenameUtils.getFileEnding(filename);
        switch (fileEnding) {
            case CSV: {
                return new CsvReader();
            }
            default: {
                throw new FileTypeNotYetSupportedException("FileType not supported " + fileEnding);
            }
        }
    }
}
