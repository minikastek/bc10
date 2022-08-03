package framework.testing.testcases;

import framework.engine.selenium.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class OpenAllWebBrowser {

    protected WebDriver driver;
    DriverFactory driverFactory;

    @Test
    void TestEdge(){
        Properties edgeProperties = new Properties();
        edgeProperties.put("browser","edge");
        String browserName = edgeProperties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.inicializarDriver(browserName);
        Assertions.assertTrue(driver.getWindowHandle() != null);
        driver.quit();

    }

    @Test
    void TestFirefox(){
        Properties firefoxProperties = new Properties();
        firefoxProperties.put("browser","firefox");
        String browserName = firefoxProperties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.inicializarDriver(browserName);
        Assertions.assertTrue(driver.getWindowHandle() != null);
        driver.quit();

    }

    @Test
    void TestNoFoundBrowserException(){
        Properties noBrowser = new Properties();
        noBrowser.put("browser","none");
        String browserName = noBrowser.getProperty("browser");
        driverFactory = new DriverFactory();
        Assertions.assertThrows(RuntimeException.class,()-> driver = driverFactory.inicializarDriver(browserName));

    }


}
