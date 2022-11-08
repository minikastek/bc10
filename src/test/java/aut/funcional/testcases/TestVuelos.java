package aut.funcional.testcases;

import aut.funcional.pages.vuelos.RumboVuelosFDS;
import aut.funcional.pages.vuelos.RumboVuelosPage;
import aut.funcional.pages.vuelos.RumboVuelosRyanair;
import aut.funcional.pages.vuelos.RumboVuelosShopping;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestVuelos extends SeleniumTestBase {
    RumboVuelosPage rumboVuelos;
    RumboVuelosFDS rumboFDS;
    RumboVuelosRyanair rumboVuelosRyanair;
    RumboVuelosShopping rumboShopping;
    By fechaIdaLocator1 = By.xpath("//div[@class='monthContainer monthContainerFirst']//child::div[text()='12']");
    By fechaVueltaLocator1 = By.xpath("//div[@class='monthContainer monthContainerFirst']//child::div[text()='21']");
    By fechaVueltaLocator2 = By.xpath("//*[@id='hub-csw-container']//section//div/div[3]/div[2]/button[1]");
    @Test
    //TCV-MC-001 Busqueda de vuelos de la Aerolinea Ryanair
    void test1() throws InterruptedException, IOException {
        rumboShopping = new RumboVuelosShopping(DriverFactory.getDriver());
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
        rumboVuelosRyanair = new RumboVuelosRyanair(DriverFactory.getDriver());
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.navigateToAirlineView("Ryanair");
        rumboVuelos.handleTab();
        File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imageTest1AVuelos.png"));
        rumboVuelosRyanair.writeOnOriginRyanair();
        rumboVuelosRyanair.writeOnDestinationRyanair();
        rumboVuelosRyanair.clickFechaIda();
        rumboVuelosRyanair.selectFechaIda(fechaIdaLocator1, 0);
        rumboVuelosRyanair.clickFechaVuelta();
        rumboVuelosRyanair.selectFechaVuelta(fechaVueltaLocator1, 1);
        rumboVuelosRyanair.addPassengers("Adultos", 3);
        rumboVuelosRyanair.addPassengers("Niños", 1);
        rumboVuelosRyanair.selectClassOption("Business");
        rumboVuelosRyanair.searchWithSearchBtn();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assertions.assertTrue(rumboShopping.validateViewShopping());
        File scrFile2 = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("./imageTest1BVuelos.png"));
    }

    //TCV-MC-002
    @Test
    void test2() throws InterruptedException, IOException {
       rumboShopping = new RumboVuelosShopping(DriverFactory.getDriver());
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.writeOnOrigin("Madrid (MAD) Adolfo Suárez Barajas, España");
        rumboVuelos.writeOnDestination("Bangkok Todos los aeropuertos, Tailandia");
        rumboVuelos.clickFechaIda();
        rumboVuelos.selectFechaIda(By.xpath("//*[@id='hub-csw-container']//section//div[2]/div[2]/button[22]"));
        rumboVuelos.clickFechaVuelta();
        rumboVuelos.selectFechaVuelta(fechaVueltaLocator2);
        rumboVuelos.addAdult(1);
        rumboVuelos.addChild(1, "Bebé, 0-11 meses");
        rumboVuelos.addChild(1, "3 años");
        rumboVuelos.addChild(1, "10 años");
        rumboVuelos.selectClassOption("Turista Premium");
        rumboVuelos.clickBtnBuscar();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imageTest2Vuelos.png"));
        Assertions.assertTrue(rumboShopping.validateBannerPlus());
    }
    //TCV-HC-001
    @Test
    void test3() throws InterruptedException {
        rumboShopping = new RumboVuelosShopping(DriverFactory.getDriver());
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Solo ida");
        rumboVuelos.writeOnOrigin("Madrid (MAD) Adolfo Suárez Barajas, España");
        rumboVuelos.writeOnDestination("Bangkok Todos los aeropuertos, Tailandia");
        rumboVuelos.clickFechaIda();
        rumboVuelos.selectFechaIda(By.xpath("//button[22]"));
        rumboVuelos.addAdult(2);
        rumboVuelos.addChild(1, "Bebé, 0-11 meses");
        rumboVuelos.addChild(1, "4 años");
        rumboVuelos.addChild(1, "7 años");
        rumboVuelos.selectClassOption("Turista Premium");
        rumboVuelos.clickBtnBuscar();
        Thread.sleep(3000);
        //seleccionar 1 escala
        rumboShopping.selectElement(By.xpath("//label[normalize-space()='1 escala']"));
        Thread.sleep(3000);
        //seleccionar 2 escala
            rumboShopping.selectElement(By.xpath("//label[normalize-space()='2 escalas o más']"));
        Thread.sleep(3000);
       //deselecciono la 2 escala
        rumboShopping.selectElement(By.xpath("//label[normalize-space()='2 escalas o más']"));
        Thread.sleep(3000);
        //duracion
        rumboShopping.selectBarFilter(By.xpath("//*[@id='filters-section--stops__view119']//div[4]//div[3]//div[2]"));
        Thread.sleep(3000);
        //horario ida
        rumboShopping.selectBarFilter(By.xpath("//*[@id='filters-section--timerange__view119']/div/div[1]//div[3]//div[3]"));
        Thread.sleep(3000);
        //horario duracion de vuelo
        rumboShopping.selectBarFilter(By.xpath("//*[@id='filters-section--timerange__view119']//div[3]//div[3]//div[2]"));
        Thread.sleep(3000);
        //click varias compañias
        rumboShopping.selectElement(By.xpath("//label[normalize-space()='Varias compañías']"));
        Thread.sleep(3000);
        //move btn precio
        rumboShopping.selectBarFilter(By.xpath("//*[@id='filters-section--price__view119']//div[3]/div"));
        Thread.sleep(3000);
        //select airport ida
        rumboShopping.selectElement(By.xpath("//label[normalize-space()='Madrid Adolfo Suárez Barajas (MAD)']"));
        Thread.sleep(3000);
        //select airport vuelta
        rumboShopping.selectElement(By.xpath("//label[normalize-space()='Bangkok Suvarnabhumi Internacional (BKK)']"));
        Assertions.assertTrue(rumboShopping.validateBannerPlus());
    }


    //TCV-LC-001
    @Test
    void test4() throws IOException, InterruptedException {
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.writeOnOrigin("Madrid (MAD) Adolfo Suárez Barajas, España");
        rumboVuelos.writeOnDestination("Madrid");
        rumboVuelos.clickBtnBuscar();
        Assertions.assertTrue(rumboVuelos.validateAlertSameValueInputMessage());
        File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imageTest4Vuelos.png"));
    }
    //TCV-LC-002
    @Test
    void test5() throws IOException {
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
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
        File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imageTest5Vuelos.png"));
    }
    //TCV-HC-002
    @Test
    void test6() throws InterruptedException {
        rumboFDS = new RumboVuelosFDS(DriverFactory.getDriver());
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
        rumboShopping = new RumboVuelosShopping(DriverFactory.getDriver());
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        //voy a vuelos baratos
        rumboVuelos.moveTo(By.xpath("//p[normalize-space()='¿Estás pensando en escaparte alguno de los próximos findes? ¡Te lo ponemos fácil!']"));
        //voy a vuelos fin de semana
        rumboVuelos.navigateToViewByClick("Vuelos de fin de semana");
        rumboFDS.handleTab();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //me muevo hacia abajo para cargar
        rumboFDS.gotToSubTitle("Salidas desde Madrid");
        rumboFDS.gotToSubTitle("Salidas desde Barcelona o Girona");
        //eligo ibiza en subtitulo 2
        rumboFDS.clickOnElementOnSubtitle2("Ibiza");
        rumboFDS.handleTab();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Me muevo a la seccion escalas
        rumboShopping.moveTo(By.xpath("//div[starts-with(@id,'filters-section--timerange')]"));
        //Ninguna ida
        rumboShopping.selectElement(By.xpath("//*[@id='filters-section--stops__view141']//div[2]//li[1]"));
        Thread.sleep(3000);
        //Ninguna vuelta
        rumboShopping.selectElement(By.xpath("//*[@id='filters-section--stops__view141']//div[3]//li[1]"));
        Thread.sleep(3000);
        //ver solo viajes sin escalas
        rumboShopping.selectElement(By.xpath("//label[@data-e2e='brgui-switcher']"));
        Thread.sleep(3000);
        //duracion de la escala
        rumboShopping.selectBarFilter(By.xpath("//*[@id='filters-section--stops__view141']//div[4]//div[3]//div[2]"));
        Thread.sleep(3000);
        rumboShopping.moveTo(By.xpath("//div[@class='providers-filter-view__top-providers']"));
        rumboShopping.selectCompañia("Air Europa");
        Thread.sleep(3000);
        //clean filters
        rumboShopping.cleanFilters();
        Thread.sleep(3000);
        rumboShopping.selectOptionTheCheapiestFlight();
        Thread.sleep(3000);
        rumboShopping.selectOptionFastestFlight();
        Thread.sleep(3000);
        rumboShopping.selectFlight(By.id("2022-11-19T21:05:00.000-2022-11-19T22:00:00.000-BCN-IBZ"));
        Thread.sleep(3000);
        rumboShopping.clickPrice(By.xpath("//div[@class='FullTripCard__SelectedPriceContainer-sc-z8znd4-4 dZEvhO']"));
        Thread.sleep(5000);
        rumboShopping.clickVerDetalles();
        rumboShopping.closeDetalles();
        rumboShopping.selectFlexible();
        Assertions.assertTrue(rumboShopping.validateAlmostFinishedProcess());
    }
    //TCV-LC-004
    @Test
    void test7(){
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.clickFechaVuelta();
        for (int i = 0; i < 12; i++) {
            rumboVuelos.click(By.xpath("//button[@aria-label='Next month']"));
        }
        Assertions.assertFalse(rumboVuelos.validateDisableBtn(By.xpath("//div[2]//section//div[2]/div[2]/div[6]/button")));
    }
    //TCV-LC-003
    @Test
    void test8(){
        rumboVuelos = new RumboVuelosPage(DriverFactory.getDriver());
        rumboVuelos.navigateToViewVuelos();
        rumboVuelos.deleteCookies();
        rumboVuelos.selectOptionVuelo("Ida y vuelta");
        rumboVuelos.clickFechaIda();
        Assertions.assertFalse(rumboVuelos.validateDisableBtn(By.xpath("//div[2]//section//div[2]/div[2]/div[7]/button")));
    }

}
