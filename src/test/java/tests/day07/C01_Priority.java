package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
        @Test(priority=2)
        public void amazonTest(){
            driver.get("https://www.amazon.com");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());


        }
        @Test(priority = 10)
        public void facebookTest(){
            driver.get("https://www.facebook.com");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
        }

        @Test(priority = 4)
        public void eurotechStudyTest(){
           driver.get("https://www.eurotechstudy.com");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
        }
       @AfterMethod
       public void TearDown(){
        driver.close();
       }

    }

