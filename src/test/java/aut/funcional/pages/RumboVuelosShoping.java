package aut.funcional.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RumboVuelosShoping extends SeleniumWrapper {
    public RumboVuelosShoping(WebDriver driver) {
        super(driver);
    }

    String url="https://vuelos.rumbo.es/flight/shopping/results/1h4btws0yvdhc";
    //Locators verificar que funcionen si es en solo ida
    By checkOneEscalaIda = By.xpath("//*[@id='filters-section--stops__view142']/div/div[2]/div/ul/li[1]/div/div/label/span");
    By checkTwoOrMoreEscalasIda = By.xpath("//*[@id='filters-section--stops__view142']/div/div[2]/div/ul/li[2]/div/div/label/span");
    By checkOneEscalaVuelta = By.xpath("//*[@id='filters-section--stops__view142']/div/div[3]/div/ul/li[1]/div/div/label/span");
    By getCheckTwoOrMoreEscalasVuelta = By.xpath("//*[@id='filters-section--stops__view142']/div/div[3]/div/ul/li[2]/div/div/label/span");
    //con las cositas que se mueve me parece que voy a tener que hacer una list de las cinco y luego pedir la 0,1,2, etc
    By listHandlesIzquierda = By.className("noUi-handle noUi-handle-lower btn btn-default");
    By listHandlesDerecha = By.className("noUi-handle noUi-handle-upper btn btn-default");
}
