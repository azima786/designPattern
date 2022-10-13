package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponents{
    WebDriver driver;

    //When selenium executes any method in this class scope should be in footer only

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");
    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    public String getFlightAttribute(){
        //custom findElement
       return findElement(flights).getAttribute("class");
    }

    public int getLinkCount(){
        //custom findElement
        return findElements(links).size();
    }
}
