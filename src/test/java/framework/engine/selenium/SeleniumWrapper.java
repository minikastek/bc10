package framework.engine.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import java.util.NoSuchElementException;


public class SeleniumWrapper {

    private final WebDriver driver;

    //Constructor Base
    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
    }

    //Wrappers Selenium
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    public void write(String inputText, By locator){
        isDisplayed(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }
    public void writeWithElement(String inputText, WebElement e){
        e.clear();
        e.sendKeys(inputText);
    }
    public void clickElementonTheMiddle(By locator){
        WebElement clickable = driver.findElement(locator);
        new Actions(driver)
                .moveToElement(clickable)
                .click(clickable)
                .perform();
    }
    public void sendKeys(Keys key, By locator){
        driver.findElement(locator).sendKeys(key);
    }

    public boolean click(By locator){
        driver.findElement(locator).click();
        return false;
    }

    //agregue este metodo
    public void clickOnElement(WebElement e){
        e.click();
    }

    public void esperaImplicita(int time, By locator){
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(time))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntil(By locator, int seconds){
        WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(driver -> driver.findElement(locator));
    }


    public void moveTo(By locator){
        WebElement localizador = driver.findElement(locator);
        new Actions(driver).moveToElement(localizador).perform();
    }


    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public Boolean isEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public Boolean validateMessage(String text, By locator){
        try{
            return driver.findElement(locator).getText().equals(text);
        } catch (org.openqa.selenium.NoAlertPresentException e){
            return false;
        }
    }
    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public String getUrlTitle(){
        return driver.getTitle();
    }


    public void handleTab() throws InterruptedException {
        Thread.sleep(500);
        String mainTab = driver.getWindowHandle();
        String nweTab = "";
        Set<String> handles = driver.getWindowHandles();

        for(String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                nweTab = actual;
            }
        }
    }

    public void cambioFrame(String id){
        driver.switchTo().frame(id);
    }

    public void limpiarInput(By locator){
        driver.findElement(locator).clear();
    }

    public void submit(By locator){
        driver.findElement(locator).submit();
    }

    public Integer cortarDescuento(String descuento){
        String subDescuento = "";
        if (descuento.length() == 4){
            subDescuento = descuento.substring(1,3);
        }else if (descuento.length() == 3){
            subDescuento = descuento.substring(1,2);
        } else if (descuento.length() == 6){
            subDescuento = descuento.substring(0,4);
        }else if(descuento.length() == 5){
            subDescuento = descuento.substring(0,3);
        }
        return Integer.parseInt(subDescuento);

    }

    public Integer numeroMayor(List<Integer> numeros){

        Integer numeroMayor = numeros.stream().max(Integer::compare).get();
        return numeroMayor;
    }

}
