import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[]args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://v1.training-support.net");
        System.out.println("Title of WebPage : "+driver.getTitle());
        driver.findElement(By.id("about-link")).click();
        System.out.println("Title of 2nd WebPage : "+driver.getTitle());
        driver.quit();
    }
}
