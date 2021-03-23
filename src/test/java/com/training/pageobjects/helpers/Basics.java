package com.training.pageobjects.helpers;

import org.openqa.selenium.WebDriver;

public abstract class Basics {
    protected WebDriver driver;

    protected Basics(WebDriver driver){
        this.driver = driver;
    }
}
