package Config.schemes;

import java.util.ResourceBundle;

public class SqlUpdate {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/schemes/update");

    public static String updateWorkerEmployment = resourceBundle.getString("UPDATE_WORKER_EMPLOYMENT");
}
