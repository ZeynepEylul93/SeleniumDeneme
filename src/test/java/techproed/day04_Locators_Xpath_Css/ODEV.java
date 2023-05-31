package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ODEV {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı locate edip kapatalım

       driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //Arama bölümünde qa aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("qa"+ Keys.ENTER);

        //Sayfa başlığının qa içerdiğini doğrulayalım
         String actualTitle= driver.getTitle();
         String expectedTitle="qa";
         if (actualTitle.contains(expectedTitle)){
             System.out.println("Test PASS");
         }else System.out.println("Test FAIL");

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
       WebElement carrerLinkElement= driver.findElement(By.xpath("(//h3[@class='elementor-post__title'])[1]"));
       if (carrerLinkElement.isEnabled() && carrerLinkElement.isDisplayed()){
           System.out.println("Link Gorunur ve Erisilebilir");
       }else System.out.println("linke erisilemedi");


        //Carrer Opportunities In QA linkine tıklayalım
        carrerLinkElement.click();

        //Başlığın Opportunities içerdiğini test edelim
       String actualCarrerTitle= driver.getTitle();
       String expectedCarrerTitle=" Opportunities";
       if (actualCarrerTitle.contains(expectedCarrerTitle)){
           System.out.println("Test PASS");
       }else System.out.println("Test FAIL");

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
       driver.navigate().back();
        driver.navigate().back();
       // driver.findElement(By.xpath("(//div[@class='elementor-widget-container'])[4]")).click();
       String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);
       String expectedUrl="https://techproeducation.com/";
       if (actualUrl.equals(expectedUrl)){
           System.out.println("Test PASSED");
       }else System.out.println("Test FAILED->"+actualUrl);

       driver.close();


    }
}
