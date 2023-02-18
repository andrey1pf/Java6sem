package Config.Schemes;

import java.util.ResourceBundle;

/**
 * Class for selecting raw database tables
 */
public class SqlSelection {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/Schemes/selection");

    public static String selectAllCustomers = resourceBundle.getString("SELECT_ALL_CUSTOMERS");
    public static String selectCustomerById = resourceBundle.getString("SELECT_CUSTOMER_BY_ID");
    public static String selectAllOrders = resourceBundle.getString("SELECT_ALL_ORDERS");
    public static String selectOrdersById = resourceBundle.getString("SELECT_ORDERS_BY_ID");
    public static String selectAllServices = resourceBundle.getString("SELECT_ALL_SERVICE");
    public static String selectServiceById = resourceBundle.getString("SELECT_SERVICE_BY_ID");
    public static String selectAllWorkers = resourceBundle.getString("SELECT_ALL_WORKERS");
    public static String selectWorkerById = resourceBundle.getString("SELECT_WORKER_BY_ID");
    public static String selectAllOrdersById = resourceBundle.getString("SELECT_ALL_ORDERS_BY_ID");
    public static String selectServiceByOrderId = resourceBundle.getString("SELECT_WORKERS_BY_ORDER_ID");
    public static String selectNoPaidOrders = resourceBundle.getString("SELECT_NO_PAIR_ORDERS");
}
