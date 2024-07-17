package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    WebDriver driver;
    WebElement title;
    WebElement burgerButton;
    WebElement closeButton;
    WebElement allItemsLink;
    WebElement aboutLink;
    WebElement logoutLink;
    WebElement resetAppStateLink;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("title"));
    }

    public WebElement getBurgerButton() {
        return driver.findElement(By.className("bm-burger-button"));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }

    public WebElement getAllItemsLink() {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getAboutLink() {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getLogoutLink() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getResetAppStateLink() {
        return driver.findElement(By.id("reset_sidebar_link"));
    }

    // ---------------------- akcije nad lokatorima -------------------

    public void clickOnBurgerButton(){
        getBurgerButton().click();
    }

    public void clickOnCloseButton(){
        getCloseButton().click();
    }

    public void clickOnAllItemsLink(){
        getAllItemsLink().click();
    }

    public void clickOnAboutLink(){
        getAboutLink().click();
    }

    public void clickOnLogoutLink(){
        getLogoutLink().click();
    }

    public void clickOnResetAppStateLink(){
        getResetAppStateLink().click();
    }
}
