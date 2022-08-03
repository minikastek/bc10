package framework.engine.utils;

import lombok.extern.apachecommons.CommonsLog;

import java.util.Properties;

@CommonsLog
public class Constants {

    private Constants() {
    }

    static Properties properties = LoadProperties.loadProperties();
    public static final String BASE_URL_API = properties.getProperty("url.api");
    public static final String BASE_URL_AUT = properties.getProperty("url.aut");

    public static final String LOGIN = properties.getProperty("login.admin.aut");
    public static final String PASSWORD = properties.getProperty("password.admin.aut");
}
