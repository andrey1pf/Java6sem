package Config.settings;

import java.util.ResourceBundle;

public class DBSettings {
    /**
     * Resource bundle
     */
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/settings/database");

    /**
     * Database URL
     */
    public static String URL = resourceBundle.getString("URL");
    /**
     * Database username
     */
    public static String USERNAME = resourceBundle.getString("USERNAME");
    /**
     * Database password
     */
    public static String PASSWORD = resourceBundle.getString("PASSWORD");
}
