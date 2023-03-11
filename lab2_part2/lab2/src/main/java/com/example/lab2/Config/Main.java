package com.example.lab2.Config;

import com.example.lab2.Config.Controller.Requests;
import com.example.lab2.Config.Exceptions.PoolException;
import org.apache.log4j.BasicConfigurator;

/**
 * Main class
 * @author andrey1pf
 * @version 2.2
 */
public class Main {
    /**
     * Method for starting program
     * @param args - args
     */
    public static void main(String args[]) throws PoolException {
        BasicConfigurator.configure();
        Requests req = new Requests();
        req.Start();
    }
}