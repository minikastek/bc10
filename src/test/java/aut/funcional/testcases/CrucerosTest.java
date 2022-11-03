package aut.funcional.testcases;

import aut.funcional.pages.RumboCrucerosPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CrucerosTest extends SeleniumTestBase {
    RumboCrucerosPage rhp;

    By octubrePeriodo = By.xpath("(//span[normalize-space()='oct'])[1]");

    @Test
    void TCCLC001(){
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.navegarOfertas();
        rhp.seleccionarDestino("Caribe");
        rhp.seleccionarPeriodo();

        Boolean prueba = true;
        try{
            rhp.click(octubrePeriodo);
        }catch (Exception e){
            prueba = false;
        }
        Assertions.assertEquals(false, prueba);
    }
}

