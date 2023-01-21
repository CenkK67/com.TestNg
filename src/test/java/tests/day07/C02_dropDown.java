package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_dropDown {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void test (){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select select =new Select((dropDown));
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> tumOpsiyonlar=select.getOptions();
        System.out.println("tum opsiyonlar listesi");
        for (WebElement each:tumOpsiyonlar
             ) {
            System.out.println(each.getText());
        }

        System.out.println(tumOpsiyonlar.size());
        if(tumOpsiyonlar.size()==4){
            System.out.println("true");

        }else
            System.out.println("false");



    }
    @AfterMethod
    public void TearDown(){
        driver.close();
    }
}
