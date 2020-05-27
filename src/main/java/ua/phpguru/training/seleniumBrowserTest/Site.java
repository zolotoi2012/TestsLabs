package ua.phpguru.training.seleniumBrowserTest;

import org.openqa.selenium.WebDriver;

public class Site {
    WebDriver webDriver;

    public Site(WebDriver driver){
        webDriver = driver;
    }

    public MainPage mainPage(){
        return new MainPage(webDriver);
    }
}
