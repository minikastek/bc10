package aut.funcional.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class RumboVuelosPage  extends SeleniumWrapper {

    public RumboVuelosPage(WebDriver driver){
        super(driver);
    }

    //Estaria bueno para mañana poner metodos que validen si estan Displayed o Selected
    String url = "https://www.rumbo.es/vuelos/";
    //Locators form search
    By btnIdaYVuelta = By.xpath("//div[normalize-space()='Ida y vuelta']");
    By btnIda = By.xpath("//div[normalize-space()='Solo ida']");
    By inputOrigen = By.xpath("//input[@id='mui-1']");
    By alertMessageNullOrigen = By.xpath("//span[text()='Introduce ciudad o aeropuerto de origen']");
    By alertMessageNullDestino = By.xpath("//span[text()='Introduce ciudad o aeropuerto de destino']");
    By alertSameValueMessage = By.xpath("//span[text()='El destino coincide con el origen']");
    By btnDelete = By.xpath("//div[@class='display-j0vjy-AutocompleterBase-styled-AutocompleterBase-styled']");
    By inputDestino = By.xpath("//input[@id='mui-2']");
    By listOrigenPrimeraOpcion = By.xpath("//ul[@id='mui-1-listbox']");
    By listDestinoPrimeraOpcion = By.xpath("//*[@id='mui-2-option-0']");
    By btnAddPassengers = By.xpath("//div[@class='display-uq0tvk']");
    //By btnReduceAdultos = By.xpath("//button[1][@class='display-17x5pjv-Counter-styled']");
    By btnAddAdultos = By.xpath("//button[2][@class='display-17x5pjv-Counter-styled']");
    By btnAddChildList = By.xpath("//div[normalize-space()='Añadir un niño']");
    By listDisplayOptions = By.xpath("//div[@class='display-1nn5x59-Overlay-styled']");
    By listChildAges = By.xpath("//ul[@class='display-vvt8xs-scrollbars-ChildPicker-styled']");
    By btnClass = By.xpath("//button[@class='display-1ug1iap-Dropdown-styled']");
    By btnFechaIda = By.xpath("//div[1][@class='display-pfh0xi']//button");
    By btnFechaVuelta = By.xpath("//div[2][@class='display-pfh0xi']//button");
    By btnSearch = By.xpath("//button[text()='Buscar']");
    By btnRejectCookies = By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']");
    By btnEraseOrigen = By.xpath("//div[@class='display-7133s2']//child::div[@class='display-j0vjy-AutocompleterBase-styled-AutocompleterBase-styled']");
    //locators fechas
    // 28/11 = //*[@id="hub-csw-container"]//div[2]/div[2]/button[28]
    // 1/12 = //*[@id="hub-csw-container"]//div[3]/div[2]/button[1]

    public void navigateToViewVuelos(){
        navigateTo(url);
    }
    public void navigateToViewByClick(String title){
        click(By.xpath("//h4[text()='"+ title + "']"));
    }
    public void deleteCookies(){
        click(btnRejectCookies);
    }

    public void eraseOrigin(){
        click(btnEraseOrigen);
    }
    public void selectOptionVuelo(String option){
        if (option.equals("Solo ida")) {
            click(btnIda);
        } else if(option.equals("Ida y vuelta")){
            click(btnIdaYVuelta);
        }
    }

    public void selectFechaIda(By locator){
        click(btnFechaIda);
        click(locator);
    }
    public void selectFechaVuelta(By locator){
        click(btnFechaVuelta);
        click(locator);
    }
    public void addAdult(int cantidad)  {
        try{
            if(cantidad > 0){
             click(btnAddPassengers);
             for(int i = 0; i <cantidad; i++) {
                 click(btnAddAdultos);
             }
            }
        }catch(NullPointerException e){
            throw e;
        }

    }

    public void addChild(int cantidad, String rango){
        click(btnAddPassengers);
        click(btnAddChildList);
        List<WebElement> lista = findElements(listChildAges);
        WebElement actual = null;
            if(cantidad > 0 && rango != null){
                for(int i = 0; i <cantidad; i++) {
                    actual = lista.get(i);
                    if(actual.getText().equals(rango)){
                        clickOnElement(actual);
                    }
                }
            } else {
                throw new NullPointerException();
            }

    }
    public void selectClassOption(String clase) throws NullPointerException{
        click(btnClass);
        List <WebElement> lista = findElements(listDisplayOptions);
        WebElement actual = null;
        int i = 0;
        boolean success = false;
        if(!clase.isEmpty()){
            while (i < lista.size() && !success){
                actual = lista.get(i);
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

    public void clickBtnBuscar(){
        click(btnSearch);
    }
    public void writeOnOrigin(String origen){
        write(origen,inputOrigen);
        click(listOrigenPrimeraOpcion);
    }

    public void writeOnDestination(String destino){
        write(destino,inputDestino);
        click(listDestinoPrimeraOpcion);
    }

    public void navigateToAirlineView(String aerolinea){
        if(aerolinea.equals("Ryanair") || aerolinea.equals("Wizz Air") || aerolinea.equals("Avianca")){
            clickOnElement(findElement(By.xpath("//h4[text()='" + aerolinea + "']")));
        }

    }

    public void validateButtons(){
        isDisplayed(btnIda);
        isDisplayed(btnSearch);
        isDisplayed(btnClass);
        isDisplayed(btnAddPassengers);
        isDisplayed(btnFechaIda);
        isDisplayed(btnIdaYVuelta);
        isDisplayed(btnFechaVuelta);
        click(btnAddPassengers);
        isDisplayed(btnAddAdultos);
        isDisplayed(btnAddChildList);

    }
    //El metodo write ya hace una validacion
    public void validateInputs(){
        isDisplayed(inputDestino);
        isDisplayed(inputOrigen);
    }

    public void validateDisplayOfOptions(){
        click(btnAddPassengers);
        isDisplayed(listDisplayOptions);
        click(btnClass);
        isDisplayed(listDisplayOptions);
        click(btnFechaVuelta);
        isDisplayed(listDisplayOptions);
        click(btnFechaIda);
        isDisplayed(listDisplayOptions);
    }

    public void validateAlertNullInputMessage(){
        //cuando haga el test deberia hacer algun tipo de refresh
        click(btnDelete);
        click(btnSearch);
        validateMessage("Introduce ciudad o aeropuerto de origen", alertMessageNullOrigen);
        validateMessage("Introduce ciudad o aeropuerto de destino", alertMessageNullDestino);
    }

  public void validateAlertSameValueInputMessage(){
        click(btnSearch);
        validateMessage("El destino coincide con el origen", alertSameValueMessage);
  }
}
