package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingleProductPage {
    WebDriver driver;
    WebElement singleProduct;
    WebElement addToCartButtonOnSingleProductPage;
    WebElement removeButtonOnSingleProductPage;

    public SingleProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSingleProduct() {
        return driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
    }

    public WebElement getAddToCartButtonOnSingleProductPage() {
        return driver.findElement(By.name("add-to-cart"));
    }

    public WebElement getRemoveButtonOnSingleProductPage() {
        return driver.findElement(By.name("remove"));
    }

    // ----------------------- akcije nad lokatorima -----------------------
    public void clickOnAddToCartButtonSingleProductsPage(){
        getAddToCartButtonOnSingleProductPage().click();
    }

    public void clickOnRemoveButtonOnSIngleProductsPage(){
        getRemoveButtonOnSingleProductPage().click();
    }


}
