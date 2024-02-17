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

public class Activity7 {
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
       driver.findElement(By.xpath("//a[text()='All Courses']")).click();
       String title=driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
       Assert.assertEquals(title,"All Courses");
       int numberOfCourse=driver.findElements(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 ']")).size();
        System.out.println(numberOfCourse);
    }
}
