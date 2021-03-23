package tests;


import com.training.pageobjects.helpers.Testing;
import com.training.pageobjects.login.LoginPage;
import com.training.pageobjects.logout.Logout;
import com.training.pageobjects.products.ProductsPage;
import org.testng.annotations.Test;

public class SausedemoWebsiteTest extends Testing {

    @Test
    public void saucedemoWebsiteTest(){
        LoginPage logging = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        Logout loggingOut = new Logout(driver);

        logging.sendCredentials();

        products.fillInBasket();

        loggingOut.submit();


    }
}
