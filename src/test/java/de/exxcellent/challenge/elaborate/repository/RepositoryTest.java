package de.exxcellent.challenge.elaborate.repository;

import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import de.exxcellent.challenge.elaborate.model.Entity;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 * 04.02.2019
 *
 */
public class RepositoryTest {
    
    @Test
    public void testRepositoryGetIndexException() {
        EntityRepository rep = new EntityRepository();
        Entity entity = rep.getEntity(2);
        Assertions.assertNull(entity);
    }
    
    @Test
    public void testRepositoryGet() throws HeaderDataLengthException, NoMatchingDataFoundException {
        EntityRepository rep = new EntityRepository();
        Entity newEntity = new Entity(new String[]{"h1", "h2"}, new String[]{"k", "v"});
        rep.addEntity(newEntity);
        
        Entity getEntity = rep.getEntity(0);
        assertEquals(getEntity.getValue("h1"), newEntity.getValue("h1"));
    }

}
