package aut.funcional.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RumboCrucerosPage extends SeleniumWrapper {
    public RumboCrucerosPage(WebDriver driver) {
        super(driver);
    }

    //Url
    String url = "https://www.rumbo.es/";

    //Localizadores
    //Menu Ver Más
    By verMasMenuLoc = By.xpath("(//div/a[@title='Ver más'])[1]");
    By cruceroMenuLoc = By.xpath("(//ul/li/div/a[@title='Cruceros'])[1]");

    //Privacidad aceptar coockies
    By btnAceptarTodo = By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/button[2]");


    //Localizadores Cruceros

    By ofertasMenu = By.xpath("//span[contains(text(),'Ofertas')]");
    By ultimaHoraMenu = By.xpath("//span[normalize-space()='Última hora']");

    By cualquierDestinoSelector = By.xpath("(//div[@class='p-element p-multiselect-label-container ng-tns-c52-1'])[1]");
    By inputDestino = By.xpath("//input[@class='p-multiselect-filter p-inputtext p-component ng-tns-c52-1']");
    By inputPeriodo = By.xpath("(//span[normalize-space()='Cualquier periodo'])[1]");

    By octubrePeriodo = By.xpath("(//span[normalize-space()='oct'])[1]");



    //Funciones

    public void navegarHome(){
        navigateTo(url);
    }

    public void aceptarCoockies(){
        click(btnAceptarTodo);
    }
    public void navegarCruceros(){
        moveTo(verMasMenuLoc);
        click(cruceroMenuLoc);
    }

    public void navegarOfertas(){
        moveTo(ofertasMenu);
        click(ultimaHoraMenu);
    }
    public void seleccionarDestino(String texto){
        By selectorString = By.xpath(" (//li[@aria-label='"+texto+"'])[1]");
        click(cualquierDestinoSelector);
        write(texto, inputDestino);
        click(selectorString);
    }

    public void seleccionarPeriodo(){
        click(inputPeriodo);
    }

    public boolean esSeleccionable(){
        try {
            click(octubrePeriodo);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
