package Config.schemes;

import java.util.ResourceBundle;

public class SqlDelete {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/schemes/delete");

    public static String deleteCustomer = resourceBundle.getString("DELETE_CUSTOMER");
    public static String deleteOrder = resourceBundle.getString("DELETE_ORDER");
    public static String deleteService = resourceBundle.getString("DELETE_SERVICE");
    public static String deleteWorker = resourceBundle.getString("DELETE_WORKER");
}
