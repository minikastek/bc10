package framework.engine.selenium;

import framework.engine.utils.LoadProperties;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Properties;

public class SeleniumTestBase {

    private DriverFactory driverFactory;
    //cambie el driver a public
    public WebDriver driver;
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
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
    }


  /* @AfterEach
    void close(){
        driver.quit();
    }

   */



}
