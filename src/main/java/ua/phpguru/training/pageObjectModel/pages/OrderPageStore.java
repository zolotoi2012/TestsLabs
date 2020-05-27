package ua.phpguru.training.pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPageStore {

    private WebDriver driver;

    public OrderPageStore(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"product_1_1_0_324842\"]/td[1]/a/img")
    private WebElement productImage;

    @FindBy(xpath = "//*[@id=\"block_contact_infos\"]/div/ul/li[2]/span")
    private WebElement footerPhone;

    @FindBy(xpath = "//*[@id=\"block_contact_infos\"]/div/ul/li[3]/span/a")
    private WebElement footerEmail;

    public String checkProductImage(){
        String alt = productImage.getAttribute("alt");
        return alt;
    }

    public boolean checkFooterEmailAndPhone(){
       String email = footerEmail.getText();
       String  phone = footerPhone.getText();

       return !email.isEmpty() && !phone.isEmpty();
    }
}
