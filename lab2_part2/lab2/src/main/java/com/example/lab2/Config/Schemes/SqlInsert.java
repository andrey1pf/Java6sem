package com.example.lab2.Config.Schemes;

import java.util.ResourceBundle;

/**
 * Class for inserting raw database tables
 */
public class SqlInsert {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/Schemes/insert");

    public static String insertCustomer = resourceBundle.getString("INSERT_NEW_CUSTOMER");
    public static String insertOrder = resourceBundle.getString("INSERT_NEW_ORDER");
    public static String insertService = resourceBundle.getString("INSERT_NEW_SERVICE");
    public static String insertWorker = resourceBundle.getString("INSERT_NEW_WORKER");
}
