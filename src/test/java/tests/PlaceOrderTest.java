package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void placeOrderTest() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Cucumber");
        home.addFirstProductToCart();
        home.openCart();

        CartPage cart = new CartPage(driver);
        cart.proceedToCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.applyPromoCode("rahulshettyacademy");
        checkout.placeOrder();

        Assert.assertTrue(checkout.isOrderConfirmed(), "Order confirmation page should contain 'Thank you'");
    }
}
