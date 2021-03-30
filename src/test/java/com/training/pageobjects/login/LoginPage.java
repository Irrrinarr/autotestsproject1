package com.training.pageobjects.login;

import com.training.pageobjects.helpers.Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Basics {
    public WebElement userNameField = driver.findElement(By.id("user-name"));
    public WebElement passwordForAllUsers = driver.findElement(By.id("password"));
    public WebElement loginButton = driver.findElement(By.id("login-button"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage sendCredentialsCheckingError() {
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));

        while (!driver.getCurrentUrl().contains("inventory"))
            checkErrorMessage(errorMessage.getText());

        return this;
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

    public LoginPage wrongLoginPassword() {
        userNameField.sendKeys("standard_user");
        passwordForAllUsers.sendKeys("password");
        loginButton.click();

        return this;
    }
}

