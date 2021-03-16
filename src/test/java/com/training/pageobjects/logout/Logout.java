package com.training.pageobjects.logout;

import com.training.pageobjects.SaucedemoParentClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Logout extends SaucedemoParentClass {

    public Logout submit(){
        WebElement menuOptions = driver.findElement(By.id("react-burger-menu-btn"));
        menuOptions.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement logoutButton = driver.findElement(By.cssSelector("a#logout_sidebar_link"));
        js.executeScript("arguments[0].click();", logoutButton);

        return this;
    }

}
