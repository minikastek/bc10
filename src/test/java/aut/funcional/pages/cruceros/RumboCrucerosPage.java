package aut.funcional.pages.cruceros;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    By btnBuscar = By.xpath("//span[normalize-space()='Buscar']");
    By ofertasMenu = By.xpath("//span[contains(text(),'Ofertas')]");
    By ultimaHoraMenu = By.xpath("//span[normalize-space()='Última hora']");

    //Primero es la de ofertas y segundo el del modulo central
    By cualquierDestinoSelector = By.xpath("(//div[@class='p-element p-multiselect-label-container ng-tns-c52-1' or @class='p-element p-multiselect-label-container ng-tns-c52-3'])[1]");
    By inputDestino = By.xpath("//input[@class='p-multiselect-filter p-inputtext p-component ng-tns-c52-1' or @class='p-multiselect-filter p-inputtext p-component ng-tns-c52-3']");
    By inputPeriodo = By.xpath("(//span[normalize-space()='Cualquier periodo'])[1]");
    By octubrePeriodo = By.xpath("(//span[normalize-space()='oct'])[1]");
    By diciembrePeriodo = By.xpath("(//span[normalize-space()='dic'])[2]");

    By inputDuracion = By.id("pr_id_1_label");
    By duracionSeisNueveDias = By.xpath("//span[normalize-space()='De 6 a 9 días']");
    By duracionMasNueveDias = By.xpath("//span[normalize-space()='más de 9 días']");
    By puertoInput = By.xpath("(//div[@class='p-element p-multiselect-label-container ng-tns-c52-6'])[1]");
    By inputTextPuerto = By.xpath("(//input[@role='textbox'])[1]");
    By checkMiami = By.xpath("(//div[@class='p-checkbox-box'])[1]");
    By pickerAnoPeriodo = By.xpath("(//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c56-10'])[1]");
    By mesPickerEnero = By.xpath("(//span[@class='p-ripple p-element p-monthpicker-month ng-tns-c56-9 ng-star-inserted'][normalize-space()='ene'])[1]");
    By marzoPeriodo = By.xpath("(//span[normalize-space()='mar'])[2]");


    //Pasajeros
    By inputPasajeros = By.xpath("(//div[@role='button'])[5]");
    By moreAdulto = By.xpath("(//button[contains(text(),'+')])[1]");
    By moreNino = By.xpath("(//button[contains(text(),'+')])[3]");



    //Cruceros
    By primerCrucero = By.xpath("(//button[@class='crs-btn crs-btn--cta crs-btn--small crs-btn--contain ng-star-inserted'])[1]");
    By primerCrucero2 = By.xpath("(//button[@class='crs-btn crs-btn--cta crs-btn--small crs-btn--contain'])[1]");


    //Formulario de pago
    By precioCrucero = By.xpath("(//div[@class='crs-price'])[4]/span");
    By btnSolicitarPresupuesto = By.xpath("//button[@class='crs-btn crs-btn--cta crs-btn--contain crs-btn--block ng-star-inserted']");

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
        esperaImplicita(3000, cualquierDestinoSelector);
        click(cualquierDestinoSelector);
        esperaImplicita(3000, inputDestino);
        write(texto, inputDestino);
        esperaImplicita(2000, selectorString);
        click(selectorString);
    }

    public void seleccionarInputPeriodo(){
        esperaImplicita(2000, inputPeriodo);
        click(inputPeriodo);
    }

    public void seleccionarMesPeriodo(){
        esperaImplicita(2000, diciembrePeriodo);
        click(diciembrePeriodo);
    }

    public void seleccionarDuracion(int opcion){
        esperaImplicita(3000, inputDuracion);
        click(inputDuracion);
        switch (opcion){
            case 1: esperaImplicita(3000,duracionMasNueveDias);
                    click(duracionMasNueveDias);
                    break;
            case 2: esperaImplicita(3000,duracionSeisNueveDias);
                    click(duracionSeisNueveDias);
                    break;
        }

    }


    public boolean esSeleccionable(){
        try {
            click(octubrePeriodo);
        }catch (Exception e){
            return false;
        }
        return true;
    }


  public void seleccionarPuertoMiami(){
        esperaImplicita(2000, puertoInput);
        click(puertoInput);
        esperaImplicita(2000,inputTextPuerto);
        write("Miami", inputTextPuerto);
        esperaImplicita(2000, checkMiami);
        click(checkMiami);
  }
  public void seleccionarEnero2023(){
      By inputPeriodo = By.xpath("//span[normalize-space()='diciembre 2022']");
        esperaImplicita(2000,inputPeriodo);
        click(inputPeriodo);
        esperaImplicita(2000,pickerAnoPeriodo );
        click(pickerAnoPeriodo);
        esperaImplicita(2000, marzoPeriodo);
        click(marzoPeriodo);
  }

  public void clickPrueba(){
        click(puertoInput);
  }

  public void selTresAdultos2NinosPasajeros(){
        esperaImplicita(2000, inputPasajeros);
        click(inputPasajeros);
        click(moreAdulto);
        click(moreNino);
        click(moreNino);
  }
  public void buscar(){
        esperaImplicita(3000, btnBuscar);
        click(btnBuscar);
  }

  public void primerCrucero(){
        esperaImplicita(3000, primerCrucero);
        click(primerCrucero);
  }

  public String obtenerValor(){
        return getText(precioCrucero);
  }


  public void clicprueba(){
      By prueba = By.xpath("//button[@class='crs-share-btn']");
      click(prueba);
  };


  //TEST LC002
    public void PrimerCrucero2(){
        click(primerCrucero2);
    }

    public void seleccionarEnero20232(){
        By btnCualquierPerido = By.xpath("(//span[@class='p-dropdown-trigger-icon pi pi-chevron-down'])[1]");
        esperaImplicita(3000, btnCualquierPerido);
        click(btnCualquierPerido);
        By btnsiguienteAno = By.xpath("//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c56-9']");
        esperaImplicita(3000, btnsiguienteAno);
        click(btnsiguienteAno);
        By enero = By.xpath("//span[@class='p-ripple p-element p-monthpicker-month ng-tns-c56-9 ng-star-inserted'][normalize-space()='ene']");
        esperaImplicita(3000, enero);
        click(enero);

    }

    public void companiaCostaCrucero(){
        By btnCualquierCompania = By.xpath("(//div[@class='crs-field-dropdown crs-field-dropdown--closed'])[3]");
        esperaImplicita(5000, btnCualquierCompania);
        click(btnCualquierCompania);
        By inputCompania = By.xpath("//input[@role='textbox']");
        write("Costa Crucero", inputCompania);
        By costaCruceroSelector = By.xpath("(//li[@aria-label='Costa Cruceros'])[1]");
        click(costaCruceroSelector);
    }

    public void seleccionarPuertoBarcelona(){
        By seleccionPuerto = By.xpath("//div[@class='p-element p-multiselect-label-container ng-tns-c52-6']");
        esperaImplicita(5000, seleccionPuerto);
        click(seleccionPuerto);
        By inputPuerto = By.xpath("//input[@role='textbox']");
        write("Barcelona", inputPuerto);
        By checkBarcelona = By.xpath("//li[@aria-label='Barcelona']");
        click(checkBarcelona);

    }

    public void seleccionarUnPasajero(){
        By btnPasajeros = By.xpath("//div[@class='crs-field-dd-occupancy crs_field--occupancy']//div[@role='button']");
        esperaImplicita(3000, btnPasajeros);
        click(btnPasajeros);
        By btnMenosPasajero = By.xpath("(//button[contains(text(),'-')])[1]");
        esperaImplicita(2000, btnMenosPasajero);
        click(btnMenosPasajero);
    }
    public void reiniciarBusqueda(){
        By btnReiniciarBusqueda = By.xpath("//button[@class='crs-btn crs-btn--secondary crs-btn--block ng-star-inserted']");
        esperaImplicita(3000, btnReiniciarBusqueda);
        click(btnReiniciarBusqueda);
    }

    public List<String> obtenerValoresForm(){
        String destino = getText(cualquierDestinoSelector);
        String periodo = getText(inputPeriodo);
        String duracion = getText(inputDuracion);
        By btnCualquierCompania = By.xpath("(//div[@class='crs-field-dropdown crs-field-dropdown--closed'])[3]");
        String compania = getText(btnCualquierCompania);
        By seleccionPuerto = By.xpath("//div[@class='p-element p-multiselect-label-container ng-tns-c52-6']");
        String puerto = getText(seleccionPuerto);
        By btnPasajeros = By.xpath("//div[@class='crs-field-dd-occupancy crs_field--occupancy']");
        String personas = getText(btnPasajeros);

        List<String> valoresForm = new ArrayList<String>(){
            {
                add(destino);
                add(periodo);
                add(duracion);
                add(compania);
                add(puerto);
                add(personas);
            }
        };
        return valoresForm;
    }

    public List<String> valoresEsperadosForm(){
        List<String> valoresForm = new ArrayList<String>(){
            {
                add("Cualquier destino");
                add("Cualquier periodo");
                add("Cualquier duración");
                add("Cualquier compañia");
                add("Cualquier puerto");
                add("2 Adultos");
            }
        };
        return valoresForm;
    }

    //TCCHC002
    public void seleccionarDiciembre(){
        esperaImplicita(3000, inputPeriodo);
        click(inputPeriodo);
        By mesDiciembre = By.xpath("//span[@class='p-ripple p-element p-monthpicker-month ng-tns-c56-7 ng-star-inserted'][normalize-space()='dic']");
        esperaImplicita(2000, mesDiciembre);
        click(mesDiciembre);
    }

    public void companiaMSCCruceros(){
        By btnCualquierCompania = By.xpath("//div[@class='p-element p-multiselect-label-container ng-tns-c52-3']");
        esperaImplicita(5000, btnCualquierCompania);
        click(btnCualquierCompania);
        By inputCompania = By.xpath("//input[@role='textbox']");
        esperaImplicita(2000, inputCompania);
        write("MSC Cruceros", inputCompania);
        By MSCCruceros = By.xpath("(//li[@aria-label='MSC Cruceros'])[1]");
        esperaImplicita(3000, MSCCruceros);
        click(MSCCruceros);
        limpiarInput(inputCompania);
        write("Costa Crucero", inputCompania);
        By costaCruceroSelector = By.xpath("(//li[@aria-label='Costa Cruceros'])[1]");
        esperaImplicita(2000, costaCruceroSelector);
        click(costaCruceroSelector);
    }

    public void sortRating(){
        By dropdown = By.xpath("(//div[@class='crs-field-dropdown crs-field-dropdown--closed'])[5]");
        esperaImplicita(2000, dropdown);
        click(dropdown);
        By rating = By.xpath("//li[@aria-label='Rating']");
        esperaImplicita(2000, rating);
        click(rating);

    }

    //TCCLC002
    By elementos = By.xpath("//span[@class='crs-discount__value']");
    public Integer obtenerMayoDescuento(){
        List<WebElement> elementosWeb = findElements(elementos);
        List<Integer> elemnetosString = new ArrayList<Integer>();
        int numeroMayor;
        for(WebElement e: elementosWeb){
                cortarDescuento(e.getText());
                elemnetosString.add(cortarDescuento(e.getText()));
        }
        numeroMayor = numeroMayor(elemnetosString);
        return numeroMayor;
    }

    public int prueba(){
        By descuentoDetalle = By.xpath("//span[@class='crs-discount__value']");
        Integer descuento = cortarDescuento(getText(descuentoDetalle));
        return descuento;
    }
}
