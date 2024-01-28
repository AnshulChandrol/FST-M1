import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity19 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Home page title: " + driver.getTitle());
        driver.findElement(By.xpath("//button[@id='confirm']")).click();
        String alertText=driver.switchTo().alert().getText();
        System.out.println("Text of alert : "+alertText);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[@id='confirm']")).click();
        driver.switchTo().alert().dismiss();
        driver.close();
    }

}
