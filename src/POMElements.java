
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

    @FindBy(xpath = "(//div[@class='header-links']//a)[2]")
    public WebElement login;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement loginButton;

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

    @FindBy(xpath = "//*[@class='top-menu notmobile']/li//a")
    public List<WebElement> tabMenuWithSubList;

}
