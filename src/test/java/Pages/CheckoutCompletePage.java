package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage {
    WebDriver driver;
    WebElement sussessMsg;
    WebElement orderInfo;
    WebElement backToProductsButton;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSussessMsg() {
        return driver.findElement(By.className("complete-header"));
    }

    public WebElement getOrderInfo() {
        return driver.findElement(By.id("back-to-products"));
    }

    public WebElement getBackToProductsButton() {
        return driver.findElement(By.className("complete-text"));
    }

    // -------------------------- akcije nad lokatorima ---------------------------

    public void clickOnBackToProductsButton(){
        getBackToProductsButton().click();
    }
}
