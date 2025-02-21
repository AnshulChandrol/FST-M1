import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of webpage : " + driver.getTitle());
        WebElement checkbox=driver.findElement(By.className("willDisappear"));
        WebElement removeCheckbox=driver.findElement(By.id("toggleCheckbox"));
        if(checkbox.isDisplayed()){
            System.out.println("Checkbox is visible");
        }else{
            System.out.println("Checkbox is not visible");
        }
        removeCheckbox.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("willDisappear")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        removeCheckbox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        driver.findElement(By.xpath("//input[@class='willDisappear']")).click();
        driver.close();

    }
}