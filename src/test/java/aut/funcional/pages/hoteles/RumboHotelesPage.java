package aut.funcional.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.print.attribute.standard.Media;

public class RumboHotelesPage<ElementLocation> extends SeleniumWrapper {
    public RumboHotelesPage(WebDriver driver) {
        super(driver);
    }

    String url = "https://www.rumbo.es/";

    //Localizador Hoteles
    By HotelesBTN = By.xpath("//div[@class='display-1dpcy4y-HubNavigationMenu-styled e10w470p3']//a[@title='Hoteles'][normalize-space()='Hoteles']");


        //Localizador Hoteles
        By BTNHoteles = By.xpath("//div[@class='display-1dpcy4y-HubNavigationMenu-styled e10w470p3']//a[@title='Hoteles'][normalize-space()='Hoteles']");

        //Localizadores en Hoteles
        By FormBuscarHoteles = By.xpath("//input[@id='mui-1']");
        By BTNBuscar = By.xpath("//button[contains(@type,'submit')]");
        By BTNCualquierDestino = By.xpath("//span[normalize-space()='Cualquier destino']");

        //Localizador aceptarTodo
        static By BTNAceptarTodo = By.xpath("//button[normalize-space()='Aceptar todo']");

        //Localizador de lugares
        By BTNEspaña = By.xpath("//li[@id='mui-1-option-0']");
        By BTNBarcelona = By.xpath("//li[@id='mui-1-option-0']");
        By BTNLondresRU = By.xpath("//input[@id='mui-1']");


        //Localizadores Barcelona
        By BarraBusquedaBarcelona = By.xpath("//input[@id='mui-1']");
        By BotonBarcelona = By.xpath("//li[@id='mui-1-option-0']//span[contains(text(),'España')]");
        By BTNFlexBar = By.xpath("//button[normalize-space()='Fechas flexibles']");
        By BTNFechaFindeBar = By.xpath("//button[normalize-space()='Fin de semana']");
        By BTNDicBar = By.xpath("//section[contains(@class,'display-11ni3xq-Overlay-styled')]//button[3]//*[name()='svg']");
        By BuscarHotBar = By.xpath("//button[@type='submit']");

        //Localizadores Londres
        By BTNBarraBusquedaLondres = By.xpath("//input[@id='mui-1']");
        By FechasBTNLon = By.xpath("//div[contains(@class,'display-ju21yh-MonthsRangePicker-styled')]");
        By BTNFechasFlexLon = By.xpath("//button[normalize-space()='Fechas flexibles']");
        By BTNSieteLon = By.xpath("//button[normalize-space()='7-10 noches']");
        By FebLon = By.xpath("//button[@class='display-aycxxj-MonthsRangePicker-styled-MonthsRangePicker-styled']//*[name()='svg']");


        By BTNTodosLosFiltrosLon = By.xpath("//span[normalize-space()='Todos los filtros']");
        By BTNBuscarLondres = By.xpath("//button[@type='submit']");
        By BTNFiltroEstrellasLon = By.xpath("//span[normalize-space()='Estrellas']");
        By BTNTresEstrellasLon = By.xpath("//div[@class='sc-bhVIhj ioZiXt custom-overlay-portal ']//div[3]//*[name()='svg']//*[name()='rect' and contains(@width,'20')]");
        By BTNAplicarTresEstrellas = By.xpath("//button[@class='sc-TRNrF ivPGbO']");
        By BTNAplicarLon = By.xpath("//button[@class='sc-TRNrF ivPGbO']");
         By BTNFiltroValoracionLon = By.xpath("//span[normalize-space()='Valoración']");
         By BTNMuyBuenoLon = By.xpath("//body/div[contains(@class,'sc-bhVIhj ioZiXt custom-overlay-portal')]/div[@class='sc-eGAhfa dMYIUp']/div[1]//*[name()='svg']//*[name()='rect' and contains(@width,'20')]");
        By BTNAplicarValLon = By.xpath("//button[@class='sc-TRNrF ivPGbO']");

        By BTNHotelEconomicoLon = By.xpath("//div[18]//div[3]//a[1]//img[1]");

        By BotonFormLon = By.xpath("//input[@id='mui-1']");
        By BotonLondress = By.xpath("//li[@id='mui-1-option-0']//div[@class='display-wpcrn3-Autocompleter-styled']");








    //Mensaje error
        By MensajeErrorBusqueda = By.xpath("//span[@role='alert']");

        By BTNBuscarLC003 = By.xpath("//button[@type='submit']");



