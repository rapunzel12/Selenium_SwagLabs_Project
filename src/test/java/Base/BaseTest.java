package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.SingleProductPage;
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

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        homePage = new HomePage(driver);
        singleProductPage = new SingleProductPage(driver);
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


}
