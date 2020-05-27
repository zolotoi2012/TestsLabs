package ua.phpguru.training.pageObjectModel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenSectionStore {

    private WebDriver driver;

    @FindBys( {
            @FindBy(xpath = "//*[@id=\"center_column\"]/ul"),
            @FindBy(className = "product-container")
    } )

    private List<WebElement> items;

    @FindBy(xpath = "//*[@id=\"ul_layered_id_attribute_group_3\"]/li[7]/label/a/span")
    private WebElement yellowItemsCount;

    @FindBy(className = "icon-th-list")
    private WebElement bchangeViewToList;

    @FindBy(className = "product-desc")
    private WebElement itemDesctiption;

    public WomenSectionStore(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean checkItemsSize(int count){
     return items.size() == count;
    }

    public boolean checkYellowItemsCount(int count){
      count = Integer.parseInt(yellowItemsCount.getText().substring(1,2));
      return count == 3;
    }

    public void changeViewToList(){
        bchangeViewToList.click();
    }

    public boolean checkItemDescription(){
        return !itemDesctiption.getText().isEmpty();
    }
}
