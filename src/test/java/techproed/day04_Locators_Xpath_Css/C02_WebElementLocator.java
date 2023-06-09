package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_WebElementLocator {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);


        // sonuc yazısını yazdırın
       List<WebElement> sonucYazisi=driver.findElements(By.className("sg-col-inner"));
       // System.out.println(sonucYazisi.get(0));->boyle hashcodunu yazdirdi
        System.out.println(sonucYazisi.get(0).getText());//getText->sonuc yazisini yazdirir//1-16 of 180 results for "city bike"

        // sonuc sayısını yazdırın
        String [] sonucSayisi=sonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc Sayisi :"+sonucSayisi[2]);

        // ilk ürünün locatini alın
        List<WebElement> urunler = driver.findElements(By.className("s-image"));
        WebElement ilkUrun = urunler.get(0);

        // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isDisplayed());//True

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isEnabled());//True

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isSelected()); //False doner cunku webelement secilme ozelligine sahip degil

        // ilk urune tıklayın
        ilkUrun.click();//webelementin uzerine tiklar

        // sayfayı kapatın
        driver.close();


          /*
            //ARAMA KUTUSUNUN HTML KODLARI
            <input type="text" value="" name="field-keywords" autocomplete="off"
            placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
            tabindex="0" aria-label="Search Amazon" spellcheck="false">
             */
        //Relative Xpath syntax -->  //tagname[@attributeName='atributeValue']
        //input[@type='text']
        //                            (//input[@type='text'])[1]
        //                            //*[@type='text']
    /*
        Aldığımız xpath unique olmadığı zaman xpath'imizi parantez içine alarak index belirtebiliriz.
    Böylelikle webelementleri Liste atıp istediğimiz elementi almakla uğraşmayız.
    Xpath'in değişik kullanma yolları vardır.
     */



    }
}
