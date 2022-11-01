package aut.funcional.pages;

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
    By buttonsDates = By.xpath("//div[@class='calendarBox lmn-sw-select-responsive lmn-sw-tooltip-responsive']");
    By inputOrigen = By.xpath("//input[@id='input-o44jj']");
    By inputDestino = By.xpath("//input[@id='input-kskxe']");
    By btnSearch = By.xpath("//div[text()='Buscar']");
    By btnAddPasengers = By.xpath("//div[@class='passengersDropdown lmn-sw-select-responsive lmn-sw-tooltip-responsive']");
    By btnChooseClass = By.xpath("//div[@class='lmn-sw-select-responsive custom-select-responsive']");
    By passengersOptions = By.xpath("//div[@class='lmn-sw-selectionControls__control lmn-sw-selectionControls__control-plus']");
    By classOptions = By.xpath("//div[@class='select-items']");
    //Fechas locator
    // 12/11= //*[@id="search-widget"]//div[1]/div[2]/div[2]/div[13]
    //21/12 = //*[@id="search-widget"]//div[1]/div[2]/div[2]/div[25]

    //List
    List<WebElement> listDates = findElements(buttonsDates);
    List<WebElement> listPassengersOptions = findElements(passengersOptions);
    List <WebElement> listClassOptions = findElements(classOptions);

    //Funciones
    public void selectFechaIda(By locator){
        click(listDates.get(0));
        click(locator);
    }
    public void selectFechaVuelta(By locator){
        click(listDates.get(1));
        click(locator);
    }

    public void addAdult(int cant){
        if(cant > 0) {
            click(btnAddPasengers);
            for (int i = 0; i < cant; i++) {
                click(listPassengersOptions.get(0));
            }
        } else {
            throw new NullPointerException();
        }
    }
    public void addChild(int cant){
        if(cant > 0) {
        click(btnAddPasengers);
        for (int i = 0; i < cant; i++){
            click(listPassengersOptions.get(1));
        }
        } else {
            throw new NullPointerException();
        }
    }
    public void addBaby(int cant){
        if(cant > 0) {
        click(btnAddPasengers);
        for (int i = 0; i < cant; i++){
            click(listPassengersOptions.get(2));
        }
        } else {
            throw new NullPointerException();
        }
    }

    public void selectClassOption(String clase) throws NullPointerException{
        WebElement actual = null;
        int i = 0;
        boolean success = false;
        if(!clase.isEmpty()){
            click(btnChooseClass);
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
        write("Milan",inputOrigen);
        click(listOrigenOpcion);
    }

    public void writeOnDestinationRyanair(){
        write("Nueva",inputDestino);
        click(listDestinoOpcion);
    }
    public void searchWithSearchBtn(){
        click(btnSearch);
    }

    //El metodo write ya hace una validacion
    public void validateInputs(){
        isDisplayed(inputDestino);
        isDisplayed(inputOrigen);
    }
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

    //entorno a las fechas deshabilitadas se puede hacer un assertfalse con el isEnable();
}
