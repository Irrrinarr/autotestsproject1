package com.training.pageobjects.products;

import com.training.pageobjects.SaucedemoParentClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends SaucedemoParentClass {
    WebDriver driver = new ChromeDriver();

    public ProductsPage fillInBasket() {
        List<WebElement> azButtonsList = driver.findElements(By.cssSelector(".btn_inventory"));
        azButtonsList.get(1).click();

        WebElement sortContainer = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortContainer);
        select.selectByValue("za");

        List<WebElement> zaButtonsList = driver.findElements(By.cssSelector(".btn_inventory"));
        zaButtonsList.get(2).click();

        WebElement menuOptions = driver.findElement(By.id("react-burger-menu-btn"));
        menuOptions.click();

        return this;
    }
}

