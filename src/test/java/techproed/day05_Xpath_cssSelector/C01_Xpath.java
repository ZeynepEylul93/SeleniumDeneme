package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike"  yazıp aratın
        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
        autocomplete="off" placeholder="Search Amazon" class="nav-input nav-progressive-attribute"
         dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */
       //  WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       //WebElement aramaKutusu=driver.findElement(By.xpath("//*[@name='field-keywords']"));
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        // Hybrid Bikes bölümüne tıklayın
        driver.findElement(By.xpath("//*[.='Hybrid Bikes']")).click();

        // sonuc sayısını yazdırın
       WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='sg-col-inner'][1]"));
        System.out.println(sonucYazisi.getText());
       String []sonucSayisi= sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi :"+sonucSayisi[0]);

        // ilk ürününe tıklayın
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-fixed-height'][1])")).click();


        // Sayfayı kapatınız
        driver.close();

    }
}
