package aut.funcional.testcases;

import aut.funcional.pages.hoteles.RumboHotelesPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelesTest extends SeleniumTestBase {
    RumboHotelesPage rumboHotelesPage;


    //THC-LC-001
    @Test
    public void funcionamientoBtnBuscar() {
        RumboHotelesPage RumboHotelesPage = new RumboHotelesPage(DriverFactory.getDriver());
        RumboHotelesPage.navegarAlHome();
        RumboHotelesPage.aceptarCoockies();
        RumboHotelesPage.navegarHoteles();
        RumboHotelesPage.llenarFormHoteles();
    }


    // THC-LC-002
    @Test
    public void mensajeErrorBuscar() {
        RumboHotelesPage RumboHotelesPage = new RumboHotelesPage(DriverFactory.getDriver());
        RumboHotelesPage.navegarAlHome();
        RumboHotelesPage.aceptarCoockies();
        RumboHotelesPage.navegarHoteles();
        RumboHotelesPage.FaltaInformacion();
        Assertions.assertEquals("Introduce, por ejemplo, una ciudad, una isla, una región...", RumboHotelesPage.msjErrorBusqueda());
    }

    @Test
    public void THCMC001() {
        RumboHotelesPage RumboHotelesPage = new RumboHotelesPage(DriverFactory.getDriver());
        RumboHotelesPage.navegarAlHome();
        RumboHotelesPage.aceptarCoockies();
        RumboHotelesPage.navegarHoteles();
        RumboHotelesPage.BarcelonaText();
        RumboHotelesPage.FormulariosBarcelona();

    }

    @Test
    public void THCMC002() {
        RumboHotelesPage RumboHotelesPage = new RumboHotelesPage(DriverFactory.getDriver());
        RumboHotelesPage.navegarAlHome();
        RumboHotelesPage.aceptarCoockies();
        RumboHotelesPage.navegarHoteles();
        RumboHotelesPage.LondresForm("Londres, Reino Unido");
        RumboHotelesPage.FormLondres();
        RumboHotelesPage.FiltrosLondres();

    }

    @Test
    public void THCHC001() {
        RumboHotelesPage RumboHotelesPage = new RumboHotelesPage(DriverFactory.getDriver());
        RumboHotelesPage.navegarAlHome();
        RumboHotelesPage.aceptarCoockies();
        RumboHotelesPage.navegarHoteles();
        RumboHotelesPage.ItaliaText();
        RumboHotelesPage.FechasIT();
        RumboHotelesPage.FiltrosItalia();

    }

    @Test
    public void THCHC002(){
        RumboHotelesPage RumboHotelesPage = new RumboHotelesPage(DriverFactory.getDriver());
        RumboHotelesPage.navegarAlHome();
        RumboHotelesPage.aceptarCoockies();
        RumboHotelesPage.navegarHoteles();
        RumboHotelesPage.ParisText();
        RumboHotelesPage.ParisForm();
        RumboHotelesPage.filtrosParis();
    }



}






