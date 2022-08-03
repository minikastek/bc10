package framework.engine.selenium;

import framework.engine.utils.LoadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SeleniumTestBase {

    private DriverFactory driverFactory;
    WebDriver driver;
    static Properties properties;

    @BeforeAll
    public static void LoadProperties() {
        properties = LoadProperties.loadProperties();
    }

    @BeforeEach
    void webDriverSetup(){
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.inicializarDriver(browserName);
    }

    @AfterEach
    void close(){
        driver.quit();
    }

}
