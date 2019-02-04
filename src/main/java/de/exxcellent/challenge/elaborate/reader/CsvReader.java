package de.exxcellent.challenge.elaborate.reader;

import static de.exxcellent.challenge.elaborate.defines.Defines.CSV_DELIMITER;
import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import de.exxcellent.challenge.elaborate.exceptions.ReaderException;
import de.exxcellent.challenge.elaborate.model.Entity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 * 04.02.2019
 *
 */
public class CsvReader implements IReader {

    @Override
    public List<Entity> readEntities( String filename ) throws ReaderException {                        
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader( System.getProperty("user.dir") + "/target/classes/de/exxcellent/challenge/" + filename );
            br = new BufferedReader(fr);
            
            List<Entity> retval = new ArrayList<>();
            
            // read headers
            String headerLine = br.readLine();
            String[] headers = headerLine.split(CSV_DELIMITER);
            
            String line = null;
            while(( line = br.readLine()) != null ) {
                String[] values = line.split(CSV_DELIMITER);
                Entity newEntity = new Entity(headers, values);
                retval.add(newEntity);
            }

            return retval;
        } catch (FileNotFoundException ex) {
            throw new ReaderException(ex);
        } catch (IOException | HeaderDataLengthException ex) {            
            throw new ReaderException(ex);
        } finally {
            if( fr != null ) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    throw new ReaderException(ex);
                }
            }
            if( br != null ) {
                try {
                    br.close();
                } catch (IOException ex) {
                    throw new ReaderException(ex);
                }
            }
        }
    }
}
