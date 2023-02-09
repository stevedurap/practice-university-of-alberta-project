package uoa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uoa.utilities.Driver;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "navSearchButton")
    public WebElement searchAndMoreSign;

    @FindBy (xpath = "//a[.='Find a Person']")
    public WebElement FindAPersonButton;

    @FindBy (id = "searchbox")
    public WebElement searchBox;

    @FindBy (xpath = "(//button[@type='submit'])[2]")
    public WebElement SearchButton;


    @FindBy (xpath = "//h2[@class='mb-2']")
    public WebElement fullName;

}
