package com.training.pageobjects.login;

import com.training.pageobjects.helpers.Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basics {
    @FindBy(id="user-name")
    public WebElement userNameField;
    @FindBy(id="password")
    public WebElement passwordForAllUsers;
    @FindBy(id="login-button")
    public WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void sendCredentialsCheckingError() {
        loginButton.click();

        while (!driver.getCurrentUrl().contains("inventory"))
            checkErrorMessage(errorMessage.getText());
    }
    private void checkErrorMessage(String errorMessage) {
        if (errorMessage.contains("Username is required"))
            userNameField.sendKeys("locked_out_user");

        else if (errorMessage.contains("Password is required"))
            passwordForAllUsers.sendKeys("secret_sauce");

        else if (errorMessage.contains("Sorry, this user has been locked out")) {
            userNameField.clear();
            userNameField.sendKeys("standard_user");
        }

        loginButton.click();
    }
    public void wrongLoginPassword() {
        userNameField.sendKeys("standard_user");
        passwordForAllUsers.sendKeys("password");
        loginButton.click();
    }
}

