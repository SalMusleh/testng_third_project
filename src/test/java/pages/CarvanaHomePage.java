package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper']")
    public WebElement carvanaLogo;

    @FindBy(css = "div[data-cv-test='headerWrapper']>div:nth-child(2)>div>a")
    public List<WebElement> mainNavItems;

    @FindBy(css = "a[data-cv-test='headerSignInLink']")
    public WebElement signInButtonHomePage;

    @FindBy(id = "ae-signin-modal-label")
    public WebElement signInModalHeader;

    @FindBy(id = "usernameField")
    public WebElement emailInputBox;

    @FindBy(id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement signInButtonWithInputsFilled;

    @FindBy(css = "div[data-qa='error-message-container']")
    public WebElement errorMessageFromSignIn;

    @FindBy(xpath= "//div[@data-qa='header-items']//a[1]")
    public WebElement searchCarsButton;

}