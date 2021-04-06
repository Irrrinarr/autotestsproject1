package com.training.pageobjects.burgerMenu;

import com.training.pageobjects.helpers.PagesBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MenuPage extends PagesBase {
    private final String LOGOUTBUTTON_ID = "logout_sidebar_link";
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = LOGOUTBUTTON_ID)
    private WebElement logoutButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }
    public void burgerMenu() {
        menuButton.click();
    }
    public void logout() {
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        WebDriverWait driverWait = new WebDriverWait(driver, 5L);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id(LOGOUTBUTTON_ID)));
        logoutButton.click();

    }
}