package aut.funcional.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RumboVuelosShoping extends SeleniumWrapper {
    public RumboVuelosShoping(WebDriver driver) {
        super(driver);
    }
    //Locator
    By btnCleanFilters = By.xpath("//button[normalize-space()='Limpiar filtros']");

public void selectBarFilter(By locator){
        moveTo(locator);
        clickElementonTheMiddle(locator);
        esperaImplicita(3000, locator);
}

public void selectElement(By locator){
    moveTo(locator);
    click(locator);
    esperaImplicita(3000, locator);
}

public void cleanFilters(){
    moveTo(btnCleanFilters);
    click(btnCleanFilters);
}


}
