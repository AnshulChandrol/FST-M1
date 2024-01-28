import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Title of webpage : " + driver.getTitle());
        driver.findElement(By.xpath("//button[text()='Change Content']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h1")));
        System.out.println("message displaying in page : "+ driver.findElement(By.tagName("h1")).getText());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h3")));
        System.out.println("message displaying in page : "+ driver.findElement(By.tagName("h3")).getText());
        driver.close();
    }
}