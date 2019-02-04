package de.exxcellent.challenge.elaborate.exceptions;

/**
 *
 * @author Thorsten Vobl {@literal <thorsten.vobl@googlemail.com>} 04.02.2019
 *
 */
public class ReaderException extends Exception {

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(Exception ex) {
        super(ex);
    }
}
