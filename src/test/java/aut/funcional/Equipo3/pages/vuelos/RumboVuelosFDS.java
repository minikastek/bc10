package aut.funcional.Equipo3.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RumboVuelosFDS extends SeleniumWrapper {

    public RumboVuelosFDS(WebDriver driver) {
        super(driver);
    }

    public void gotToSubTitle(String subtitulo){
        moveTo(By.xpath("//h3[normalize-space()='"+subtitulo +"']"));
    }

    public void clickOnElementOnSubtitle2(String e){
        click(By.xpath("//div[6]//div[9]//div[contains(h4, '"+e+"')]"));
    }

    public void clickOnElementOnSubtitle1(String e){
        click(By.xpath("//div[6]//div[2]//div[5]//div[contains(h4, '"+e+"')]"));
    }


}
