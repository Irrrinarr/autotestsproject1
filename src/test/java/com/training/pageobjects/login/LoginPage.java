package com.training.pageobjects.login;

import com.training.pageobjects.SaucedemoParentClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends SaucedemoParentClass {
    public WebElement userNameField;
    public WebElement passwordForAllUsers;
    public WebElement loginButton;

    public LoginPage open() {
        driver.get("https://www.saucedemo.com");
        return this;
    }

    public LoginPage sendCredentials() {
        userNameField = driver.findElement(By.id("user-name"));
        passwordForAllUsers = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        return this;
    }
    public void checkErrorMessage(String errorMessage){
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


}
