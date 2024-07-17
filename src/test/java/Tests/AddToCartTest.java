package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @BeforeMethod
    public void userIsLoggedIn(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginUser();
    }

    @Test
    public void addToCartManyProducts(){
        homePage.clickOnAddToCartButtons(3);
        Assert.assertFalse(yourCartPage.getShoppingCartIcon().getText().isEmpty());
    }
}
