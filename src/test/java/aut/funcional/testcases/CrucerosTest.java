package aut.funcional.testcases;

import aut.funcional.pages.RumboCrucerosPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CrucerosTest extends SeleniumTestBase {
    RumboCrucerosPage rhp;

    @Test
    void TCCLC001(){
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.navegarOfertas();
        rhp.seleccionarDestino("Caribe");
        rhp.espera();
        rhp.seleccionarPeriodo();
        Assertions.assertEquals(false, rhp.esSeleccionable());
    }
}

