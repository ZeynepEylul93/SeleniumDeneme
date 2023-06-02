package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TekrarTesti {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //   2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //  3- Browseri tam sayfa yapin
       // driver.manage().window().fullscreen();

        //  4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //  5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
       String actualTitle= driver.getTitle();
       String expectedTitle="Spend less";
       if (actualTitle.contains(expectedTitle)){
           System.out.println("Test Pass");
       }else System.out.println("Test FAIL");

        //  6- Gift Cards sekmesine basin
      driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();

        //  7- Birthday butonuna basin
        driver.findElement(By.xpath("//*[text()='Birthday']")).click();

        //  8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='nav-a-content'])[2]")).click();
        driver.findElement(By.xpath("//img[@alt='Amazon Reload']")).click();

        //   9- Gift card details’den 25 $’i secin

       WebElement miktar= driver.findElement(By.xpath("//button[@id='a-autoid-0-announce']"));

        //   10-Urun ucretinin 25$ oldugunu test edin
        System.out.println(miktar.getText());
        String actualmiktar=miktar.getText();
        String expectedmiktar="$25";
        if (actualmiktar.equals(expectedmiktar)){
            System.out.println("Test Pass");
        }else System.out.println("Test Fail");

        //   10-Sayfayi kapatin
        driver.close();
    }
}
