package aut.funcional.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static framework.engine.utils.Constants.BASE_URL_AUT;

public class GoogleHomePage extends SeleniumWrapper {

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //locators
    By barraBusquedaLocator = By.name("q");
    By btnBuscarConGoogleLocator = By.name("btnK");
    By btnVoyATenerSuerteLocator = By.name("btnI");

    //methods
    public void buscarConBotonBuscar(String busqueda){
        write(busqueda,barraBusquedaLocator);
        sendKeys(Keys.ESCAPE,barraBusquedaLocator);
        click(btnBuscarConGoogleLocator);
    }

    public void buscarConBotonVoyATenerSuerte(String busqueda){
        write(busqueda,barraBusquedaLocator);
        click(btnVoyATenerSuerteLocator);
    }

    public void navegarAlHome(){
        navigateTo(BASE_URL_AUT);
    }


}
