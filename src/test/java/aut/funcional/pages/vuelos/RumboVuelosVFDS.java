package aut.funcional.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RumboVuelosVFDS extends SeleniumWrapper {

    public RumboVuelosVFDS(WebDriver driver) {
        super(driver);
    }

    //Atributtes
    //Viaje a chequear=//p[normalize-space()='Del 19 noviembre al 21 noviembre con salida desde Barcelona. ¡Reserva ya!']
    By noneStopoverIda = By.xpath("//*[@id='filters-section--stops__view140']//div[2]//li[1]/div");
    By noneStopoverVuelta = By.xpath("//*[@id='filters-section--stops__view140']//div[3]//li[1]//div/label");
    By btnSeeFligthsWithNoStopOver = By.xpath("//*[@id='filters-section--stops__view140']//div[2]/div/label");
    By btnMasBarato = By.xpath("//*[@id='top-listing-container']//li[2]");
    By btnMasRapido = By.xpath("//*[@id='top-listing-container']//li[3]");
    By firstOptionCheckbox = By.xpath("//*[@id=\"app-container\"]//section[2]/div/div[1]/div/div/div/div/div[1]/div/div/div[1]//div[1]/span/span");
    By btnPriceFirstOption = By.xpath("//*[@id=\"app-container\"]//div[1]//section[2]/div/div[1]/div/div/div/div/div[2]/div[1]/div");
    By btnCleanFilters = By.xpath("//button[@class='btn btn-default reset-button']");
    public void checkSalidasByText(String text){
        click(By.xpath("//p[normalize-space()='"+text+"']"));
    }

    public void selectAirline(String nombre){
        if(nombre.equals("Air Europa")){
             click(By.xpath("//span[text()='Air Europa']"));
        } else if(nombre.equals("Iberia")){
            click(By.xpath("//span[text()='Iberia']"));
        } else if(nombre.equals("Ryanair")){
            click(By.xpath("//span[text()='Ryanair']"));
        } else if(nombre.equals("Vueling")){
            click(By.xpath("//span[text()='Vueling']"));
        } else if(nombre.equals("Varias Compañias")){
            click(By.xpath("//span[text()='Varias compañías']"));
        }
        // =//*[@id="filters-section--providers__view140"]//div[1]//li[1]//label

    }

    public void resetFilters(){
        click(btnCleanFilters);
    }

    // #\32 022-11-19T21\:05\:00\.000-2022-11-19T22\:00\:00\.000-BCN-IBZ
}
