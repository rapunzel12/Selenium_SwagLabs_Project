package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;
    List<WebElement> products;
    List<WebElement> addToCartButtons;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAddToCartButtons() {
        return driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    }

    public List<WebElement> getProducts() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    // ---------------------------- akcije nad lokatorima ----------------------------------------

    public void clickOnProductName(int a){
        for (int i= (a-1); i< getProducts().size(); i--){
            getProducts().get(i).click();
        }
    }

    public void clickOnAddToCartButtons(int a){
        for (int i= (a-1); i>0; i--){
            getAddToCartButtons().get(i).click();
        }
    }







}
