package aut.funcional.pages.cruceros;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CruceroFormularioDetalle extends SeleniumWrapper {
    public CruceroFormularioDetalle(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By nombreInput = By.xpath("//input[@formcontrolname='firstname']");
    By apellidoInput = By.xpath("//input[@formcontrolname='lastname']");
    By paisTelefono = By.xpath("//div[@class='iti__flag-container']");
    By fonoInput = By.xpath("//input[@placeholder='Inserta tu número de teléfono']");
    By emailInput = By.xpath("//input[@formcontrolname='email']");
    By comentariosTextArea = By.xpath("//textarea[@formcontrolname='notes']");
    By consentimientoCheck = By.xpath("(//span[@class='check'])[3]");


    //Opciones formulario
    By opcionUno = By.xpath("(//div[@class='crs_option_item__label'])[1]");
    By opcionDos = By.xpath("(//header/div[@class='radio'])[2]");


    //Medios de pago
    By transferenciaBancaria = By.xpath("//label[@for='BankTransfer']");
    By tarjetaInputNumero = By.id("pan");

    By btnRumboVip = By.xpath("//div[@class='crs_ancillary__title']//label");




    /*@FindBy(name = "dropdown")
    WebElement mesCaducidadSelect;*/
    By mesCaducidadSelect = By.name("expireMonth");
    By anoCaducidadSelect = By.name("expireYear");

    public void ingresarNombre(String nombre){
        esperaImplicita(2000, nombreInput);
        write(nombre, nombreInput);
    }

    public void ingresarApellido(String apellido){
        esperaImplicita(2000, apellidoInput);
        write(apellido, apellidoInput);
    }

    public void ingresarEmail(String email){
        esperaImplicita(2000, emailInput);
        write(email, emailInput);
    }

    public void ingresarComentario(String comentario){
        esperaImplicita(2000, comentariosTextArea);
        write(comentario, comentariosTextArea);
    }

    public void checkConsentimiento(){
        esperaImplicita(2000, consentimientoCheck);
        click(consentimientoCheck);
    }

    public void clickOpcionDos(){
        esperaImplicita(3000, opcionDos);
        click(opcionDos);
    }

    public void seleccionarTransferencia(){
        esperaImplicita(5000, transferenciaBancaria);
        click(transferenciaBancaria);
    }

    public void seleccionarRumboVip(){
        esperaImplicita(2000, btnRumboVip);
        click(btnRumboVip);
    }

    public String obtenerMensajeTransferencia(){
        By prueba = By.xpath("//header[@class='crs_booking_info__header ng-star-inserted']/h5");
        esperaImplicita(1000, prueba);
        return getText(prueba);
    }

    public Integer obtenerValorDetalle(){
        Integer valor = 0;
        By prueba = By.xpath("//aside[@role='complementary']//span[@class='crs_price']");
        esperaImplicita(2000, prueba);
        valor = cortarDescuento(getText(prueba));
        return valor;
    }

    public boolean evaluarMayor(Integer primero, Integer segundo){
        if(segundo > primero){
            return true;
        }else{
            return false;
        }
    }


}
