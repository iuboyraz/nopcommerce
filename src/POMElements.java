
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class POMElements extends Methods {
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

    @FindBy(linkText = "Computers")
    public WebElement computers;

    @FindBy(linkText ="Desktops")
    public WebElement desktop;

    @FindBy(xpath = "//a[contains(text(), 'Build your own computer')]")
    public WebElement buildComputer ;

    @FindBy(xpath = "//*[@id='product_attribute_2']//option")
    public List<WebElement> productList;

    @FindBy(xpath = "//*[@id='product_attribute_2']")
    public WebElement productList1;

    @FindBy(xpath = "//*[@id=\"product_attribute_input_3\"]//label")
    public List<WebElement> hddRadioButtons;

    @FindBy(xpath = "//*[@id='add-to-cart-button-1']")
    public WebElement addToCart ;

    @FindBy(xpath = "//*[@id='bar-notification']/div/p/text()")
    public WebElement msg ;

    @FindBy(xpath = "//div[@class='header-menu']//ul[@class='top-menu notmobile']/lia")
    public List<WebElement> top_Menu;

    @FindBy(tagName = "a")
    public List<WebElement> products_MenuItem;

    @FindBy(xpath ="(//*[@class='top-menu notmobile']/li/ul)[1]//a")
    public List<WebElement> computer_List;

    @FindBy(xpath ="(//*[@class='top-menu notmobile']/li/ul)[2]//a")
    public List<WebElement> electronics_List;

    @FindBy(xpath ="(//*[@class='top-menu notmobile']/li/ul)[3]//a")
    public List<WebElement> apperal_List;

    @FindBy(xpath ="//div[@class='product-item']//div[@class='picture']/a")
    public List<WebElement> all_products;

    @FindBy(xpath ="//div[@class='overview']//div[@class='product-name']/h1")
    public WebElement all_products_name_List; //bir tane adi var fakat bulamazsa null dondursun diye yazdim.

    @FindBy(xpath = "//input[@id='small-searchterms']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='details']//a")
    public WebElement bookName;

    @FindBy(xpath = "//*[@class='top-menu notmobile']/li/a")
    public List<WebElement> tabMenuList ;

    @FindBy(xpath = "(//*[@class='top-menu notmobile']/li/ul)[1]//a")
    public List<WebElement> tabMenuComputersList;

    @FindBy(xpath = "(//*[@class='top-menu notmobile']/li/ul)[2]//a")
    public List<WebElement> tabMenuElectronicsList;

    @FindBy(xpath = "(//*[@class='top-menu notmobile']/li/ul)[3]//a")
    public List<WebElement> tabMenuApparelList;


    @FindBy(css = "[class='item-box']")
    public List<WebElement> add_giftcard ;

    @FindBy(className = "recipient-name")
    public WebElement recipientName ;
    @FindBy(className = "sender-name")
    public WebElement senderName ;
    @FindBy(css = "[class=\"bar-notification success\"]")
    public WebElement successMessage ;

    @FindBy(xpath = "//div[@style='display: block;']/p")
    public WebElement warning_message ;

    @FindBy(css= "[type='button']")
    public WebElement  add_to_cart ;
    @FindBy(xpath = "//div[@class='header-menu']//ul[@class='top-menu notmobile']/li[7]")
    public WebElement top_Menu1;

}
