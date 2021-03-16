package tests;

import com.training.pageobjects.SaucedemoParentClass;
import com.training.pageobjects.login.LoginPage;
import com.training.pageobjects.logout.Logout;
import com.training.pageobjects.products.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSaucedemo {
    SaucedemoParentClass saucedemoPage = new SaucedemoParentClass();
    LoginPage login = new LoginPage();
    ProductsPage chooseItems = new ProductsPage();
    Logout loggingOut = new Logout();

    @BeforeMethod
    public void openBrowser(){
    saucedemoPage.openBrowser();
    }

    @Test
    public void testSaucedemo(){
        login
                .open()
                .sendCredentials();

        WebDriver driver = new ChromeDriver();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        while (!driver.getCurrentUrl().contains("inventory"))
            login.checkErrorMessage(errorMessage.getText());

        chooseItems.fillInBasket();

        loggingOut.submit();
    }
    @AfterMethod
    public void close(){
        saucedemoPage.closeBrowser();
    }

}
