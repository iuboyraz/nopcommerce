import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public static void SaveScreenshot(File source, String prefix) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String timeStamp = dateFormat.format(new Date());
        String fileName = prefix + "_" + timeStamp + ".png";

        Path currentRelativePath = Paths.get("");
        String target = currentRelativePath.toAbsolutePath().toString();

        FileUtils.copyFile(source, new File(target + "/src/screenshots/" + fileName));
    }

    @BeforeMethod
    void openUrl() {
        driver.navigate().to(baseUrl);
    }

    // @assigned=Umut Can G�zel
    @Test
    @Parameters("searchText")
    public void Us8Search(String searchText){
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

    // @assigned=�mit Boyraz
    @Test
    void US4TabMenu01() {
        _softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"), "You've not accessed main page!");

        List<String> expectedTabMenu = new ArrayList<>();
        expectedTabMenu.add("Computers");
        expectedTabMenu.add("Electronics");
        expectedTabMenu.add("Apparel");
        expectedTabMenu.add("Digital downloads");
        expectedTabMenu.add("Books");
        expectedTabMenu.add("Jewelry");
        expectedTabMenu.add("Gift Cards");

        List<WebElement> actualTabMenu = elements.tabMenuList;

        for (int i = 0; i < expectedTabMenu.size(); i++) {
            _softAssert.assertEquals(actualTabMenu.get(i).getText(), expectedTabMenu.get(i), "Menu is not the same as expected!");
        }

        for (int i = 0; i < actualTabMenu.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(actualTabMenu.get(i)));
            actualTabMenu.get(i).click();
            if (driver.getCurrentUrl().toLowerCase().contains("computers") ||
                    driver.getCurrentUrl().toLowerCase().contains("electronics") ||
                    driver.getCurrentUrl().toLowerCase().contains("apparel") ||
                    driver.getCurrentUrl().toLowerCase().contains("digital-downloads") ||
                    driver.getCurrentUrl().toLowerCase().contains("books") ||
                    driver.getCurrentUrl().toLowerCase().contains("jewelry") ||
                    driver.getCurrentUrl().toLowerCase().contains("gift-cards")) {
                System.out.println("Tab menu web elements are directing user its own menu");
            }
            else {
                System.out.println("Tab menu web elements are not directing user its own menu!");
            }
        }

        List<WebElement> tabMenuComputersList = elements.tabMenuComputersList;

        for (int i = 0; i <tabMenuComputersList.size() ; i++) {
            wait.until(ExpectedConditions.visibilityOf(actualTabMenu.get(0)));
            new Actions(driver).moveToElement(actualTabMenu.get(0)).build().perform();
            tabMenuComputersList.get(i).click();
            if (driver.getCurrentUrl().toLowerCase().contains("desktops") ||
                    driver.getCurrentUrl().toLowerCase().contains("notebooks") ||
                    driver.getCurrentUrl().toLowerCase().contains("software")) {
                System.out.println("Computers menu web elements are directing user its own menu");
            } else {
                System.out.println("Computers menu web elements are not directing user its own menu!");
            }
        }

        List<WebElement> tabMenuElectronicsList = elements.tabMenuElectronicsList;

        for (int i = 0; i <tabMenuElectronicsList.size() ; i++) {
            wait.until(ExpectedConditions.visibilityOf(actualTabMenu.get(1)));
            new Actions(driver).moveToElement(actualTabMenu.get(1)).build().perform();
            tabMenuElectronicsList.get(i).click();
            if (driver.getCurrentUrl().toLowerCase().contains("camera-photo") ||
                    driver.getCurrentUrl().toLowerCase().contains("cell-phones") ||
                    driver.getCurrentUrl().toLowerCase().contains("others")) {
                System.out.println("Electronics menu web elements are directing user its own menu");
            } else {
                System.out.println("Electronics menu web elements are not directing user its own menu!");
            }
        }

        List<WebElement> tabMenuApparelList = elements.tabMenuApparelList;

        for (int i = 0; i <tabMenuApparelList.size() ; i++) {
            wait.until(ExpectedConditions.visibilityOf(actualTabMenu.get(2)));
            new Actions(driver).moveToElement(actualTabMenu.get(2)).build().perform();
            tabMenuApparelList.get(i).click();
            if (driver.getCurrentUrl().toLowerCase().contains("shoes") ||
                    driver.getCurrentUrl().toLowerCase().contains("clothing") ||
                    driver.getCurrentUrl().toLowerCase().contains("accessories")) {
                System.out.println("Apparel menu web elements are directing user its own menu");
            } else {
                System.out.println("Apparel menu web elements are not directing user its own menu!");
            }
        }
        _softAssert.assertAll();
    }

    //Selen Dilek
    @Test
    @Parameters("product")
    void US4TabMenu02() {

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SoftAssert _softAssert = new SoftAssert();

        for (int i = 0; i < elements.top_Menu.size(); i++) {

            new Actions(driver).moveToElement(elements.top_Menu.get(i)).build().perform();

            for (WebElement item : elements.products_MenuItem) {

                System.out.println("item.getText() = " + item.getText());

            }

        }
    }




    @AfterClass
    public void close() {
        driver.quit();
    }

}
