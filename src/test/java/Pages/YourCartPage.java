package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YourCartPage {
    WebDriver driver;
    WebElement yourCartTitle;
    WebElement shoppingCartIcon;
    List<WebElement> productDescriptions;
    List<WebElement> removeButtons;
    WebElement continueShoppingCartButton;
    WebElement checkoutButton;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getYourCartTitle() {
        return driver.findElement(By.className("title"));
    }

    public WebElement getShoppingCartIcon() {
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public List<WebElement> getProductDescriptions() {
        return driver.findElements(By.className("inventory_item_desc"));
    }

    public List<WebElement> getRemoveButtons() {
        return driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart)button"));
    }

    public WebElement getContinueShoppingCartButton() {
        return driver.findElement(By.name("continue-shopping"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.name("checkout"));
    }

    // -------------------------- akcije nad lokatorima -------------------------------------------

    public void clickOnShoppingCartIcon(){
        getShoppingCartIcon().click();
    }

    public void clickOnProductsDescription(int a){
        for (int i=a; i<getProductDescriptions().size(); i++){
            getProductDescriptions().get(i).isDisplayed();
        }
    }

    public void clickORemoveButton(int numOfProduct){
        for (int i = numOfProduct; i<getRemoveButtons().size(); i++){
            getRemoveButtons().get(i).click();
        }
    }

    public void clickOnContinueShoppingButton(){
        getContinueShoppingCartButton().click();
    }

    public void cicONCheckoutButton(){
        getCheckoutButton().click();
    }

}
