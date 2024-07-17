package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingleProductTest extends BaseTest {

    @BeforeMethod
    public void userIsLoggedIn(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        // metoda logovanje usera is BaseTest-a
        loginUser();
    }

    // dodavanje 1 proizvoda u korpu
    @Test
    public void addSingleProductToCart(){
        homePage.clickOnProductName(5); // dodajem 5. element iz liste proizvoda koji je na poziciji 4 [0,1,2,3,4]
        Assert.assertTrue(singleProductPage.getSingleProduct().isDisplayed());

        singleProductPage.clickOnAddToCartButtonSingleProductsPage();

        Assert.assertTrue(singleProductPage.getRemoveButtonOnSingleProductPage().isDisplayed());
    }

    // uklanjanje 1 proizvoda iz korpe
    @Test
    public void removeSngleProductFroCart(){
        homePage.clickOnProductName(3); // dodajem 3. element iz liste proizvoda koji je na poziciji 2 [0,1,2]
        Assert.assertTrue(singleProductPage.getSingleProduct().isDisplayed());

        singleProductPage.clickOnAddToCartButtonSingleProductsPage();

        Assert.assertTrue(singleProductPage.getRemoveButtonOnSingleProductPage().isDisplayed());
        singleProductPage.clickOnRemoveButtonOnSIngleProductsPage();
        Assert.assertTrue(singleProductPage.getAddToCartButtonOnSingleProductPage().isDisplayed());
    }

    @AfterMethod
    public void resetCart(){
        resetAppState();
    }

}
