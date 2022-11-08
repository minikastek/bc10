package aut.funcional.Equipo3.pages.cruceros;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CruceroDetalle extends SeleniumWrapper {
    public CruceroDetalle(WebDriver driver) {
        super(driver);
    }
    //TCCHC001
    By btnSolicitarPresupuesto = By.xpath("//button[@class='crs-btn crs-btn--cta crs-btn--contain crs-btn--block ng-star-inserted']");

    public void solocitarPresupuesto() {
        esperaImplicita(3000, btnSolicitarPresupuesto);
        click(btnSolicitarPresupuesto);
    }

    //TCCHC002
    public void cambiarFebrero2023() throws InterruptedException {
        By dropPeriodo = By.xpath("//div[@class='p-dropdown-trigger']");
        esperaImplicita(2000, dropPeriodo);
        click(dropPeriodo);

        By siguienteAno = By.xpath("//button[@class='p-ripple p-element p-datepicker-next p-link ng-tns-c57-4']");
        esperaImplicita(5000, siguienteAno);
        click(siguienteAno);
        By febrero = By.xpath("//span[@class='p-ripple p-element p-monthpicker-month ng-tns-c57-4 ng-star-inserted'][normalize-space()='feb']");
        esperaImplicita(5000,febrero);
        click(febrero);
    }

    public void ultimafecha(){
        By ultimaFecha = By.xpath("(//div[@role='button'])[5]");
        esperaImplicita(2000, ultimaFecha);
        click(ultimaFecha);
    }

    public void primerCamarote(){
        By primerCamarote = By.xpath("/html/body/crs-app/crs-advanced-outlet/crs-pd-page/div/crs-page-base/div/main/crs-layout-two-cols/div/div[1]/div[1]/crs-page-section[2]/section/div/crs-pd-price-list/section/section[2]/article[1]/section/crs-cabin-list-carousel/div/div/div[1]/article/footer/crs-btn/button");
        esperaImplicita(2000, primerCamarote);
        click(primerCamarote);
    }

    //TCCMC001
    public void cambiarCamarote(){
        By menosAdulto = By.xpath("//div[@class='swiper-slide ng-star-inserted swiper-slide-next']//button[@class='crs-btn crs-btn--block crs-btn--cabin ng-star-inserted']");
        esperaImplicita(2000, menosAdulto);
        click(menosAdulto);

    }
    public Integer valorCrucero(){
        By valor = By.xpath("//div[@class='crs-full-price crs-full-price--default crs-full-price--small']//span[@class='crs-price__value']");
        esperaImplicita(2000, valor);
        String numero = getText(valor);
        Integer numeroInt = cortarDescuento(numero);
        return numeroInt;
    }

    public boolean primeroEsMayor(Integer primerValor, Integer segundoValor){
        if ( primerValor > segundoValor){
            return false;
        }else {
            return true;
        }
    }
}
