package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginbuttonField;
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginbuttonField() {
        return driver.findElement(By.name("login-button"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector(".error-message-container.error"));
    }

    // ------------------- akcije nad lokatorima -------------------------------

    public void inputUsername(String username){
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void inputPassword(String password){
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnLoginButton(){
        getLoginbuttonField().click();
    }


}
