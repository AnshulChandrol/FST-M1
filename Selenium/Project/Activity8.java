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

public class Activity8 {
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
       driver.findElement(By.xpath("//a[text()='Contact']")).click();
       String title=driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
       Assert.assertEquals(title," Need Help?");
       driver.findElement(By.id("wpforms-8-field_0")).sendKeys("test");
       driver.findElement(By.id("wpforms-8-field_1")).sendKeys("test@gmail.com");
       driver.findElement(By.id("wpforms-8-field_3")).sendKeys("test@gmail.com");
       driver.findElement(By.id("wpforms-8-field_2")).sendKeys("testing fields");
       driver.findElement(By.id("wpforms-submit-8")).click();
      Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wpforms-confirmation-container wpforms-confirmation-scroll']")).isDisplayed());
        String confirmation=driver.findElement(By.xpath("//div[@class='wpforms-confirmation-container wpforms-confirmation-scroll']")).getText();
    System.out.println(confirmation);
    }
}
