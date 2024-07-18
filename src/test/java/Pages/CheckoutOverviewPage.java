package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    WebDriver driver;
    WebElement itemTotal;
    WebElement tax;
    WebElement total;
    WebElement cancelButton;
    WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getItemTotal() {
        return driver.findElement(By.className("summary_subtotal_label"));
    }

    public WebElement getTax() {
        return driver.findElement(By.className("summary_tax_label"));
    }

    public WebElement getTotal() {
        return driver.findElement(By.className("summary_total_label"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.id("cancel"));
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.name("finish"));
    }

    // ------------------------------- akcije nad lokatorima -------------------------------
    public void clickOnCancelButton(){
        getCancelButton().click();
    }

    public void clikOnFinishButton(){
        getFinishButton().click();
    }

}
