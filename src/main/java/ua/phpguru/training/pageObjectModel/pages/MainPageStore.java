package ua.phpguru.training.pageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageStore {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement bProceedToCheckout;

    @FindBy(css = ".button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement bAddToCart;

    @FindBy(css = ".button.lnk_view.btn.btn-default")
    private WebElement searchedProduct;

    @FindBy(id = "search_query_top")
    private WebElement searchRow;

    @FindBy(name = "submit_search")
    private WebElement bSearch;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement bWomenSection;

    @FindBy(className = "login")
    private WebElement bSignIn;

    public MainPageStore(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void guestGetSignInPage(){
        bSignIn.click();
    }

    public WomenSectionStore getWomenSectionStore() {
        bWomenSection.click();
        return new WomenSectionStore(driver);
    }

    public void seachProduct(String name){
        searchRow.sendKeys(name);
        bSearch.click();
    }

    public void openSeachedProduct(){
        searchedProduct.click();
    }

    public void addSearchedProductToCard(){
        bAddToCart.click();
    }

    public OrderPageStore proceedToCheckout(){
        bProceedToCheckout.click();
        return new OrderPageStore(driver);
    }
}


