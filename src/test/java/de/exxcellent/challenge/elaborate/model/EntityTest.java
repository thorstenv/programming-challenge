/*
 */
package de.exxcellent.challenge.elaborate.model;

import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 */
public class EntityTest {
    
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
