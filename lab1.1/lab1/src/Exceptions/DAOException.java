package Exceptions;

/**
 * DAO Exception
 */

public class DAOException extends Exception{
    /**
     * DAO Exception
     * @param message message
     * @param throwable throwable
     */
    public DAOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
