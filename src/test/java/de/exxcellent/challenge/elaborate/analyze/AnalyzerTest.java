package de.exxcellent.challenge.elaborate.analyze;

import de.exxcellent.challenge.elaborate.exceptions.HeaderDataLengthException;
import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import de.exxcellent.challenge.elaborate.model.Entity;
import de.exxcellent.challenge.elaborate.repository.EntityRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
 * 04.02.2019
 *
 */
public class AnalyzerTest {

    @Test
    public void testDiffInteger() {
        
        try {
            EntityRepository testRep = new EntityRepository();
            
            String[] headers = {"key", "value1", "value2"};
            
            String[] values1 = {"hello", "85", "30"};
            Entity testEntity1 = new Entity( headers, values1);
            testRep.addEntity(testEntity1);
            
            String[] values2 = {"bye", "85", "25"};
            Entity testEntity2 = new Entity( headers, values2);
            testRep.addEntity(testEntity2);
            
            Analyzer an = new Analyzer();
            Entity smallestDiffEntity = an.findEntityWithSmallestDiffForInteger( testRep, "value1", "value2");
            assertEquals(testEntity1.getValue("key"), smallestDiffEntity.getValue("key"));
            
        } catch (HeaderDataLengthException | NoMatchingDataFoundException ex) {
            Logger.getLogger(AnalyzerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
