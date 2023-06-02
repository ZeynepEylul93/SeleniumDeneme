package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ODEV {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    // Add Element butonuna 100 defa basınız
      WebElement addButonu= driver.findElement(By.xpath("//*[text()='Add Element']"));
        for (int i = 0; i <100; i++) {
           addButonu.click();
        }

    // 100 defa basıldığını test ediniz
      List<WebElement> deleteButonuList = driver.findElements(By.xpath("//*[text()='Delete']"));
      if (deleteButonuList.size()==100){
          System.out.println("Test PASS");
      }else System.out.println("Test FAIL");

   // 90 defa delete butonuna basınız
       int sayac=0;
        for (int i = 0; i <90 ; i++) {
           driver.findElement(By.xpath("(//*[text()='Delete'])[1]")).click();
          sayac++;
        }


   // 90 defa basıldığını doğrulayınız
      if (sayac==90){
          System.out.println("Test Pass");
      }else System.out.println("Test Fail");

   // Sayfayı kapatınız
        driver.close();






    }
}
