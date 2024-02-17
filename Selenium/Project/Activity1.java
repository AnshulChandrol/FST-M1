package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/lms");
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void test(){
        String title=driver.getTitle();
        Assert.assertEquals(title,"Alchemy LMS – An LMS Application");
//        driver.findElement(By.xpath("//a[text()='My Account']")).click();
//        driver.findElement(By.xpath("//*[text()='Login']")).click();
//        driver.findElement(By.id("user_login")).sendKeys("root");
//        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
    }
}
