package org.example;

import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTest {

    @Test
    public void flightTest(){


        System.setProperty("webdriver.chrome.driver", "C://Users//azima.keshwani//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
     //   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        System.out.println("Flight Attribute for Footer: " + travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println("flight Attribute for Navigation Bar: " + travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println("Link count for footer: " + travelHomePage.getFooterNav().getLinkCount());
        System.out.println("Link count for Navigation Bar: " + travelHomePage.getNavigationBar().getLinkCount());

        //one-way, round-trip, multi-city - checkAvail
        //travelHomePage.setBookingStrategy(new MultiTrip());
        //travelHomePage.checkAvail("origin", "destination");
        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvail("MAA", "HYD");

    }
}
