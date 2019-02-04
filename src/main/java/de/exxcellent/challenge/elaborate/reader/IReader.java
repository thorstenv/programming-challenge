/*
 */
package de.exxcellent.challenge.elaborate.reader;

import de.exxcellent.challenge.elaborate.exceptions.ReaderException;
import de.exxcellent.challenge.elaborate.model.Entity;
import java.util.List;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 */
public interface IReader {
    
    public List<Entity> readEntities( String filename ) throws ReaderException;
    
}
