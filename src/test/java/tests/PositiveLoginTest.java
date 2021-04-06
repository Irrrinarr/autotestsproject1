package tests;

import com.training.pageobjects.burgerMenu.MenuPage;
import com.training.pageobjects.helpers.TestBase;
import com.training.pageobjects.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    private String username;
    private String password;

    @Test
    public void positiveTest(){
        LoginPage loginPage = new LoginPage(driver);
        MenuPage menuPage = new MenuPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/inventory.html"));
        menuPage.burgerMenu();
        menuPage.logout();




    }

}
