package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public HomePage homePage;
    public SingleProductPage singleProductPage;
    public YourCartPage yourCartPage;
    public YourInformationPage yourInformationPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public CheckoutCompletePage checkoutCompletePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        homePage = new HomePage(driver);
        singleProductPage = new SingleProductPage(driver);
        yourCartPage = new YourCartPage(driver);
        yourInformationPage = new YourInformationPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    // pomocna metoda za login, nije testna metoda
    public void loginUser(){
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    // pomocna metoda za resetvanje korisnicke korpe
    public void resetAppState(){
        productsPage.clickOnBurgerButton();
        productsPage.clickOnResetAppStateLink();
    }

    // pomocna metoda za dodavanje product-a u cart
    public void addToCartHelpMethod(){
        homePage.clickOnAddToCartButtons(3);
    }

    // pomocna metoda za skracivanje koraka u procesu testiranja karta vezano za kliktanje na sam kart
    public void cartIconHelpMethod(){
        yourCartPage.clickOnShoppingCartIcon();
        yourCartPage.clickOnCheckoutButton();
    }

    // poocna metoda za licne podatke koje korisnik unosi priliko porucivanja
    public void personalData(){
        yourInformationPage.firstnameInputData("Pera");
        yourInformationPage.lastnameInputData("Peric");
        yourInformationPage.zipInputField("1234568");
    }
}
