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

public class Activity9 {
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
        String title2=driver.getTitle();
        Assert.assertEquals(title2,"Alchemy LMS – An LMS Application");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Howdy, ']")).isDisplayed());

        driver.findElement(By.xpath("//a[text()='All Courses']")).click();
       String title3=driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
       Assert.assertEquals(title3,"All Courses");
       driver.findElements(By.xpath
               ("//div[@class='ld_course_grid col-sm-8 col-md-4 ']")).get(0).click();
        String title1=driver.getTitle();
        System.out.println(title1);
        driver.findElement(By.xpath("//div[contains(text(),'Developing Strategy')]")).click();
        String title4= driver.getTitle();
        System.out.println(title4);
        driver.findElements(By.xpath("//span[text()='Next Lesson']")).get(1).click();

    }
}
