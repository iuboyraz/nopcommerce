
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class POMElements {
    public POMElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log in")
    public WebElement login;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement loginButton;


    @FindBy(xpath = "//div[@class='header-menu']//ul[@class='top-menu notmobile']/li[7]")
    public WebElement top_Menu;


    @FindBy(xpath = "//input[@id='small-searchterms']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='details']//a")
    public WebElement bookName;

    @FindBy(css = "[class='item-box']")
    public List<WebElement> add_giftcard;

    @FindBy(className = "recipient-name")
    public WebElement recipientName;
    @FindBy(className = "sender-name")
    public WebElement senderName;
    @FindBy(css = "[class=\"bar-notification success\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@style='display: block;']/p")
    public WebElement warning_message;

    @FindBy(css = "[type='button']")
    public WebElement add_to_cart;
}
