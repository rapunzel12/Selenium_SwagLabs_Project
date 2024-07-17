package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void lockedOutUser(){
        loginPage.inputUsername("locked_out_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        // asertacija koja potvrdjuje da se pojavljuje poruka kako user ne moze da se uloguje
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }

    // logovanje sa validnim kredencijalima
    @Test
    public void userCanLogIn() throws InterruptedException {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        // asertacija koja potvrdjuje da je element sa naredne strane, da se user uspesno ulogovao
        // Thread.sleep(10); // ije potrebna ova linija koda
        Assert.assertTrue(productsPage.getTitle().isDisplayed());
    }

    // logout test
    @Test
    public void userCanLogout() throws InterruptedException {
        loginUser();
        productsPage.clickOnBurgerButton();
        Thread.sleep(10);
        productsPage.clickOnLogoutLink();
        Assert.assertTrue(loginPage.getLoginbuttonField().isDisplayed());
    }

}
