package org.example.PageObjects;

import org.example.AbstractComponents.SearchFlightAvail;
import org.example.AbstractComponents.StrategyFactor;
import org.example.PageComponents.FooterNav;
import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlight;

    public TravelHomePage(WebDriver driver){
this.driver= driver;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver, footerNavSectionElement);
    }

    public FooterNav getFooterNav(){
        return new FooterNav(driver, sectionElement);

    }

    public void setBookingStrategy(String strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
       searchFlight= strategyFactor.createStrategy(strategyType);
        this.searchFlight=searchFlight;
    }

    public void checkAvail(String origin, String destination){

        searchFlight.checkAvail(origin, destination);
    }

}
