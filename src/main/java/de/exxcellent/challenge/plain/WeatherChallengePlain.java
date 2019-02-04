package de.exxcellent.challenge.plain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@infoscreen.de>}
 * 04.02.2019
 *
 */
public class WeatherChallengePlain {
    
    public String getDayWithLowestTempDiff( String dataFileName ) {
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader( System.getProperty("user.dir") + "/target/classes/de/exxcellent/challenge/" + dataFileName );
            br = new BufferedReader(fr);
            
            // throw away headers
            br.readLine();
            
            String currentLowDiffDay = null;
            int currentLowDiffValue = -1;
            String line = null;
            while(( line = br.readLine()) != null ) {
                String[] fields = line.split(",");
                String day = fields[0];
                int maxTemp = Integer.parseInt(fields[1]);
                int minTemp = Integer.parseInt(fields[2]);
                
                int tempDiff = maxTemp - minTemp;
                
                if( currentLowDiffValue == -1 || tempDiff < currentLowDiffValue) {
                    currentLowDiffValue = tempDiff;
                    currentLowDiffDay = day;
                }                
            }
            
            return currentLowDiffDay;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WeatherChallengePlain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeatherChallengePlain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if( fr != null ) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(WeatherChallengePlain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if( br != null ) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(WeatherChallengePlain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }        
}
