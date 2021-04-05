package tests;


import com.training.pageobjects.helpers.Testing;
import com.training.pageobjects.login.LoginPage;
import com.training.pageobjects.burgerMenu.Menu;
import com.training.pageobjects.products.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoWebsitePositiveTest extends Testing {

    @Test
    public void saucedemoWebsiteTest() {
        LoginPage logging = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        Menu menuOptions = new Menu(driver);

        logging.sendCredentialsCheckingError();
        products.fillInBasket();
        menuOptions.burgerMenu();
        menuOptions.logout();

        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }
}
