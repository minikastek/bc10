package aut.funcional.testcases;

import aut.funcional.pages.vuelos.RumboVuelosPage;
import aut.funcional.pages.vuelos.RumboVuelosRyanair;
import framework.engine.selenium.SeleniumTestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestVuelos extends SeleniumTestBase {
    RumboVuelosPage rumboVuelos;
    RumboVuelosRyanair rumboVuelosRyanair;
    By fechaIdaLocator1 = By.xpath("//div[@class='monthContainer monthContainerFirst']//child::div[text()='12']");
    By fechaVueltaLocator1 = By.xpath("//div[@class='monthContainer monthContainerFirst']//child::div[text()='21']");
    By fechaIdaLocator2 = By.xpath("//*[@id='hub-csw-container']//div[2]/div[2]/button[26]");
    By fechaIdaLocator3 = By.xpath("//*[@id='hub-csw-container']/div[2]//div[2]/div[2]/div[2]/button");
    By fechaVueltaLocator2 = By.xpath("//*[@id='hub-csw-container']//section//div[2]/div[5]/button");
    By fechaVueltaLocator3 = By.xpath("//*[@id='hub-csw-container']//section//div/div[3]/div[2]/button[1]");
    @Test
    //TCV-MC-001 Busqueda de vuelos de la Aerolinea Ryanair
    void test1(){
        Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);


        rumboVuelos = new RumboVuelosPage(super.driver);
        rumboVuelosRyanair = new RumboVuelosRyanair(super.driver);
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.navigateToAirlineView("Ryanair");
        //rumboVuelosRyanair.navigateToHomePage();
        //rumboVuelosRyanair.writeOnOriginRyanair();
        //rumboVuelosRyanair.writeOnDestinationRyanair();
        fluentwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='calendarBoxContainer outboundCalendarContainer']//child::div[@data-test='lmn-sw-cal-outbound']")));
        rumboVuelosRyanair.selectFechaIda(fechaIdaLocator1, 0);
        rumboVuelosRyanair.selectFechaVuelta(fechaVueltaLocator1, 1);
        rumboVuelosRyanair.addPassengers("Adultos", 3);
        rumboVuelosRyanair.addPassengers("Niños", 1);
        rumboVuelosRyanair.selectClassOption("Bussiness");
        rumboVuelosRyanair.searchWithSearchBtn();
    }

    //TCV-MC-002
    @Test
    void test2() throws InterruptedException, IOException {
        Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        rumboVuelos = new RumboVuelosPage(super.driver);
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.writeOnOrigin("Madrid (MAD) Adolfo Suárez Barajas, España");
        rumboVuelos.writeOnDestination("Bangkok Todos los aeropuertos, Tailandia");
        rumboVuelos.clickFechaIda();
        rumboVuelos.selectFechaIda(By.xpath("//*[@id='hub-csw-container']//section//div[2]/div[2]/button[26]"));
        rumboVuelos.clickFechaVuelta();
        rumboVuelos.selectFechaVuelta(fechaVueltaLocator3);
        rumboVuelos.addAdult(1);
        rumboVuelos.addChild(1, "Bebé, 0-11 meses");
        rumboVuelos.addChild(1, "3 años");
        rumboVuelos.addChild(1, "10 años");
        rumboVuelos.selectClassOption("Turista Premium");
        rumboVuelos.clickBtnBuscar();
        fluentwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content-layout-view__column-right col-md-9']")));
        //fluentwait.until(ExpectedConditions.urlMatches(driver.getCurrentUrl()));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imageTest2Vuelos.png"));
    }
    //TCV-HC-001
    @Test
    void test3() throws InterruptedException {
        rumboVuelos = new RumboVuelosPage(super.driver);
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Solo ida");
        rumboVuelos.writeOnOrigin("Madrid (MAD) Adolfo Suárez Barajas, España");
        rumboVuelos.writeOnDestination("Bangkok Todos los aeropuertos, Tailandia");
        rumboVuelos.clickFechaIda();
        rumboVuelos.selectFechaIda(By.xpath("//*[@id='hub-csw-container']//section//div[2]/div[2]/button[25]"));
        rumboVuelos.addAdult(2);
        rumboVuelos.addChild(1, "Bebé, 0-11 meses");
        rumboVuelos.addChild(1, "4 años");
        rumboVuelos.addChild(1, "7 años");
        rumboVuelos.selectClassOption("Turista Premium");
        rumboVuelos.clickBtnBuscar();
    }
    //TCV-LC-001
    @Test
    void test4() throws IOException, InterruptedException {
        rumboVuelos = new RumboVuelosPage(super.driver);
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.writeOnOrigin("Madrid (MAD) Adolfo Suárez Barajas, España");
        rumboVuelos.writeOnDestination("Madrid");
        rumboVuelos.clickBtnBuscar();
        Assertions.assertTrue(rumboVuelos.validateAlertSameValueInputMessage());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imageTest4Vuelos.png"));
    }
    //TCV-LC-002
    @Test
    void test5() throws IOException {
        rumboVuelos = new RumboVuelosPage(super.driver);
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Solo ida");
        rumboVuelos.eraseOrigin();
        rumboVuelos.selectFechaIda(By.xpath("//button[25]"));
        //No hace falta que haga click en add pasajeros porque se abre automaticamente luego de introducir la fecha
        rumboVuelos.addAdult(2);
        rumboVuelos.addChild(1, "Bebé, 0-11 meses");
        rumboVuelos.addChild(1, "2 años");
        rumboVuelos.addChild(1, "7 años");
        rumboVuelos.clickBtnPassengers();
        rumboVuelos.selectClassOption("Business");
        rumboVuelos.clickBtnBuscar();
        Assertions.assertTrue(rumboVuelos.validateAlertNullInputMessage());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imageTest5Vuelos.png"));
    }
    //TCV-HC-002
    @Test
    void test6(){


    }
    //TCV-LC-003
    @Test
    void test7(){
        rumboVuelos = new RumboVuelosPage(super.driver);
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.clickFechaVuelta();
        for (int i = 0; i < 12; i++) {
            rumboVuelos.click(By.xpath("//button[@aria-label='Next month']"));
        }
        Assertions.assertFalse(rumboVuelos.validateDisableBtn(fechaVueltaLocator2));
    }
    //TCV-LC-004
    @Test
    void test8(){
        rumboVuelos = new RumboVuelosPage(super.driver);
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.clickFechaIda();
        Assertions.assertFalse(rumboVuelos.validateDisableBtn(fechaIdaLocator3));
    }
}
