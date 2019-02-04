/*
 */
package de.exxcellent.challenge.elaborate.reader;

import de.exxcellent.challenge.elaborate.exceptions.FileTypeNotYetSupportedException;
import de.exxcellent.challenge.elaborate.model.Entity;
import java.util.List;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
 */
public interface IReader {
    
    public List<Entity> readEntities( String filename ) throws FileTypeNotYetSupportedException;
    
}
