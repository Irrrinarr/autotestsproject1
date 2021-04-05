package com.training.pageobjects.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PagesBase {
    protected WebDriver driver;

    protected PagesBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
