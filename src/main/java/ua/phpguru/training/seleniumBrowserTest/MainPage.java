package ua.phpguru.training.seleniumBrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public MainPage(WebDriver driver){
        webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver,30,500);

        PageFactory.initElements(webDriver,this);
    }
}
