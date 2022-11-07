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
    By buttonsDates = By.xpath("//div[@class='calendarBox lmn-sw-select-responsive lmn-sw-tooltip-responsive']");

    By btnSearch = By.xpath("//div[text()='Buscar']");
    By btnAddPassengers = By.xpath("//div[starts-with(@class, 'passengersDropdown')]");
    By btnChooseClass = By.xpath("//div[@class='lmn-sw-select-responsive custom-select-responsive']");
    By passengersOptions = By.xpath("//div[@class='lmn-sw-selectionControls__control lmn-sw-selectionControls__control-plus']");
    //By classOptions = By.xpath("//div[@class='select-items']");
    By calendarArrowRight = By.xpath("//span[@class='icon icon-arrow_right']");
    By btnTurista = By.xpath("//div[@data-value='Y']");
    By btnTuristaPremium = By.xpath("//div[@data-value='P']");
    By btnBusiness = By.xpath("//div[@data-value='C']");
    By btnPrimera = By.xpath("//div[@data-value='F']");
    //List
    List<WebElement> listDates = findElements(buttonsDates);

    List <WebElement> listClassOptions;


    //Funciones
    public void selectFechaIda(By locator, int mes){
        //clickOnElement(listDates.get(0));
        //click(By.xpath("//div[@data-test='lmn-sw-cal-outbound']"));
        //click(By.xpath("//*[@id='search-widget']/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div"));
        clickFechaIda();
        if(mes > 0) {
            for (int i = 0; i < mes; i++) {
                click(calendarArrowRight);
            }
        }
        click(locator);
    }
    public void selectFechaVuelta(By locator, int mes){
        //clickOnElement(listDates.get(1));
        //click(By.xpath("//div[@data-test='lmn-sw-cal-inbound']"));
        clickFechaVuelta();
        if(mes > 0) {
            for (int i = 0; i < mes; i++) {
                click(calendarArrowRight);
            }
        }
        click(locator);
    }
    public void clickBtnPassengers(){
        click(btnAddPassengers);
    }
    public void deleteCookies(){
            click(By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']"));
    }
    public void addPassengers(String tipo, int cant ){
        if(cant > 0) {
            if(tipo.equals("Adultos")){
                for (int i = 0; i < cant; i++) {
                    click(By.xpath("//div[@data-type='adults']//child::div[@class='lmn-sw-selectionControls__control lmn-sw-selectionControls__control-plus']"));
                }
            } else if(tipo.equals("Niños")){
                for (int i = 0; i < cant; i++) {
                    click(By.xpath("//div[@data-type='children']//child::div[@class='lmn-sw-selectionControls__control lmn-sw-selectionControls__control-plus']"));
                }
            } else if (tipo.equals("Bebés")){
                for (int i = 0; i < cant; i++) {
                    click(By.xpath("//div[@data-type='infants']//child::div[@class='lmn-sw-selectionControls__control lmn-sw-selectionControls__control-plus']"));
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
public void clickChooseClass(){
    click(btnChooseClass);
}

    public void selectClassOption(String clase) throws NullPointerException{
        //WebElement actual = null;
        //int i = 0;
        //boolean success = false;
        if(!clase.isEmpty()){
           clickChooseClass();
            //listClassOptions = findElements(classOptions);
            if (clase.equals("Turista")) {
                    click(btnTurista);
            }else if(clase.equals("Turista Premium")){
                    click(btnTuristaPremium);
            } else if(clase.equals("Business")){
                    click(btnBusiness);
            } else if(clase.equals("Primera)")){
                    click(btnPrimera);
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
        isDisplayed(btnAddPassengers);
    }
    public void clickFechaVuelta(){
        click(By.xpath("//div[@data-test='lmn-sw-cal-inbound']"));
    }
    public void clickFechaIda(){
        click(By.xpath("//div[@data-test='lmn-sw-cal-outbound']"));
    }
    public void validateListOfOptions(){
        clickBtnPassengers();
        isDisplayed(passengersOptions);
        click(btnChooseClass);
        //isDisplayed(classOptions);
    }
    public void navigateToHomePage(){
        navigateTo(url);
    }
    //entorno a las fechas deshabilitadas se puede hacer un assertfalse con el isEnable();
}
