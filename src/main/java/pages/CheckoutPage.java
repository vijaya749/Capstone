package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CheckoutPage {

    private final WebDriver driver;
    private final WaitUtils wait;

    @FindBy(css = ".promoCode")
    private WebElement promoCodeField;

    @FindBy(css = ".promoBtn")
    private WebElement applyPromoButton;

    @FindBy(css = ".promoInfo")
    private WebElement promoMessage;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(css = ".thank-you")
    private WebElement thankYouMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void applyPromoCode(String code) {
        wait.waitForVisible(promoCodeField);
        promoCodeField.sendKeys(code);
        applyPromoButton.click();
    }

    public String getPromoMessage() {
        wait.waitForVisible(promoMessage);
        return promoMessage.getText();
    }

    public void placeOrder() {
        wait.waitForClickable(placeOrderButton);
        placeOrderButton.click();
    }

    public boolean isOrderConfirmed() {
        return driver.getPageSource().contains("Thank you");
    }
}
