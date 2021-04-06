package tests;


import com.training.pageobjects.helpers.TestBase;
import com.training.pageobjects.login.LoginPage;
import com.training.pageobjects.burgerMenu.MenuPage;
import com.training.pageobjects.products.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoWebsiteTest extends TestBase {

    @Test
    public void saucedemoWebsiteTest() {
        LoginPage logging = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        MenuPage menuOptions = new MenuPage(driver);

        logging.sendCredentialsCheckingError();
        products.fillInBasket();
        menuOptions.burgerMenu();
        menuOptions.logout();

        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }
}
