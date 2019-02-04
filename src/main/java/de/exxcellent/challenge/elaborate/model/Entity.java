package de.exxcellent.challenge.elaborate.model;

import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import java.util.HashMap;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
 * 04.02.2019
 *
 */
public class Entity {
    
    private HashMap<String, String> entries;
    
    public Entity( String[] keys, String[] values) throws HeaderDataLengthException {        
        if( keys.length != values.length ) {
            throw new HeaderDataLengthException("Header and Data have to have the same length");
        }
        this.entries = new HashMap<>();        
        for( int i = 0; i < values.length; i++ ) {
            this.entries.put(keys[i], values[i]);
        }
    }

}
