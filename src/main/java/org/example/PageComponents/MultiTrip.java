package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponents;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

public class MultiTrip extends AbstractComponents implements SearchFlightAvail {

    private By multiCityRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By okButton = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
private By submit = By.id("ctl00_mainContent_btn_FindFlights");
private By FromMulti = By.id("ctl00_mainContent_ddl_originStation2_CTXT");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(String origin, String destination) {
        makeStateReady(s->  selectOriginCity(origin));
        selectDestinationCity(destination);
        selectDestination2("BLR");

    }

    public void selectOriginCity(String origin){
       // waitForElementToAppear(from);
        waitForElementToBeClickable(from);
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestination2(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        //write all pre-req code before you perform any operation
        //Common pre-req code and then execute actual function
        //tear down method

        System.out.println("Multi-Trip");
        findElement(multiCityRadio).click();
        findElement(okButton).click();
        waitForElementToDisappear(okButton);
        consumer.accept(this);
        System.out.println(" I am done");

    }
}
