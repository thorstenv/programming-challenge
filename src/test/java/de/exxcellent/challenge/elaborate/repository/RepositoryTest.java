package de.exxcellent.challenge.elaborate.repository;

import de.exxcellent.challenge.elaborate.model.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
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

}
