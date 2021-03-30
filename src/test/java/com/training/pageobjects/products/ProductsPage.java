package com.training.pageobjects.products;

import com.training.pageobjects.helpers.Basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends Basics {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage fillInBasket() {

        List<WebElement> azButtonsList = driver.findElements(By.cssSelector(".btn_inventory"));
        azButtonsList.get(1).click();
        WebElement sortContainer = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortContainer);
        select.selectByValue("za");
        List<WebElement> zaButtonsList = driver.findElements(By.cssSelector(".btn_inventory"));
        zaButtonsList.get(2).click();

        return this;
    }
}


