package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.List;

public class CartPage {

    private final WaitUtils wait;

    @FindBy(css = ".cart-item")
    private List<WebElement> cartItems;

    @FindBy(css = ".product-name")
    private List<WebElement> cartProductNames;

    @FindBy(css = ".qty")
    private List<WebElement> quantities;

    @FindBy(css = ".amount")
    private List<WebElement> amounts;

    @FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
    private WebElement proceedToCheckout;

    public CartPage(WebDriver driver) {
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public List<WebElement> getCartProductNames() {
        return cartProductNames;
    }

    public String getQuantityOfItem(int index) {
        return quantities.get(index).getAttribute("value");
    }

    public List<WebElement> getAmounts() {
        return amounts;
    }

    public void proceedToCheckout() {
        wait.waitForClickable(proceedToCheckout);
        proceedToCheckout.click();
    }
}
