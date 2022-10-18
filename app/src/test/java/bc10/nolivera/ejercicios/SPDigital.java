package bc10.nolivera.ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SPDigital {
    WebDriver driver;

    //localizaadores
    By elementoQuinesSomos = By.xpath("/html/body/div[1]/div[1]/div/div[4]/section[16]/div/div[1]/span/span[2]/ul/li[1]/a");
    By elementoPago = By.xpath("/html/body/div[1]/div[1]/div/div[4]/section[15]/div/div/span[3]/span[1]/a");
    By elementoSPLabs = By.xpath("/html/body/div[1]/div[1]/div/div[4]/section[16]/div/div[1]/span/span[2]/ul/li[3]/a");

    @BeforeEach
    void setUp (){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.spdigital.cl/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    void busquedaSPDigital(){
        WebElement barraBusqueda = driver.findElement(By.className("Fractal-SearchBar--searchbar"));
        barraBusqueda.clear();
        barraBusqueda.sendKeys("mouse");
        WebElement btnBuscar = driver.findElement(By.className("Fractal-SearchBar--button"));
        btnBuscar.click();

        driver.navigate().back();
    }

    @Test
    void entrarQuienesSomos(){
        WebElement quienesSomos = driver.findElement(elementoQuinesSomos);
        quienesSomos.click();

        driver.navigate().back();
    }

    @Test
    void entrarPago(){
        WebElement Pago = driver.findElement(elementoPago);
        Pago.click();

        driver.navigate().back();
    }

    @Test
    void entrarSPLabs(){
        WebElement SPLabs = driver.findElement(elementoSPLabs);
        SPLabs.click();

        driver.navigate().back();
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}

