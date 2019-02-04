package de.exxcellent.challenge.elaborate.analyze;

import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import de.exxcellent.challenge.elaborate.model.Entity;
import de.exxcellent.challenge.elaborate.repository.EntityRepository;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>}
 */
public class FootballAnalyzer extends Analyzer {
    
    public Entity getTeamWithLowestGoalDifference( EntityRepository rep ) throws NoMatchingDataFoundException {
        return this.findEntityWithSmallestDiffForInteger(rep, "Goals", "Goals Allowed");
    }
    
}
