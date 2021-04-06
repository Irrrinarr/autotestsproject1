package tests;

import com.training.pageobjects.helpers.TestBase;
import com.training.pageobjects.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void LoginWrongPsswrdTest() {
        LoginPage login = new LoginPage(driver);
        login.login("somename", "somepassword");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertNotEquals(actualURL, expectedURL);
    }
}
