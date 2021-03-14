package com.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

public class LoginTest {

    private WebDriver driver;
    private WebElement userNameField;
    private WebElement passwordForAllUsers;
    private WebElement loginButton;
    public String botLogo = "//div[@class='bot_column']";

    @BeforeMethod
    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin(){

        driver.get("https://www.saucedemo.com");

        userNameField = driver.findElement(By.id("user-name"));
        passwordForAllUsers = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));

        loginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));

//        while (!driver.findElement(By.xpath(botLogo)).isDisplayed())
//        checkErrorMessage(errorMessage.getText());
        while (!driver.getCurrentUrl().contains("inventory"))
            checkErrorMessage(errorMessage.getText());


        List<WebElement> azButtonsList = driver.findElements(By.cssSelector(".btn_inventory"));
        azButtonsList.get(1).click();

        WebElement sortContainer = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortContainer);
        select.selectByValue("za");

        List<WebElement> zaButtonsList = driver.findElements(By.cssSelector(".btn_inventory"));
        zaButtonsList.get(2).click();

        WebElement menuOptions = driver.findElement(By.id("react-burger-menu-btn"));
        menuOptions.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement logoutButton = driver.findElement(By.cssSelector("a#logout_sidebar_link"));
        js.executeScript("arguments[0].click();", logoutButton);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    private void checkErrorMessage(String errorMessage){
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
