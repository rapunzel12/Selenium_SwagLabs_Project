package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void userIsLoggedIn(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginUser();
    }

    @Test
    public void hamburgerMenu(){
        productsPage.clickOnBurgerButton();
        Assert.assertTrue(productsPage.getAboutLink().isDisplayed());
        productsPage.getCloseButton();
        Assert.assertTrue(productsPage.getTitle().isDisplayed());
    }

    @Test
    public void hamburgerMenuAboutSection(){
        productsPage.clickOnBurgerButton();
        productsPage.clickOnAboutLink();
        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        // Define the expected URL
        String expectedUrl = "https://saucelabs.com/";

        // Assert that the current URL matches the expected URL
        Assert.assertEquals(currentUrl, expectedUrl);
    }
}
