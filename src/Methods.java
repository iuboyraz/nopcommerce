import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Methods {

    public static int randomGenerator(int sinir){
        return (int)(Math.random()*sinir);
    }

    public static boolean listContainsString(List<WebElement> list, String aranacakKelime){
        boolean bulundu=false;
        for(WebElement e: list){
            if (e.getText().toLowerCase().equals(aranacakKelime.toLowerCase()))
            {
                bulundu=true;
                break;
            }
        }

        return bulundu;
    }

    public static void successMessageValidation(){
        main m = new main();
        WebElement msgLabel = m.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }




}
