package framework.engine.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
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

    public void click(By locator){
        driver.findElement(locator).click();
    }

    //agregue este metodo
    public void clickOnElement(WebElement e){
        e.click();
    }

    public void esperaImplicita(int time, By locator){
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
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



}
