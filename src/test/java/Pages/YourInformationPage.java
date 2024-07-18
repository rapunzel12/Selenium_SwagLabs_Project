package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourInformationPage {
    WebDriver driver;
    WebElement pageTitle;
    WebElement firstnameField;
    WebElement lastnameField;
    WebElement zipField;
    WebElement continueButton;
    WebElement cancelButton;
    WebElement errorMsg;

    public YourInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageTitle() {
        return driver.findElement(By.className("header_secondary_container"));
    }

    public WebElement getFirstnameField() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastnameField() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getZipField() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.name("continue"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.id("cancel"));
    }

    public WebElement getErrorMsg() {
        return driver.findElement(By.className("error-button"));
    }

    // ------------------------ akcije nad lokatorima -------------------------------

    public void firstnameInputData(String name){
        getFirstnameField().clear();
        getFirstnameField().sendKeys(name);
    }

    public void lastnameInputData(String lastname){
        getLastnameField().clear();
        getLastnameField().sendKeys(lastname);
    }

    public void zipInputField(String zip){
        getZipField().clear();
        getZipField().sendKeys(zip);
    }

    public void clickOnContinueButton(){
        getContinueButton().click();
    }

    public void clickOnCancelButton(){
        getCancelButton().click();
    }






















}
