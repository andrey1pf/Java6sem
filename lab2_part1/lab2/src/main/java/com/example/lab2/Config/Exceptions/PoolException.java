package com.example.lab2.Config.Exceptions;

/**
 * Exception class for ConnectionPool
 */
public class PoolException extends Exception{
    /**
     * method for return exception
     * @param message - message
     * @param throwable - throwable
     */
    public PoolException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
