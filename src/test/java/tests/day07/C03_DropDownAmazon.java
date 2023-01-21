package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_DropDownAmazon {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List<WebElement> tumOpsiyonlar = select.getOptions();
        System.out.println("tum opsiyonlar listesi");
        for (WebElement each : tumOpsiyonlar
        ) {
            System.out.println(each.getText());

        }
        System.out.println("Kategori sayısı:"+tumOpsiyonlar.size());
        if(tumOpsiyonlar.size()==45){
            System.out.println("true");
        }else
            System.out.println("false");



//    }
//    @Test
//    public void test2(){
//        driver.get("https://www.amazon.com");
//        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
//        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());
//    }
//    @Test
//    public void test3(){
//        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement resultText=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'][1])"));
        System.out.println(resultText.getText());
        Assert.assertTrue(resultText.getText().contains("Java"));
    }
}