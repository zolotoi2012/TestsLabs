package ua.phpguru.training.pageObjectModel.pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.phpguru.training.automationScenaries.User;
import ua.phpguru.training.seleniumBrowserTest.Site;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class PagesTest {

   private WebDriver webDriver;
   private User user;
   private MainPageStore mainPageStore;
   private LoginPageStore loginPageStore;
   private  WomenSectionStore womenSectionStore;
   private OrderPageStore orderPageStore;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "C:/Chrome_Downloads/chromedriver_win32_83/chromedriver.exe");

        webDriver = new ChromeDriver();
        user = new User();
        mainPageStore = new MainPageStore(webDriver);
        loginPageStore = new LoginPageStore(webDriver);
        womenSectionStore = new WomenSectionStore(webDriver);
        orderPageStore = new OrderPageStore(webDriver);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://automationpractice.com");
    }

    @Test
    public void logInAndCheckProductsTest(){

        mainPageStore.guestGetSignInPage();
        loginPageStore.logInUserSuccess(user);
        mainPageStore.getWomenSectionStore();

        Assert.assertTrue(womenSectionStore.checkItemsSize(7));
        Assert.assertTrue(womenSectionStore.checkYellowItemsCount(3));

        womenSectionStore.changeViewToList();
        Assert.assertTrue(womenSectionStore.checkItemDescription());
    }

    @Test
    public void logInAndTestSendingProductToFriendTest(){
        mainPageStore.guestGetSignInPage();
        loginPageStore.logInUserSuccess(user);
        mainPageStore.seachProduct("Faded Short Sleeve T-shirts");
        mainPageStore.openSeachedProduct();
    }

    @Test
    public void orderPageTest(){
        mainPageStore.guestGetSignInPage();
        loginPageStore.logInUserSuccess(user);
        mainPageStore.getWomenSectionStore();
        mainPageStore.seachProduct("Faded Short Sleeve T-shirts");
        mainPageStore.addSearchedProductToCard();
        mainPageStore.proceedToCheckout();
        Assert.assertEquals("Faded Short Sleeve T-shirts",orderPageStore.checkProductImage());
        Assert.assertTrue(orderPageStore.checkFooterEmailAndPhone());
    }

    @After
    public void tearDown() throws Exception {
        if (webDriver != null){
            webDriver.quit();
        }
    }
}