        //BuscarBarcelona
        //LC-002
        By FechasLC = By.xpath("//body//div//div[1]//div[1]//div[5]//div[1]//div[1]//div[2]//div[1]//form[1]//div[1]//div[2]//div[1]//div[1]//div[2]//button[1]//*[name()='svg']");
        By FlechaFechas = By.xpath("//input[@id='mui-1']");



        //TestHC001
        By BarraItaliaForm = By.xpath("//label[@id='mui-1-label']");
        By BTNIT = By.xpath("//li[@id='mui-1-option-0']//div[@class='listbox-item-icon display-1xc6ooi-Autocompleter-styled']");
        By BotonBuscarIt = By.xpath("//button[@type='submit']");


    //Estrellas
    By FiltroTresIt = By.xpath("//span[normalize-space()='Estrellas']");
    By CuatroEstrellasIT = By.xpath("//div[@class='sc-eGAhfa dMYIUp']//div[2]//*[name()='svg']//*[name()='rect' and contains(@width,'20')]");
    By AplicarEstrellasIT = By.xpath("//button[@class='sc-TRNrF ivPGbO']");

    //RecomendadiosPrecios
    By PrecioEcoIT = By.xpath("//span[normalize-space()='Por precio']");

    By WifiGratisIT = By.xpath("//div[contains(text(),'Wifi gratis')]");
    By CanceIT = By.xpath("//div[contains(text(),'Cancelación gratuita')]");

    //HotelItalia
    By HotelItalia = By.xpath("//body/div[@id='__next']/main[@class='sc-cLFqLo tkAxM openx-ui-main-collapsed']/div[@class='sc-dkdnUF bBaubr list-container']/div[@class='sc-WCkqM dyEyUY']/div[@class='sc-hTtwUo dbXSUh']/div[1]/a[1]");
    By ElegirHabIT = By.xpath("//span[normalize-space()='Habitaciones']");
    By ElegirHabitBIt = By.xpath("/html[1]/body[1]/div[2]/div[2]/section[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]");



    // Formulario fechas Italia
    By FechasIt = By.xpath("//button[@class='display-q24bix-DateInput-styled']//*[name()='svg']");
    By FechaFinIt = By.xpath("//button[normalize-space()='Fechas flexibles']");
    By FechaSieteIt = By.xpath("//button[normalize-space()='7-10 noches']");
    By FormEneIT = By.xpath("//body//div//div[1]//div[1]//div[5]//div[1]//div[1]//div[2]//div[1]//form[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//section[2]//div[1]//div[1]//div[1]//div[1]//button[4]//*[name()='svg']");
    By FormFebIT = By.xpath("//body//div//div[1]//div[1]//div[5]//div[1]//div[1]//div[2]//div[1]//form[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//section[2]//div[1]//div[1]//div[1]//div[1]//button[5]");
    By FormMarIT = By.xpath("//section[contains(@class,'display-11ni3xq-Overlay-styled')]//button[6]//*[name()='svg']//*[name()='path' and contains(@d,'M19 4H18V2')]");
    By FiltroValIt = By.xpath("//span[normalize-space()='Valoración']");
    By ValIT = By.xpath("//body/div[@class='sc-bhVIhj ioZiXt custom-overlay-portal ']/div[@class='sc-eGAhfa dMYIUp']/div[1]//*[name()='svg']//*[name()='rect' and contains(@width,'20')]");
    By AplyValIt = By.xpath("//button[@class='sc-TRNrF ivPGbO']");


    By HabitacionIt = By.xpath("//button[@class='Button-sc-1bbve8d-0 bsSjVP SubNavigation___StyledScrollToIdButton-sc-1sfp8me-7 jThHsW']");

    //Prueba Paris
    By BTNParis = By.xpath("//li[@id='mui-1-option-0']");

