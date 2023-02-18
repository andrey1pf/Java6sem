package Config.schemes;

import java.util.ResourceBundle;

public class SqlInsert {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/schemes/insert");

    public static String insertCustomer = resourceBundle.getString("INSERT_NEW_CUSTOMER");
    public static String insertOrder = resourceBundle.getString("INSERT_NEW_ORDER");
    public static String insertService = resourceBundle.getString("INSERT_NEW_SERVICE");
    public static String insertWorker = resourceBundle.getString("INSERT_NEW_WORKER");
}
