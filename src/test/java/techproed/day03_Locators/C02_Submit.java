package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Submit {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon Sayfasina gidelim
        driver.get("https://amazon.com");

        //Arama kutusunu locate edip iphone aratalim
       WebElement aramaKutusu= driver.findElement(By.name("field-keywords"));
       aramaKutusu.sendKeys("iphone");
       Thread.sleep(3000);
       aramaKutusu.submit();// Submit==Keys.ENTER


        //Sayfayı kapatalım
        driver.close();
    }
}
