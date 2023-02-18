package Config.Settings;

import java.util.ResourceBundle;

/**
 * Class with database settings
 */
public class DBSettings {
    /**
     * Resource bundle
     */
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("Config/Settings/database");

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
