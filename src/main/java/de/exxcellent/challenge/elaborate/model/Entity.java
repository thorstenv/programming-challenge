package de.exxcellent.challenge.elaborate.model;

import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import java.util.HashMap;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
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
    
    public String getValue( String key ) throws NoMatchingDataFoundException {
        if( entries.containsKey(key)) {
            return entries.get(key);
        } else {
            throw new NoMatchingDataFoundException("No data found for key " + key);
        }
    }
}
