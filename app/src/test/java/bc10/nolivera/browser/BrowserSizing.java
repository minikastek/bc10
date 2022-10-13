package bc10.nolivera.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSizing {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
    }

    @Test
    void browserSize(){
        driver = new EdgeDriver();
        driver.get("https://www.google.com");

        //largo y ancho de la ventana
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        //dimension
        Dimension dimension = driver.manage().window().getSize();
        int width2 = dimension.getWidth();
        int height2 = dimension.getHeight();

        //cambiar el tamaño en tiempo de ejecusion
        driver.manage().window().setSize(new Dimension(600, 400));
    }

    @Test
    void browserPosition(){
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();

        // position
        Point posicion = driver.manage().window().getPosition();
        int x2 = posicion.x;
        int y2 = posicion.y;

        //modificar la posicion de la ventana - browser -. driver
        driver.manage().window().setPosition(new Point(0,0));
    }

    @AfterEach
    void close(){
        driver.quit();
    }

}