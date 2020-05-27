package ua.phpguru.training.seleniumBrowserTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageContentTest {

    WebDriver webDriver;
    Site website;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "E:/Chrome_Downloads/chromedriver_win32_83/chromedriver.exe");

        webDriver = new ChromeDriver();
        website = new Site(webDriver);
    }

    @Test
    public void openGooglePage(){
        webDriver.get("https://www.google.com/");
    }

    @Test
    public void getGooglePageTitle(){
        webDriver.get("https://www.google.com/");
        Assert.assertTrue(webDriver.getTitle().equals("Google"));
    }

    @Test
    public void getGooglePageMainElements() {
        webDriver.get("https://www.google.com/");

        webDriver.findElement(By.id("hplogo"));//logo
        webDriver.findElement(By.name("q"));//search row
        webDriver.findElement(By.className("gNO89b"));//search button
        webDriver.findElement(By.cssSelector(".gb_g"));//gmail link
    }

    @Test
    public void openWikipediaPage() {
        webDriver.get("https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BE%D0%B2%D0%BD%D0%B0_%D1%81%D1%82%D0%BE%D1%80%D1%96%D0%BD%D0%BA%D0%B0");

        webDriver.findElement(By.id("searchInput")).sendKeys("Київ");
        webDriver.findElement(By.id("searchButton")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/a/img"));
        System.out.println(webDriver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[15]/td")).getText());
        System.out.println(webDriver.findElement(By.xpath("//*[@id=\"collapsibleTable0\"]/tbody/tr[5]/th[5]")).getText());
        webDriver.findElement(By.id("Епідемія_коронавірусу"));
        System.out.println(webDriver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr[19]/td")).getText());
        Assert.assertTrue(webDriver.findElement(By.id("mw-content-text")).findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[11]")).findElements(By.tagName("li")).size() > 20);
    }

    @After
    public void tearDown() throws Exception {
        if (webDriver != null){
            webDriver.quit();
        }
    }
}