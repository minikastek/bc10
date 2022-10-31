package aut.funcional.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


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
    By inputDestino = By.xpath("//input[@id='mui-2']");
    By listDestino = By.xpath("//ul[@id='mui-2-listbox']");
    By btnViajeros = By.xpath("//div[@class='display-uq0tvk']");
    By btnReduceAdultos = By.xpath("//button[1][@class='display-17x5pjv-Counter-styled']");
    By btnAddAdultos = By.xpath("//button[2][@class='display-17x5pjv-Counter-styled']");
    By btnAddChildList = By.xpath("//div[normalize-space()='Añadir un niño']");

    By listChildAges = By.xpath("//ul[@class='display-vvt8xs-scrollbars-ChildPicker-styled']");
    By btnClass = By.xpath("//button[@class='display-1ug1iap-Dropdown-styled']");
    By listClass = By.xpath("//div[@class='display-1nn5x59-Overlay-styled']");
    //By optionPremiumTurist = By.xpath("//div[normalize-space()='Turista Premium']");
    By btnFechaIda = By.xpath("//div[1][@class='display-pfh0xi']//button");
    By btnFechaVuelta = By.xpath("//div[2][@class='display-pfh0xi']//button");
    By btnSearch = By.xpath("//button[text()='Buscar']");
    //locators fechas
    // 28/11 = //*[@id="hub-csw-container"]//div[2]/div[2]/button[28]
    // 1/12 = //*[@id="hub-csw-container"]//div[3]/div[2]/button[1]

    public void navigateToViewVuelos(){
        navigateTo(url);
    }

    public void selectOptionVuelo(String option){
        if (option.equals("Solo ida")) {
            click(btnIda);
        } else if(option.equals("Ida y vuelta")){
            click(btnIdaYVuelta);
        }
    }

    public void selectFechaIda(By locator){
        click(locator);
    }
    public void selectFechaVuelta(By locator){
        click(locator);
    }
    public void addAdult(int cantidad) throws NullPointerException {
        try{
            if(cantidad > 0){
             click(btnViajeros);
             for(int i = 0; i <cantidad; i++) {
                 click(btnAddAdultos);
             }
            }
        }catch(NullPointerException e){
            throw e;
        }

    }
   /* public void addBebe(int cantidad, String rango){

        try{
            if(cantidad > 0 && rango != null){
                click(btnViajeros);
                click(btnAddChildList);
                for(int i = 0; i <=cantidad; i++) {
                    if (rango.equals("0-11 meses")) {
                    click(btnAddBabyLocator1) ;
                    } else if(rango.equals("12-23 meses")){
                    click(btnAddBabyLocator2);
                    }
                }
            }
        }catch(NullPointerException e){
            throw e;
        }
    }

    */
    public void addChild(int cantidad, String rango) throws NullPointerException{
        List<WebElement> lista = findElements(listChildAges);
        WebElement actual = null;

            if(cantidad > 0 && rango != null){
                click(btnViajeros);
                click(btnAddChildList);
                for(int i = 0; i <cantidad; i++) {
                    actual = lista.get(i);
                    if(actual.getText().equals(rango)){
                        click(actual);
                    }
                }
            } else {
                throw new NullPointerException();
            }

    }
    public void selectClassOption(String clase) throws NullPointerException{
        List <WebElement> lista = findElements(listClass);
        WebElement actual = null;
        int i = 0;
        boolean success = false;
        if(!clase.isEmpty()){
            click(btnClass);
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
        /*switch (clase) {
            case "Cualquier clase":
                lista.get(0).click();
                break;
            case "Turista":
                    lista.get(1).click();
                break;
            case "Turista Premium":
                lista.get(2).click();
                break;
            case "Business":
                lista.get(3).click();
                break;
            case "Primera":
                lista.get(4).click();
                break;
        }

         */
    }

    public void clickBtnBuscar(){
        click(btnSearch);
    }

}
