package de.exxcellent.challenge.elaborate.analyze;

import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import de.exxcellent.challenge.elaborate.model.Entity;
import de.exxcellent.challenge.elaborate.repository.EntityRepository;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
 * 04.02.2019
 *
 */
public class Analyzer {
    
    // TODO: if two entities have the same difference, the first one is returned, maybe this is not what we want??
    
    protected Entity findEntityWithSmallestDiffForInteger( EntityRepository rep, String column1, String column2 ) throws NoMatchingDataFoundException {                
        Entity retval = null;
        Integer smallestDiff = null;
        for( Entity e : rep.findAll() ) {            
            Integer value1 = Integer.parseInt(e.getValue(column1));
            Integer value2 = Integer.parseInt(e.getValue(column2));
            
            Integer currentDiff = Math.abs(value1-value2);
            if( retval == null || currentDiff < smallestDiff ) {
                retval = e;
                smallestDiff = currentDiff;
            }            
        }
        return retval;
    }
    
    protected Entity findEntityWithSmallestDiffForDouble( EntityRepository rep, String column1, String column2 ) throws NoMatchingDataFoundException {
        Entity retval = null;
        Double smallestDiff = null;
        for( Entity e : rep.findAll() ) {            
            Double value1 = Double.parseDouble(e.getValue(column1));
            Double value2 = Double.parseDouble(e.getValue(column2));
            
            Double currentDiff = Math.abs(value1-value2);
            if( retval == null || currentDiff < smallestDiff ) {
                retval = e;
                smallestDiff = currentDiff;
            }            
        }
        return retval;        
    }
}
