package aut.funcional.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class RumboVuelosPage  extends SeleniumWrapper {

    public RumboVuelosPage(WebDriver driver){
        super(driver);
    }
    
    String url = "https://www.rumbo.es/vuelos/";
    //Locators form search
    By btnIdaYVuelta = By.xpath("//div[normalize-space()='Ida y vuelta']");
    By btnIda = By.xpath("//div[normalize-space()='Solo ida']");
    By inputOrigen = By.xpath("//input[@id='mui-1']");
    //En las listas tendre que elegir la opcion 1 y si eso falla vere de buscar el xpath de la funcion
    By listOrigen = By.xpath("//ul[@id='mui-1-listbox']");
    By btnDestino = By.xpath("//input[@id='mui-2']");
    By listDestino = By.xpath("//ul[@id='mui-2-listbox']");
    By btnViajeros = By.xpath("//div[@class='display-uq0tvk']");
    By btnReduceAdultos = By.xpath("//button[1][@class='display-17x5pjv-Counter-styled']");
    By btnAddAdultos = By.xpath("//button[2][@class='display-17x5pjv-Counter-styled']");
    By btnAddChild = By.xpath("//div[normalize-space()='Añadir un niño']");
    By listChildAges = By.xpath("//ul[@class='display-vvt8xs-scrollbars-ChildPicker-styled']");
    By btnClass = By.xpath("//button[@class='display-1ug1iap-Dropdown-styled']");
    By optionPremiumTurist = By.xpath("//div[normalize-space()='Turista Premium']");
    By btnFechaIda = By.xpath("//div[1][@class='display-pfh0xi']//button");
    By btnFechaVuelta = By.xpath("//div[2][@class='display-pfh0xi']//button");
    By btnSearch = By.xpath("//button[text()='Buscar']");
}
