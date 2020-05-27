package ua.phpguru.training.automationScenaries;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.phpguru.training.seleniumBrowserTest.Site;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ScenariesTest {
    WebDriver webDriver;
    Site website;
    User user;

    public void authorizeUser(){
        webDriver.findElement(By.name("email")).sendKeys(user.getEmail());
        webDriver.findElement(By.id("passwd")).sendKeys(user.getPasswd());
        webDriver.findElement(By.cssSelector(".icon-lock.left")).click();
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "E:/Chrome_Downloads/chromedriver_win32_83/chromedriver.exe");

        webDriver = new ChromeDriver();
        website = new Site(webDriver);
        user = new User();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://automationpractice.com");

    }

    @Test
    public void userSignInTest(){
        String actualTShirtTitle;
        String actualUsername;

        webDriver.findElement(By.className("login")).click();
        actualTShirtTitle = webDriver.getTitle();
        Assert.assertEquals(user.getGuestTitle(),actualTShirtTitle);

        authorizeUser();

        actualTShirtTitle=webDriver.getTitle();
        Assert.assertEquals(user.getAuthorizedTitle(),actualTShirtTitle);

        actualUsername = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
        Assert.assertEquals(user.getAuthorizedUsername(),actualUsername);
    }

    @Test
    public void emptyEmailAndPasswordFieldsTest(){
        String expectedEmailErrorMessage = "An email address required.";
        String expectedPasswordErrorMessage = "Password is required.";
        String actualEmailErrorMessage;
        String actualPasswordErrorMessage;

        //Checking empty email message alert
        webDriver.findElement(By.className("login")).click();
        webDriver.findElement(By.id("passwd")).sendKeys(user.getPasswd());
        webDriver.findElement(By.cssSelector(".icon-lock.left")).click();

        actualEmailErrorMessage = webDriver
                .findElement(By.cssSelector(".alert.alert-danger"))
                .findElement(By.tagName("ol"))
                .findElement(By.tagName("li"))
                .getText();
        Assert.assertEquals(expectedEmailErrorMessage,actualEmailErrorMessage);

        //Checking empty password message alert
        webDriver.findElement(By.id("passwd")).clear();
        webDriver.findElement(By.name("email")).sendKeys(user.getEmail());
        webDriver.findElement(By.cssSelector(".icon-lock.left")).click();

        actualPasswordErrorMessage = webDriver
                .findElement(By.cssSelector(".alert.alert-danger"))
                .findElement(By.tagName("ol"))
                .findElement(By.tagName("li"))
                .getText();
        Assert.assertEquals(expectedPasswordErrorMessage,actualPasswordErrorMessage);
    }

    @Test
    public void BuyTshirtAndCheckingPriceTest(){
        Double expectedPrice = 16.51;
        Double expectedPriceTwice = 33.02;
        Double actualPrice;
        Double actualPriceTwice;

        webDriver.findElement(By.className("login")).click();
        authorizeUser();

        webDriver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")).click();
        webDriver.findElement(By.id("add_to_cart")).click();
        webDriver.findElement(By.className("cross")).click();
        webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        actualPrice = Double.valueOf(webDriver
                .findElement(By.id("total_product_price_1_1_324842"))
                .getText()
                .substring(1));

        Assert.assertEquals(expectedPrice,actualPrice);

        webDriver.findElement(By.className("icon-plus")).click();
        actualPriceTwice = actualPrice * 2;
        Assert.assertEquals(expectedPriceTwice,actualPriceTwice);
    }

    @Test
    public void checkDiscountTest(){
        String expectedTShirtTitle = "Printed Chiffon Dress";
        Integer expectedDiscount = 20;
        Integer actualDiscount;
        String actualTShirtTitle;
        webDriver.findElement(By.className("login")).click();
        authorizeUser();

        webDriver.findElement(By.id("search_query_top")).sendKeys("Printed Chiffon Dress");
        webDriver.findElement(By.name("submit_search")).click();

        actualTShirtTitle = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText();
        Assert.assertEquals(expectedTShirtTitle,actualTShirtTitle);

        actualDiscount = Integer.valueOf(webDriver
                .findElement(By.className("price-percent-reduction"))
                .getText()
                .substring(1,3));
        Assert.assertEquals(expectedDiscount,actualDiscount);

    }

    @After
    public void tearDown() throws Exception {
        if (webDriver != null){
            webDriver.quit();
        }
    }
}