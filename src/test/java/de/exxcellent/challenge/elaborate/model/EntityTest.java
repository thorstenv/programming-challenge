/*
 */
package de.exxcellent.challenge.elaborate.model;

import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
 */
public class EntityTest {
    
    @Test()
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
}
