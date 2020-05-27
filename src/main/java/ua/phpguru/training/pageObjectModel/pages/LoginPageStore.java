package ua.phpguru.training.pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ua.phpguru.training.automationScenaries.User;

public class LoginPageStore {

    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwdField;

    @FindBy(css = ".icon-lock.left")
    private WebElement bSignIn;

    public LoginPageStore(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void userSignIn(User user) {
        emailField.sendKeys(user.getEmail());
        passwdField.sendKeys(user.getPasswd());
        bSignIn.click();
    }

    public MainPageStore logInUserSuccess(User user) {
        userSignIn(user);
        return new MainPageStore(driver);
    }




}
