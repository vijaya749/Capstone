package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utils.ConfigReader;

public class NavigationTest extends BaseTest {

    @Test
    public void navigationValidationTest() {
        String baseUrl = ConfigReader.get("baseUrl");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl, "Should start at base URL");

        HomePage home = new HomePage(driver);
        home.searchProduct("Cucumber");
        home.addFirstProductToCart();
        home.openCart();

        String cartUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(cartUrl, baseUrl, "Cart URL should differ from base URL");

        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl, "Back navigation should return to base URL");

        driver.navigate().forward();
        Assert.assertEquals(driver.getCurrentUrl(), cartUrl, "Forward navigation should return to cart URL");

        driver.navigate().refresh();
        Assert.assertEquals(driver.getCurrentUrl(), cartUrl, "URL should remain same after refresh");

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.getCartItemCount() >= 1, "Cart items should persist after refresh");
    }
}
