package aut.funcional.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RumboVuelosRyanair extends SeleniumWrapper {
    public RumboVuelosRyanair(WebDriver driver) {
        super(driver);
    }
    //Estaria bueno para mañana poner metodos que validen si estan Displayed o Selected
    //url
    String url = "https://www.rumbo.es/vuelos/aerolineas/ryanair?int_type=CMS_FLI&int_campaign=SEO&int_detail=PHP_FLI_RMB_ryanair_13";
    //Locators
    By listOrigenOpcion = By.xpath("//div[@data-value='MXP']");
    By listDestinoOpcion = By.xpath("//div[@data-value='JFK']");
    By buttonsDates = By.xpath("//div[@class='calendarBoxText lmn-sw-responsive-form-field lmn-sw-tooltip-responsive__text']");

    By btnSearch = By.xpath("//div[text()='Buscar']");
    By btnAddPasengers = By.xpath("//div[starts-with(@class, 'passengersDropdown')]");
    By btnChooseClass = By.xpath("//div[@class='lmn-sw-select-responsive custom-select-responsive']");
    By passengersOptions = By.xpath("//div[@class='lmn-sw-selectionControls__control lmn-sw-selectionControls__control-plus']");
    By classOptions = By.xpath("//div[@class='select-items']");
    By calendarArrowRight = By.xpath("//span[@class='icon icon-arrow_right']");


    //List
    List<WebElement> listDates = findElements(buttonsDates);

    List <WebElement> listClassOptions;


    //Funciones
    public void selectFechaIda(By locator, int mes){
        //clickOnElement(listDates.get(0));
        click(By.xpath("//div[@class='calendarBoxContainer outboundCalendarContainer']//child::div[@data-test='lmn-sw-cal-outbound']"));
        if(mes > 0) {
            for (int i = 0; i < mes; i++) {
                click(calendarArrowRight);
            }
        }
        click(locator);
    }
    public void selectFechaVuelta(By locator, int mes){
        //clickOnElement(listDates.get(1));
        click(By.xpath("//div[@class='calendarBoxContainer inboundCalendarContainer']//child::div[@data-test='lmn-sw-cal-inbound']"));
        if(mes > 0) {
            for (int i = 0; i < mes; i++) {
                click(calendarArrowRight);
            }
        }
        click(locator);
    }
    public void deleteCookies(){
            click(By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']"));
    }
    public void addPassengers(String tipo, int cant ){
            WebElement e = null;
        if(cant > 0) {
            click(btnAddPasengers);
            if(tipo.equals("Adultos")){
                e = findElements(passengersOptions).get(0);
            } else if(tipo.equals("Niños")){
                e = findElements(passengersOptions).get(1);
            } else if (tipo.equals("Bebés")){
                e = findElements(passengersOptions).get(2);
            }
            for (int i = 0; i < cant; i++) {
                clickOnElement(e);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    /*public void addAdult(int cant){
        if(cant > 0) {
            click(btnAddPasengers);
            for (int i = 0; i < cant; i++) {
                clickOnElement(findElements(passengersOptions).get(0));
            }
        } else {
            throw new NullPointerException();
        }
    }
    public void addChild(int cant){
        if(cant > 0) {
        click(btnAddPasengers);
        for (int i = 0; i < cant; i++){
            clickOnElement(findElements(passengersOptions).get(1));
        }
        } else {
            throw new NullPointerException();
        }
    }
    public void addBaby(int cant){
        if(cant > 0) {
        click(btnAddPasengers);
        for (int i = 0; i < cant; i++){
            clickOnElement(findElements(passengersOptions).get(2));
        }
        } else {
            throw new NullPointerException();
        }
    }

     */

    public void selectClassOption(String clase) throws NullPointerException{
        WebElement actual = null;
        int i = 0;
        boolean success = false;
        if(!clase.isEmpty()){
            click(btnChooseClass);
            listClassOptions = findElements(classOptions);
            while (i < listClassOptions.size() && !success){
                actual = listClassOptions.get(i);
                if(actual.equals(clase)){
                    actual.click();
                    success = true;
                } else {
                    i++;
                }
            }
        } else {
            throw new NullPointerException();
        }

    }
    public void writeOnOriginRyanair(){
        writeWithElement("Milan", findElements(By.xpath("//input[starts-with(@id,'input')]")).get(0));
        click(listOrigenOpcion);
    }

    public void writeOnDestinationRyanair(){
        writeWithElement("Nueva", findElements(By.xpath("//input[starts-with(@id,'input')]")).get(1));
        /*clickOnElement(findElements(By.xpath("//input[@placeholder='Ciudad o aeropuerto']")).get(1));
       // click(listDestinoOpcion);

         */
        click(By.xpath("//span[contains(text(),'JFK')]"));
    }
    public void searchWithSearchBtn(){
        click(btnSearch);
    }

    //El metodo write ya hace una validacion
    /*public void validateInputs(){
        isDisplayed(inputDestino);
        isDisplayed(inputOrigen);
    }

     */
    public void validateBtns(){
        isDisplayed(buttonsDates);
        isDisplayed(btnSearch);
        isDisplayed(btnChooseClass);
        isDisplayed(btnAddPasengers);
    }

    public void validateListOfOptions(){
        click(btnAddPasengers);
        isDisplayed(passengersOptions);
        click(btnChooseClass);
        isDisplayed(classOptions);
    }
    public void navigateToHomePage(){
        navigateTo(url);
    }
    //entorno a las fechas deshabilitadas se puede hacer un assertfalse con el isEnable();
}
