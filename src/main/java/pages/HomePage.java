package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.List;

public class HomePage {

    private final WebDriver driver;
    private final WaitUtils wait;

    @FindBy(css = ".search-keyword")
    private WebElement searchBox;

    @FindBy(css = ".product")
    private List<WebElement> productCards;

    @FindBy(css = ".product-name")
    private List<WebElement> productNames;

    @FindBy(xpath = "//button[text()='ADD TO CART']")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".cart-icon img")
    private WebElement cartIcon;

    @FindBy(css = "a.cart-icon")
    private WebElement cartLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
        wait.waitForVisible(searchBox);
        searchBox.clear();
        searchBox.sendKeys(product);
    }

    public List<WebElement> getProductCards() {
        return productCards;
    }

    public List<WebElement> getProductNames() {
        return productNames;
    }

    public void addFirstProductToCart() {
        wait.waitForClickable(addToCartButtons.get(0));
        addToCartButtons.get(0).click();
    }

    public void addProductToCartByIndex(int index) {
        wait.waitForClickable(addToCartButtons.get(index));
        addToCartButtons.get(index).click();
    }

    public void openCart() {
        wait.waitForClickable(cartLink);
        cartLink.click();
    }
}
