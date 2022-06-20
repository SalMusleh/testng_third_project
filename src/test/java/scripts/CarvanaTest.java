package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base{

    @Test(priority = 1, description = "Test Case 1: Validate Carvana home page title and url")
    public void testTitleAndURL(){
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
    }

    @Test(priority = 2, description = "Test Case 2: Validate the Carvana logo")
    public void testLogoDisplayed(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Test Case 3: Validate the main navigation section items")
    public void testMainNavItems(){
        driver.get("https://www.carvana.com/");
        String[] expectedResults = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        Waiter.pause(5);
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(carvanaHomePage.mainNavItems.get(i).getText(), expectedResults[i]);
        }
    }

    @Test(priority = 4, description = "Test Case 4: Validate the sign in error message")
    public void testSignInErrorMessage(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.signInButtonHomePage.click();
        Assert.assertTrue(carvanaHomePage.signInModalHeader.isDisplayed());
        carvanaHomePage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.signInButtonWithInputsFilled.click();
        Waiter.pause(2);
        Assert.assertEquals(carvanaHomePage.errorMessageFromSignIn.getText(), "Email address and/or password combination is incorrect\nPlease try again or reset your password.");
    }

    @Test(priority = 5, description = "Test Case 5: Validate the search filter options and search button")
    public void testSearchCarsFilterOptions(){
        driver.get("https://www.carvana.com/");
        Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.searchCarsButton, 15);
        actions.click(carvanaHomePage.searchCarsButton).perform();
        Waiter.pause(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        String[] expectedResults = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i <= 5; i++){
            Assert.assertEquals(carvanaSearchCarsPage.searchCarsFilterOptions.get(i).getText(), expectedResults[i]);
        }
    }

    @Test(priority = 6, description = "Test Case  6: Validate the search result tiles")
    public void testSearchResultTiles(){
        driver.get("https://www.carvana.com/");
        Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.searchCarsButton, 15);
        actions.click(carvanaHomePage.searchCarsButton).perform();
        Waiter.pause(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        actions.sendKeys(carvanaSearchCarsPage.usedCarsSearchInputBox, "mercedes-benz").perform();
        actions.click(carvanaSearchCarsPage.goButton).perform();
        Waiter.pause(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        for (WebElement element : carvanaMercedesSearchPage.imageForEachTile){
            Assert.assertTrue(element.isDisplayed());
        }
        for (WebElement element : carvanaMercedesSearchPage.addFavButtonForEachTile){
            Assert.assertTrue(element.isDisplayed());
        }
        for (WebElement element : carvanaMercedesSearchPage.inventoryTypesForEachTile){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText() != null);
        }
        for (WebElement element : carvanaMercedesSearchPage.yearMakeModelForEachTile){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText() != null);
        }
        for (WebElement element : carvanaMercedesSearchPage.trimMileageForEachTile){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText() != null);
        }
        for (WebElement element : carvanaMercedesSearchPage.priceForEachTile){
            Assert.assertTrue(Integer.parseInt(element.getText().replaceAll("[^0-9]", "")) > 0);
        }
        for (WebElement element : carvanaMercedesSearchPage.monthlyPaymentForEachTile){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText() != null);
        }
        for (WebElement element : carvanaMercedesSearchPage.downPaymentForEachTile){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText() != null);
        }
        for (WebElement element : carvanaMercedesSearchPage.deliveryChipForEachTile){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText() != null);
        }

    }





}
