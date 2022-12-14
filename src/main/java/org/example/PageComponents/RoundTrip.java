package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponents;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoundTrip extends AbstractComponents implements SearchFlightAvail {

private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
private By cb = By.id("ctl00_mainContent_chk_IndArm");
private By search = By.id("ctl00_mainContent_btn_FindFlights");
private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvail(String origin, String destination) {
        System.out.println("This is RoundTrip");
       findElement(rdo).click();
        System.out.println("Clicked on Radio");
      findElement(from).click();
        System.out.println("Clicked on from");
      selectOriginCity(origin);
      selectDestinationCity(destination);
       findElement(cb).click();
        System.out.println("Clicked on cb");
       findElement(search).click();
        System.out.println("Clicked on search");
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
