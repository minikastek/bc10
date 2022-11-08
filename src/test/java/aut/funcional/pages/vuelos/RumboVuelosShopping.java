package aut.funcional.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.*;

import java.util.List;

public class RumboVuelosShopping extends SeleniumWrapper {
    public RumboVuelosShopping(WebDriver driver) {
        super(driver);
    }
    String alertMessagePrecios = "Los precios promocionales que se muestran incluyen un descuento en los gastos de gestión. Si se añade alguno de nuestros servicios adicionales o servicios suplementarios proporcionados por la aerolínea (por ejemplo, equipaje facturado), el precio final puede verse afectado. Los vuelos con la etiqueta \"Conexión garantizada\" no están incluidos en la promoción.";
    //Locator
    By bannerPlus = By.xpath("//div[@class='PlusBanner__MembershipBannerContainer-cncr__sc-1mufavd-0 jQWmQE']");
    By messagePreciosAlert = By.xpath("//div[@class='js-message message alert alert--message alert-unboxed']");
    By btnCleanFilters = By.xpath("//button[normalize-space()='Limpiar filtros']");
    //By listCompaniesOptions = By.xpath("//div[@class='providers-filter-view__top-providers']//child::ul[@class='filters-group filters-group--condensed']");
    By btnVerDetalle = By.xpath("//button[normalize-space()='Detalles del vuelo']");
    By btnFlexible = By.xpath("//button[normalize-space()='Elegir Flexible']");
    By messageAlmostFinished = By.xpath("//div[normalize-space()='Ya casi has terminado: introduce los datos de los pasajeros']");
public void selectBarFilter(By locator){
        //esperaImplicita(3000, locator);
        moveTo(locator);
        clickElementonTheMiddle(locator);

}

public void selectElement(By locator){
    //esperaImplicita(3000, locator);
    moveTo(locator);
    click(locator);

}

public void cleanFilters(){
    moveTo(btnCleanFilters);
    click(btnCleanFilters);
}
    public void selectCompañia(String nombre){
    if(nombre.equals("Air Europa") || nombre.equals("Iberia") || nombre.equals("Ryanair") || nombre.equals("Vueling")){
        click(By.xpath("//div[@class='providers-filter-view__top-providers']//child::li[normalize-space()='"+nombre+"']"));
    }
    }
    public  void selectOptionTheBestFlight(){
    click(By.xpath("//*[@id='top-listing-container']/div[9]//ul/li[1]"));
    }
    public void selectOptionTheCheapiestFlight(){
        click(By.xpath("//*[@id='top-listing-container']/div[9]//ul/li[2]"));
    }
    public void selectOptionFastestFlight(){
        click(By.xpath("//*[@id='top-listing-container']/div[9]//ul/li[3]"));
    }
public boolean validateViewShopping(){
    return validateMessage(alertMessagePrecios, messagePreciosAlert);
}
public boolean validateBannerPlus(){
    return isDisplayed(bannerPlus);
}

    public void selectFlight(By id) {
    List<WebElement> listaVuelos = findElements(id);
    clickOnElement(listaVuelos.get(0));
    }
    public void clickPrice(By locator){
    List<WebElement> btnsPrice = findElements(locator);
    clickOnElement(btnsPrice.get(0));
    }
    public void clickVerDetalles(){
    click(btnVerDetalle);
    }
    public void closeDetalles(){
    click(By.xpath("//span[@class='DialogHeader__StyledIconCross-sc-1w5e8h4-1 ipHVDw']"));
    }

    public void selectFlexible(){
    click(btnFlexible);
    }
    public boolean validateAlmostFinishedProcess(){
    return validateMessage("Ya casi has terminado: introduce los datos de los pasajeros", messageAlmostFinished);
    }
}
