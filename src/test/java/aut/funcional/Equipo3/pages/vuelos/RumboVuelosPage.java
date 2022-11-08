package aut.funcional.Equipo3.pages.vuelos;

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
    By listDestinoPrimeraOpcion = By.xpath("//*[@id='mui-2-option-0' or @class='display-1xh37dz-Autocompleter-styled Mui-focused']");
    By btnAddPassengers = By.xpath("//div[@class='display-uq0tvk']");
    //By btnReduceAdultos = By.xpath("//button[1][@class='display-17x5pjv-Counter-styled']");
    By btnAddAdultos = By.xpath("//button[@aria-label='Aumentar el número de adultos']");
    By btnAddChildList = By.xpath("//button[@aria-label='Aumentar el número de niños']");
    By listClassOptions = By.xpath("//div[@class='display-1uq2lt0-DropdownList-styled-DropdownList-styled']");
    //div[@class='display-1nn5x59-Overlay-styled']
    By listChildAges = By.xpath("//ul[@class='display-vvt8xs-scrollbars-ChildPicker-styled']");
    By btnClass = By.xpath("//div[@class='display-12cbrmg']");
    By btnFechaIda = By.xpath("//div[1][@class='display-pfh0xi']//button");
    By btnFechaVuelta = By.xpath("//div[2][@class='display-pfh0xi']//button");
    By btnSearch = By.xpath("//button[text()='Buscar']");
    By btnRejectCookies = By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']");
    By btnEraseOrigen = By.xpath("//div[@aria-label='Clear']");
    By btnPreviousMonth = By.xpath("//button[@aria-label='Previous month']");
    By btnNextMonth = By.xpath("//button[@aria-label='Next month']");

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
    public boolean validateDisableBtn(By locator){
        return isEnabled(locator);
    }
    public void selectFechaIda(By locator){
        clickFechaIda();
        click(locator);
    }
    public void clickFechaIda(){
        click(btnFechaIda);
    }
    public void selectFechaVuelta(By locator){
        clickFechaVuelta();
        click(locator);
    }
    public void clickFechaVuelta(){
        click(btnFechaVuelta);
    }
    public void clickBtnPassengers(){
        click(btnAddPassengers);
    }
    public void addAdult(int cantidad)  {
        try{
            if(cantidad > 0){
             for(int i = 0; i <cantidad; i++) {
                 click(btnAddAdultos);
             }
            }
        }catch(NullPointerException e){
            throw e;
        }
    }

    public void addChild(int cantidad, String rango){
        click(btnAddChildList);
        List<WebElement> lista = findElements(listChildAges);
        for (int i = 0; i < lista.size() ; i++) {
            click(By.xpath("//li[normalize-space()='"+rango+"']"));
        }
    }

    public void selectClassOption(String clase) {
        click(btnClass);
        List <WebElement> lista = findElements(listClassOptions);
        WebElement actual = null;
        int i = 0;
        boolean success = false;
        if(!clase.isEmpty()){
            while (i < lista.size() && !success){
                actual = lista.get(i);
                if(actual.getText().equals(clase)){
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

    public void writeOnDestination(String destino) throws InterruptedException {
        write(destino,inputDestino);
        //Thread.sleep(3000);
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
        isDisplayed(listClassOptions);
        click(btnClass);
        isDisplayed(listClassOptions);
        click(btnFechaVuelta);
        isDisplayed(listClassOptions);
        click(btnFechaIda);
        isDisplayed(listClassOptions);
    }

    public boolean validateAlertNullInputMessage(){
        boolean message1 = validateMessage("Introduce ciudad o aeropuerto de origen", alertMessageNullOrigen);
        boolean message2 = validateMessage("Introduce ciudad o aeropuerto de destino", alertMessageNullDestino);
        return message1 && message2;
    }

  public boolean validateAlertSameValueInputMessage(){
        click(btnSearch);
        boolean result = validateMessage("El destino coincide con el origen", alertSameValueMessage);
        return result;
  }
}
