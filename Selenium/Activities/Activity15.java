import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity15 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@placeholder='Username' and starts-with(@class,'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@placeholder='Password' and starts-with(@class,'password-')]")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);
        driver.quit();
    }
}
