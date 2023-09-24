import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl = "https://demo.nopcommerce.com/";
    public TakesScreenshot ts;
    public POMElements elements;
    SoftAssert _softAssert = new SoftAssert();


    @BeforeClass
    @Parameters("webDriver")
    public void init(String webDriver) {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (webDriver) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        ts = (TakesScreenshot) driver;

        elements = new POMElements(driver);
    }

    @Test
    @Parameters("searchText")
    public void Us7(String searchText){
        elements.login.click();
        elements.email.sendKeys("aliveli123@gmail.com");
        elements.password.sendKeys("aliveli123");
        elements.loginButton.click();
        elements.searchInput.sendKeys(searchText+Keys.ENTER);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 250);");
        elements.bookName.getText();

        Assert.assertTrue(elements.bookName.getText().contains(searchText));


    }
    @BeforeMethod
    void openUri() {
        driver.navigate().to(baseUrl);
    }
    @Test
    @Parameters("searchText")
    void US5_GIFT01() {
 _softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"), "You've not accessed HOME page!");


        Assert.assertTrue(elements.top_Menu.getText().contains("Gift"), "tab menü bulunamadı");
        elements.top_Menu.click();

    int giftRandom = (int) (Math.random() * elements.add_giftcard.size());
        elements.add_giftcard.get(giftRandom).click();

        elements.add_to_cart.click();
        Assert.assertTrue(elements.warning_message.getText().contains("Enter valid"));

        elements.recipientName.sendKeys("ali");
        elements.senderName.sendKeys("cabbar");
        elements.add_to_cart.click();

        Assert.assertTrue(elements.successMessage.getText().contains("shopping cart"));


        _softAssert.assertAll();

}


    @AfterClass
    public void close() {
        driver.quit();
    }

    public static void SaveScreenshot(File source, String prefix) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timeStamp = dateFormat.format(new Date());
        String fileName = prefix + "_" + timeStamp + ".png";

        Path currentRelativePath = Paths.get("");
        String target = currentRelativePath.toAbsolutePath().toString();

        FileUtils.copyFile(source, new File(target + "/src/screenshots/" + fileName));
    }

}
