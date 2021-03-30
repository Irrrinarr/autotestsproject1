package com.training.pageobjects.burgerMenu;

import com.training.pageobjects.helpers.Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Menu extends Basics {
    public Menu(WebDriver driver) {
        super(driver);
    }

    public void burgerMenu() {
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(By.cssSelector("#logout_sidebar_link"));
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        WebDriverWait driverWait = new WebDriverWait(driver, 5L);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout_sidebar_link")));
        logoutButton.click();


//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        WebElement logoutButton = driver.findElement(By.cssSelector("a#logout_sidebar_link"));
//        js.executeScript("arguments[0].click();", logoutButton);
    }


}