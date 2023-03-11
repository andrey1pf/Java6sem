package com.example.lab2.Config.Schemes;

import java.util.ResourceBundle;

/**
 * Class for updating raw database tables
 */
public class SqlUpdate {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/Schemes/update");

    public static String updateWorkerEmployment = resourceBundle.getString("UPDATE_WORKER_EMPLOYMENT");
}
