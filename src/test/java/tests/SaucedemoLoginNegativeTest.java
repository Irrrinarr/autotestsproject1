package tests;

import com.training.pageobjects.helpers.TestBase;
import com.training.pageobjects.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoLoginNegativeTest extends TestBase {

    @Test
    public void LoginWrongPsswrdTest() {
        LoginPage login = new LoginPage(driver);
        login.wrongLoginPassword();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
//      Assert.assertEquals(actualURL,expectedURL);
        Assert.assertNotEquals(actualURL, expectedURL);
    }
}