    By FechPar = By.xpath("//button[normalize-space()='Fechas flexibles']");
    By FechEntradaPar = By.xpath("//button[normalize-space()='2-3 noches']");
    By FechaSalidaPar = By.xpath("//section[contains(@class,'display-11ni3xq-Overlay-styled')]//button[4]//*[name()='svg']");
    By BuscarEnParis = By.xpath("//button[@type='submit']");
    By AbrirFiltrosPar = By.xpath("//div[@class='sc-tsFYE fUiLUD custom-sort-modal']//*[name()='svg']");
    By PrecioFil = By.xpath("//span[normalize-space()='Por precio']");
    By ValPar = By.xpath("//span[normalize-space()='Valoración']");
    By ValMuyBuenoPar = By.xpath("//div[@class='sc-eGAhfa dMYIUp']//div[2]//*[name()='svg']//*[name()='rect' and contains(@width,'20')]");
    By AplyValPar = By.xpath("//button[@class='sc-TRNrF ivPGbO']");
    By EstrellasFilPar = By.xpath("//div[@id='container_full_width']//div[3]//div[1]//*[name()='svg']");
    By TresEstrellasPar = By.xpath("//div[@class='sc-bhVIhj ioZiXt custom-overlay-portal ']//div[3]//*[name()='svg']//*[name()='rect' and contains(@width,'20')]");
    By AplyTresPar = By.xpath("//button[@class='sc-TRNrF ivPGbO']");
    By WifiGratisPar = By.xpath("//div[contains(text(),'Wifi gratis')]");
    By CancelacionPar = By.xpath("//div[contains(text(),'Cancelación gratuita')]");
    By HotelBaratoParis = By.xpath("//body/div[@id='__next']/main[@class='sc-cLFqLo tkAxM openx-ui-main-collapsed']/div[@class='sc-dkdnUF bBaubr list-container']/div[@class='sc-WCkqM dyEyUY']/div[@class='sc-hTtwUo dbXSUh']/div[1]/a[1]");



    //Funciones

        public void navegarAlHome(){
            navigateTo(url);
        }

        public void aceptarCoockies(){
            click(BTNAceptarTodo);
        }

        public void navegarHoteles(){
            click(BTNHoteles);
        }

        public void llenarFormHoteles(){
            click(FormBuscarHoteles);
            click(BTNCualquierDestino);
            click(BTNBuscar);
        }

        public void FaltaInformacion(){
            click(BTNBuscarLC003);
        }

        public String msjErrorBusqueda(){

            return getText(MensajeErrorBusqueda);
        }


       public void FormulariosBarcelona() {
        click(BTNFechaFindeBar);
        click(BTNDicBar);
        click(BuscarHotBar);
        }

    public void BarcelonaText() {
        writeWithElement("Barcelona", findElements(By.xpath("//input[@id='mui-1']")).get(0));
        click(BotonBarcelona);
        click(BTNFlexBar);
    }


     public void LondresForm(String texto){
        By StringText = By.xpath(" (//li[@aria-label='"+texto+"'])[1]");
        click(BTNBarraBusquedaLondres);
        write(texto, BTNLondresRU);
        click(FormBuscarHoteles);
    }


    public void FormLondres (){
            click(BotonLondress);
            click(BTNFechasFlexLon);
            click(BTNSieteLon);
            click(FebLon);
        click(BTNBuscarLondres);
    }

    public void FiltrosLondres(){

        click(BTNFiltroEstrellasLon);
        click(BTNTresEstrellasLon);
        click(BTNAplicarTresEstrellas);
        click(BTNFiltroValoracionLon);
        click(BTNMuyBuenoLon);
        click(BTNAplicarValLon);
        click(BTNHotelEconomicoLon);

    }


    public void ItaliaBusq(){
        click(BarraItaliaForm);
    }

    public void ItaliaText() {
        writeWithElement("Roma, Italia", findElements(By.xpath("//input[@id='mui-1']")).get(0));
        click(BTNIT);
        click(FechasIt);
    }

    public void FechasIT(){
        click(FechaFinIt);
        click(FechaSieteIt);
        click(FormEneIT);
        click(FormFebIT);
        click(FormMarIT);
        click(BotonBuscarIt);
    }

    public void FiltrosItalia(){
        click(FiltroTresIt);
        click(CuatroEstrellasIT);
        click(AplicarEstrellasIT);
        click(WifiGratisIT);
        click(CanceIT);
        click(FiltroValIt);
        click(ValIT);
        click(AplyValIt);
        click(HotelItalia);
    //    click(ElegirHabIT);
       // click(ElegirHabitBIt);
    }
  /*  public void HabitacionIt(){
        click(HotelItalia);
        click(HabitacionIt);
    }
   */

    public void ParisText() {
        writeWithElement("Paris", findElements(By.xpath("//input[@id='mui-1']")).get(0));
        click(BTNParis);
        click(FechPar);
    }
    public void ParisForm(){
        click(FechEntradaPar);
        click(FechaSalidaPar);
        click(BuscarEnParis);
    }
    public void filtrosParis(){
        click(AbrirFiltrosPar);
        click(PrecioFil);
        click(ValPar);
        click(ValMuyBuenoPar);
        click(AplyValPar);
        click(EstrellasFilPar);
        click(TresEstrellasPar);
        click(AplyTresPar);
        click(WifiGratisPar);
        click(CancelacionPar);
       click(HotelBaratoParis);
    }
/*
    public void HotelParis(){
        click(HabParis);
    }
*/




}