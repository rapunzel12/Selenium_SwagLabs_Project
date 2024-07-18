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

    // remove product
    @Test
    public void goToYourCartByClickingOnIcon(){
        // pomocna metoda da su proizvodi vec dodati
        addToCartHelpMethod();
        yourCartPage.clickOnShoppingCartIcon();
        Assert.assertFalse(yourCartPage.getShoppingCartIcon().getText().isEmpty());
        // dodavanje 3 proizvoda u korpu
        yourCartPage.clickOnProductsDescription(2);

        // uklanjanje jednog proizvoda
        yourCartPage.clickORemoveButton(2);

        // dohvatanje koliko ima proizvoda u korpi
        int numberOfProductsInCart = yourCartPage.getNumberOfProductsInCart();

        // Provera da li su sada 2 proizvoda u korpi
        Assert.assertEquals(numberOfProductsInCart, 2, "The cart should have 2 products after removing one.");
    }

    @Test
    public void continueShopping(){
        // pomocna metoda da su proizvodi vec dodati
        addToCartHelpMethod();
        yourCartPage.clickOnShoppingCartIcon();
        yourCartPage.clickOnContinueShoppingButton();
        // povratak na stranicu sa svim proizvodima
        Assert.assertTrue(productsPage.getTitle().isDisplayed());
    }

    @Test
    public void checkout(){
        addToCartHelpMethod();
        cartIconHelpMethod();
        Assert.assertTrue(yourInformationPage.getPageTitle().isDisplayed());
    }

    @Test
    public void inputValidData(){
        addToCartHelpMethod();
        cartIconHelpMethod();
        personalData();
        yourInformationPage.clickOnContinueButton();
        Assert.assertTrue(checkoutOverviewPage.getItemTotal().isDisplayed());
        Assert.assertTrue(checkoutOverviewPage.getTax().isDisplayed());
    }

    @Test
    public void inputInvalidData(){
        addToCartHelpMethod();
        cartIconHelpMethod();
        yourInformationPage.firstnameInputData("Pera");
        yourInformationPage.lastnameInputData("");
        yourInformationPage.zipInputField("");
        yourInformationPage.clickOnContinueButton();
        Assert.assertTrue(yourInformationPage.getErrorMsg().isDisplayed());
    }

    @Test
    public void cancelOrderOnYourInformationPage(){
        addToCartHelpMethod();
        cartIconHelpMethod();
        yourInformationPage.clickOnCancelButton();
        Assert.assertTrue(yourCartPage.getYourCartTitle().isDisplayed());
        Assert.assertTrue(yourCartPage.getCheckoutButton().isDisplayed());
    }

    @Test
    public void finishPurchase(){
        addToCartHelpMethod();
        cartIconHelpMethod();
        personalData();
        yourInformationPage.clickOnContinueButton();
        checkoutOverviewPage.clikOnFinishButton();
        Assert.assertTrue(checkoutCompletePage.getSussessMsg().isDisplayed());
        Assert.assertTrue(checkoutCompletePage.getOrderInfo().isDisplayed());
    }

    @Test
    public void afterSuccessfullPurchaseBackToProduct(){
        addToCartHelpMethod();
        cartIconHelpMethod();
        personalData();
        yourInformationPage.clickOnContinueButton();
        checkoutOverviewPage.clikOnFinishButton();
        checkoutCompletePage.clickOnBackToProductsButton();
        Assert.assertTrue(productsPage.getTitle().isDisplayed());
    }

    @Test
    public void cancelPurchase(){
        addToCartHelpMethod();
        cartIconHelpMethod();
        personalData();
        yourInformationPage.clickOnContinueButton();
        checkoutOverviewPage.clickOnCancelButton();
        Assert.assertTrue(productsPage.getTitle().isDisplayed());
    }

}
