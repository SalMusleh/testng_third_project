package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaMercedesSearchPage {
    public CarvanaMercedesSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class='tk-frame top-frame']>picture")
    public List<WebElement> imageForEachTile;

    @FindBy(css = "div[data-test='BaseFavoriteVehicle']>svg")
    public List<WebElement> addFavButtonForEachTile;

    @FindBy(css = "div[data-qa='base-inventory-type']")
    public List<WebElement> inventoryTypesForEachTile;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModelForEachTile;

    @FindBy(css = "div[data-qa='trim-mileage']")
    public List<WebElement> trimMileageForEachTile;

    @FindBy(css = "div[class='price ']")
    public List<WebElement> priceForEachTile;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public List<WebElement> monthlyPaymentForEachTile;

    @FindBy(css = "div[class='down-payment']")
    public List<WebElement> downPaymentForEachTile;

    @FindBy(css = "div[data-qa='no-shipping-cost-delivery-chip']")
    public List<WebElement> deliveryChipForEachTile;

}
