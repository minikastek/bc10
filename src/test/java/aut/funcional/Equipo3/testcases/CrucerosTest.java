package aut.funcional.Equipo3.testcases;

import aut.funcional.Equipo3.pages.cruceros.CruceroDetalle;
import aut.funcional.Equipo3.pages.cruceros.CruceroFormularioDetalle;
import aut.funcional.Equipo3.pages.cruceros.RumboCrucerosPage;
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
    void TCCLC002() throws InterruptedException {
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
        Thread.sleep(300);
        rhp.seleccionarInputPeriodo();
        rhp.seleccionarMesPeriodo();
        Thread.sleep(300);
        rhp.seleccionarDuracion(2);
        Thread.sleep(300);
        rhp.seleccionarPuertoMiami();
        Thread.sleep(300);
        rhp.seleccionarEnero2023();
        Thread.sleep(300);
        rhp.selTresAdultos2NinosPasajeros();
        Thread.sleep(300);
        rhp.buscar();
        rhp.primerCrucero();
        rhp.handleTab();
        Integer primerValor = rcd.valorCrucero();
        rcd.cambiarCamarote();
        Integer segundoValor = rcd.valorCrucero();
        rcd.solocitarPresupuesto();
        Assertions.assertTrue(rcd.primeroEsMayor(primerValor, segundoValor));
    }


    @Test
    void TCCMC002() throws InterruptedException {
        rhp = new RumboCrucerosPage(DriverFactory.getDriver());
        rhp.navegarHome();
        rhp.aceptarCoockies();
        rhp.navegarCruceros();
        rhp.seleccionarDestino("Mediterráneo");
        Thread.sleep(300);
        rhp.seleccionarEnero20232();
        Thread.sleep(300);
        rhp.seleccionarDuracion(2);
        Thread.sleep(300);
        rhp.companiaCostaCrucero();
        Thread.sleep(300);
        rhp.seleccionarPuertoBarcelona();
        Thread.sleep(300);
        rhp.seleccionarUnPasajero();
        Thread.sleep(300);
        rhp.reiniciarBusqueda();
        Thread.sleep(300);
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
        Thread.sleep(500);
        rcd.solocitarPresupuesto();
        Thread.sleep(500);
        cfd.ingresarNombre("Nelson");
        Thread.sleep(500);
        cfd.ingresarApellido("Tapia");
        Thread.sleep(500);
        cfd.ingresarEmail("ntapiapinto@gmail.com");
        Thread.sleep(500);
        cfd.ingresarComentario("Comentario de prueba");
        Thread.sleep(500);
        cfd.checkConsentimiento();
        Thread.sleep(1000);
        cfd.clickOpcionDos();
        Thread.sleep(2000);
        cfd.seleccionarTransferencia();
        Thread.sleep(300);
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
        rhp.seleccionarDiciembre();
        Thread.sleep(200);
        rhp.seleccionarUnPasajero();
        Thread.sleep(200);
        rhp.companiaMSCCruceros();
        Thread.sleep(500);
        rhp.buscar();
        Thread.sleep(500);
        rhp.sortRating();
        Thread.sleep(800);
        rhp.primerCrucero();
        Thread.sleep(800);
        rhp.handleTab();
        Thread.sleep(1000);
        rcd.cambiarFebrero2023();
        Thread.sleep(1000);
        rcd.ultimafecha();
        Thread.sleep(800);
        rcd.primerCamarote();
        Thread.sleep(800);
        rcd.solocitarPresupuesto();
        Thread.sleep(800);
        Integer primerValor = cfd.obtenerValorDetalle();
        Thread.sleep(800);
        cfd.seleccionarRumboVip();
        Thread.sleep(800);
        Integer segundoValor = cfd.obtenerValorDetalle();
        Thread.sleep(300);
        Assertions.assertTrue(cfd.evaluarMayor(primerValor, segundoValor));

    }

}

