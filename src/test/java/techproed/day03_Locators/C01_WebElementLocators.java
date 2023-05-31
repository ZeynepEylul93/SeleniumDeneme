package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebElementLocators {
    public static <WebElements> void main(String[] args) {
        //tester icin en onemlisi duzgun locate alma ve dogrulama
        // id  varsa once o yoksa xpath isimizi gorur
        //Selenium la UI test yapiyoruz.(user interface)

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon Sayfasina gidelim
        driver.get("https://www.amazon.com");//navigate.to ile de gidebiliriz

        //Arama kutusunu locate edelim
         driver.findElement(By.id("twotabsearchtextbox"));

        //Arama kutusuna iphone yazdiralim ve aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        /*
        Bir webelementin locate'ini birden fazla kullanacaksak bir WebElement'e degisken olarak atayabiliriz
        Webelement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));seklinde kullanabiliriz
        1- Locate islemi bittikten sonra eger webelemente bir metin gondereceksek sendKeys() metodu kullaniriz
        2-webelemente tiklayacaksak click() metodu kullaniriz
        3-webelementin uzerindeki yaziyi almak istiyorsak getText() methodunu kullaniriz
        4-sendKeys() methodundan sonra(yani webelemente metin gonderdikten sonra)Keys.ENTER ile
          yada submit() methodu ile manuel olarak enter yaptığımız gibi otomasyonda da yapabiliriz.
         */


        //Sayfayi kapatalim
        driver.close();


    }
}
