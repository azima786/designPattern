package org.example.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractComponents {
WebElement sectionElement;
WebDriver driver;
    public AbstractComponents(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement=driver.findElement(sectionElement);
    }

    public WebElement findElement(By findElementBy){
         return sectionElement.findElement(findElementBy);
    }
    public List<WebElement> findElements(By findElementBy){
        return sectionElement.findElements(findElementBy);
    }

    public void waitForElementToDisappear(By FindBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));

    }

    public void waitForElementToAppear(By FindBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

    }

    public void waitForElementToBeClickable(By FindBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(FindBy));

    }
}
