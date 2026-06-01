package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchProductTest() {
        HomePage home = new HomePage(driver);
        home.searchProduct("Cucumber");

        boolean found = home.getProductNames().stream()
            .anyMatch(e -> e.getText().toLowerCase().contains("cucumber"));

        Assert.assertTrue(found, "Product 'Cucumber' should appear in search results");
    }
}
