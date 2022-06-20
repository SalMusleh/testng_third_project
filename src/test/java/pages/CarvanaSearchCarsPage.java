package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaSearchCarsPage {
    public CarvanaSearchCarsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-qa='menu-flex']>button")
    public List<WebElement> searchCarsFilterOptions;

    @FindBy(css = "div[id='search-bar-container-wrapper']")
    public WebElement usedCarsSearchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

}
