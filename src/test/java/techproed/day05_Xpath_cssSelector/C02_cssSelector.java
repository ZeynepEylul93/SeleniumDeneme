package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) {
        /*
        cssSelector ile xpath arasındaki farklar;
    1- cssSelector de @ işareti ve // işaretleri kullanılmaz
    2- xpath ile index alabiliriz ama cssSelector ile index alamayız
    3- xpath ile text olarak locate edebiliriz ama cssSelector ile bunu yapamayız
    4- cssSelector xpath'e göre daha hızlı çalışır
         */
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna basin
       WebElement addElementButton= driver.findElement(By.cssSelector("button[onclick='addElement()']"));
       addElementButton.click();
        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton=driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Delete Butonu Gorunur ->Test PASSED");
        }else System.out.println("Delete Butonu Gorunur Degil->Test FAILED");

        //Delete tusuna basin
        deleteButton.click();

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
       WebElement addremoveElement= driver.findElement(By.cssSelector("h3"));
       if (addremoveElement.isDisplayed()){
           System.out.println("Test PASSED");

       }else System.out.println("Test FAILED");

       driver.close();


    }
}
