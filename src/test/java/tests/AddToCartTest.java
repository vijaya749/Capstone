package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Cucumber");
        home.addFirstProductToCart();
        home.openCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.getCartItemCount() >= 1, "Cart should have at least 1 item");
        Assert.assertEquals(cart.getQuantityOfItem(0), "1", "Quantity should be 1");
    }
}
