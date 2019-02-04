package de.exxcellent.challenge.elaborate.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 */
public class FileUtilsTest {
    
    @Test
    public void getFileEndingTest() {
        String test = "test.csv";
        assertEquals(FilenameUtils.getFileEnding(test), "csv");
    }   
}
