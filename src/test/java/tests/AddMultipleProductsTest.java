package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class AddMultipleProductsTest extends BaseTest {

    @Test
    public void addMultipleProductsTest() {
        HomePage home = new HomePage(driver);

        home.searchProduct("Tomato");
        home.addFirstProductToCart();

        home.searchProduct("Cucumber");
        home.addFirstProductToCart();

        home.openCart();

        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.getCartItemCount(), 2, "Cart should contain 2 items");

        // Verify all amounts are non-empty (price calculation present)
        cart.getAmounts().forEach(amount ->
            Assert.assertFalse(amount.getText().isEmpty(), "Amount should not be empty")
        );
    }
}
