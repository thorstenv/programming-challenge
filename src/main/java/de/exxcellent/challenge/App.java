package de.exxcellent.challenge;

import de.exxcellent.challenge.elaborate.analyze.FootballAnalyzer;
import de.exxcellent.challenge.elaborate.analyze.WeatherAnalyzer;
import de.exxcellent.challenge.elaborate.exceptions.FileTypeNotYetSupportedException;
import de.exxcellent.challenge.elaborate.exceptions.NoMatchingDataFoundException;
import de.exxcellent.challenge.elaborate.exceptions.ReaderException;
import de.exxcellent.challenge.elaborate.model.Entity;
import de.exxcellent.challenge.elaborate.reader.IReader;
import de.exxcellent.challenge.elaborate.reader.ReaderFactory;
import de.exxcellent.challenge.elaborate.repository.EntityRepository;
import de.exxcellent.challenge.plain.WeatherChallengePlain;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        ReaderFactory readerFactory = new ReaderFactory();
        
        try {
            IReader csvWeatherReader = readerFactory.getReaderForFileType("weather.csv");
            List<Entity> weatherData = csvWeatherReader.readEntities("weather.csv");
            EntityRepository weatherRepository = new EntityRepository();
            weatherRepository.addAllEntities(weatherData);
            WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer();
            Entity dayWithSmallestTempSpread = weatherAnalyzer.getDayWithLowestTempDiff(weatherRepository);
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread.getValue("Day"));
        } catch (FileTypeNotYetSupportedException | ReaderException | NoMatchingDataFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            IReader csvReader = readerFactory.getReaderForFileType("football.csv");
            List<Entity> footballData = csvReader.readEntities("football.csv");
            EntityRepository footballRepository = new EntityRepository();
            footballRepository.addAllEntities(footballData);
            FootballAnalyzer footballAnalyzer = new FootballAnalyzer();
            Entity teamWithSmallestGoalDifference = footballAnalyzer.getTeamWithLowestGoalDifference(footballRepository);
            System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalDifference.getValue("Team"));
        } catch (FileTypeNotYetSupportedException | ReaderException | NoMatchingDataFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        String dayWithSmallestTempSpread = new WeatherChallengePlain().getDayWithLowestTempDiff("weather.csv");
//        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
//        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        
        
//        String dayWithSmallestTempSpread = new WeatherChallengePlain().getDayWithLowestTempDiff("weather.csv");


//        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
//        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
