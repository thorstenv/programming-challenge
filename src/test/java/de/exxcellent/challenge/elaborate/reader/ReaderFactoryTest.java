package de.exxcellent.challenge.elaborate.reader;

import de.exxcellent.challenge.elaborate.exceptions.FileTypeNotYetSupportedException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 */
public class ReaderFactoryTest {
    
    @Test
    public void CsvReaderTest() throws FileTypeNotYetSupportedException {                
        IReader csvReader = ReaderFactory.getReaderForFileType("test.csv");
        assertEquals(csvReader.getClass(), CsvReader.class);
    }
}
