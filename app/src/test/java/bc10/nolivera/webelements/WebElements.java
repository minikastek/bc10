package bc10.nolivera.webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
    WebDriver driver;

    //localizaadores
    By barraBusquedaLocalizador = By.name("q");
    By btnBuscarConGoogleLocalizador = By.name("btnK");

    @BeforeEach
    void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    void busquedaGoogle(){
        //capturamos el atributo
        WebElement barraBusqueda = driver.findElement(barraBusquedaLocalizador);
        barraBusqueda.clear();
        barraBusqueda.sendKeys("Tsoft");
        WebElement btnBuscarConGoogle = driver.findElement(btnBuscarConGoogleLocalizador);
        btnBuscarConGoogle.click();
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}
