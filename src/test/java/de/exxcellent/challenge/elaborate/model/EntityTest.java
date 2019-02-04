/*
 */
package de.exxcellent.challenge.elaborate.model;

import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 */
public class EntityTest {
    
    @Test
    public void testEntityCreation() throws HeaderDataLengthException, NoMatchingDataFoundException {
        String[] headers = {"h1", "h2"};
        String[] values = {"key", "value"};
        
        Entity newEntity = new Entity(headers, values);
        assertEquals(newEntity.getValue("h1"), "key");
    }
    
    @Test
    public void testFaultyEntityCreation() {
        
        String[] headers = {"one"};
        String[] values = {"two","three"};
        
        try {
            Entity e = new Entity(headers, values);
            fail();
        } catch (HeaderDataLengthException ex) {
            assertTrue(ex.getMessage().equals("Header and Data have to have the same length"));
        }        
    }
    
    @Test
    public void testNoColumnFoundException() throws HeaderDataLengthException {
        String[] headers = {"header1", "header2"};
        String[] values = {"two","three"};
        
            Entity e = new Entity(headers, values);            
        try {
            e.getValue("header3");
        } catch (NoMatchingDataFoundException ex) {
            assertTrue(ex.getMessage().equals("No data found for key header3"));
        }
    }
}
