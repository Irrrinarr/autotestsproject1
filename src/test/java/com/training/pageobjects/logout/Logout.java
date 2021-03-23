package com.training.pageobjects.logout;

import com.training.pageobjects.helpers.Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout extends Basics {
    public Logout(WebDriver driver) {
        super(driver);
    }

    public void submit(){
        WebElement menuOptions = driver.findElement(By.id("react-burger-menu-btn"));
        menuOptions.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement logoutButton = driver.findElement(By.cssSelector("a#logout_sidebar_link"));
        js.executeScript("arguments[0].click();", logoutButton);
    }



}