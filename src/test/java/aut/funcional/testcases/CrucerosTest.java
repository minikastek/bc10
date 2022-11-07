package aut.funcional.testcases;

import aut.funcional.pages.Cruceros.CruceroDetalle;
import aut.funcional.pages.Cruceros.CruceroFormularioDetalle;
import aut.funcional.pages.Cruceros.RumboCrucerosPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrucerosTest extends SeleniumTestBase {
    RumboCrucerosPage rhp;
    CruceroDetalle rcd;
    CruceroFormularioDetalle cfd;

    @Test
    void TCCLC001() throws InterruptedException {
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.navegarOfertas();
        rhp.seleccionarDestino("Caribe");
        Thread.sleep(3000);
        rhp.seleccionarInputPeriodo();
        Assertions.assertEquals(false, rhp.esSeleccionable());
    }

    @Test
    void TCCLC002(){
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.navegarOfertas();
        rhp.buscar();
        Integer mayorDescuento = rhp.obtenerMayoDescuento();
        rhp.primerCrucero();
        rhp.handleTab();
        Integer descuentoDetalle = rhp.prueba();
        Assertions.assertEquals(descuentoDetalle, mayorDescuento);
    }

    @Test
    void TCCMC001() throws InterruptedException {
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rcd = new CruceroDetalle(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.seleccionarDestino("Caribe");
        Thread.sleep(2000);
        rhp.seleccionarInputPeriodo();
        rhp.seleccionarMesPeriodo();
        Thread.sleep(2000);
        rhp.seleccionarDuracion(2);
        Thread.sleep(2000);
        rhp.seleccionarPuertoMiami();
        Thread.sleep(2000);
        rhp.clickPrueba();
        Thread.sleep(2000);
        rhp.seleccionarEnero2023();
        Thread.sleep(2000);
        rhp.selTresAdultos2NinosPasajeros();
        Thread.sleep(2000);
        rhp.buscar();
        rhp.primerCrucero();
        rhp.handleTab();
        Integer primerValor = rcd.valorCrucero();
        rcd.cambiarCamarote();
        rcd.solocitarPresupuesto();
        Integer segundoValor = rcd.valorCrucero();
        Assertions.assertTrue(rcd.primeroEsMayor(primerValor, segundoValor));
    }


    @Test
    void TCCMC002() throws InterruptedException {
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.seleccionarDestino("Mediterráneo");
        Thread.sleep(3000);
        rhp.seleccionarEnero20232();
        Thread.sleep(3000);
        rhp.seleccionarDuracion(2);
        Thread.sleep(3000);
        rhp.companiaCostaCrucero();
        Thread.sleep(3000);
        rhp.seleccionarPuertoBarcelona();
        Thread.sleep(3000);
        rhp.seleccionarUnPasajero();
        Thread.sleep(3000);
        rhp.reiniciarBusqueda();
        Thread.sleep(3000);
        List<String> valoresForm = rhp.obtenerValoresForm();
        List<String> valoresEsperados = rhp.valoresEsperadosForm();
        Assertions.assertEquals(valoresEsperados, valoresForm);

    }

    @Test
    void TCCHC001() throws InterruptedException {
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rcd = new CruceroDetalle(DriverFactory.getDriver());
        cfd = new CruceroFormularioDetalle(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.buscar();
        rhp.primerCrucero();
        rhp.handleTab();
        rcd.solocitarPresupuesto();
        Thread.sleep(2000);
        cfd.ingresarNombre("Nelson");
        cfd.ingresarApellido("Tapia");
        cfd.ingresarEmail("ntapiapinto@gmail.com");
        cfd.ingresarComentario("Comentario de prueba");
        cfd.checkConsentimiento();
        Thread.sleep(5000);
        cfd.clickOpcionDos();
        cfd.seleccionarTransferencia();
        String prueba = cfd.obtenerMensajeTransferencia();
        Assertions.assertEquals( "Transferencia Bancaria con un depósito de 227 €", prueba);

    }

    @Test
    void TCCHC002() throws InterruptedException {
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rcd = new CruceroDetalle(DriverFactory.getDriver());
        cfd = new CruceroFormularioDetalle(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.navegarOfertas();
        Thread.sleep(1000);
        rhp.seleccionarDiciembre();
        Thread.sleep(1000);
        rhp.seleccionarUnPasajero();
        Thread.sleep(1000);
        rhp.companiaMSCCruceros();
        rhp.buscar();
        Thread.sleep(1000);
        rhp.sortRating();
        Thread.sleep(1000);
        rhp.primerCrucero();
        Thread.sleep(1000);
        rhp.handleTab();
        Thread.sleep(1000);
        rcd.cambiarFebrero2023();
        Thread.sleep(1000);
        rcd.ultimafecha();
        Thread.sleep(1000);
        rcd.primerCamarote();
        Thread.sleep(1000);
        rcd.solocitarPresupuesto();
        Thread.sleep(1000);
        Integer primerValor = cfd.obtenerValorDetalle();
        Thread.sleep(1000);
        cfd.seleccionarRumboVip();
        Thread.sleep(1000);
        Integer segundoValor = cfd.obtenerValorDetalle();
        Thread.sleep(1000);
        Assertions.assertTrue(cfd.evaluarMayor(primerValor, segundoValor));

    }

}

