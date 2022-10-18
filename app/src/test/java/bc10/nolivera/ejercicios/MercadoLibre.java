package bc10.nolivera.ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MercadoLibre {
    WebDriver driver;

    //localizaadores
    By elementoDireccion = By.xpath("/html/body/header/div/div[2]/ul/li[1]/a");
    By elementoCrearCuenta = By.xpath("/html/body/header/div/div[1]/nav[2]/a[1]");
    By elementoBeneficios = By.xpath("/html/body/main/div/div/section[4]/div/div[1]/a");
    By elementoTrabajaConNosotros = By.xpath("/html/body/footer/div/div[1]/div/nav/a[1]");
    By elementoAceptarCookies = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");

    @BeforeEach
    void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    void busquedaMercadoLibre() throws InterruptedException {
        WebElement Direccion = driver.findElement(elementoDireccion);
        Direccion.click();
        WebElement Zipcode = driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/input"));
        Zipcode.clear();
        Thread.sleep(500);
        Zipcode.sendKeys("5300");
        WebElement btnUsar = driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/div/button/span"));
        btnUsar.click();
        driver.close();
    }

    @Test
    void entrarBeneficios(){
        WebElement Beneficios = driver.findElement(elementoBeneficios);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
        Beneficios.click();
        driver.navigate().back();
    }

    @Test
    void entrarCrearCuenta() throws IOException{
        WebElement CrearCuenta = driver.findElement(elementoCrearCuenta);
        CrearCuenta.click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("./creoCuenta.png"));
        driver.navigate().back();
    }

    @Test
    void entrarTrabajaConNosotros() throws IOException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
        WebElement aceptarCookies = driver.findElement(elementoAceptarCookies);
        aceptarCookies.click();
        WebElement TrabajaConNosotros = driver.findElement(elementoTrabajaConNosotros);
        TrabajaConNosotros.click();
        WebElement VerOportunidades = driver.findElement(By.xpath("/html/body/div/div[2]/main/section[1]/div[5]/div/a/span"));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("./oportunidades.png"));
        driver.navigate().back();
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}
