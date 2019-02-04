package de.exxcellent.challenge.elaborate.analyze;

import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import de.exxcellent.challenge.elaborate.model.Entity;
import de.exxcellent.challenge.elaborate.repository.EntityRepository;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 */
public class WeatherAnalyzer extends Analyzer {
    
    public Entity getDayWithLowestTempDiff( EntityRepository rep ) throws NoMatchingDataFoundException {
        return this.findEntityWithSmallestDiffForInteger(rep, "MxT", "MnT");
    }
}
