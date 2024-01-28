import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Activity7 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Title of webpage : " + driver.getTitle());
        WebElement football =driver.findElement(By.xpath("//img[@id='draggable']"));
        WebElement dropzone1 =driver.findElement(By.id("droppable"));
        WebElement dropzone2 =driver.findElement(By.id("dropzone2"));
        builder.clickAndHold(football).moveToElement(dropzone1).pause(1000).release().build().perform();
        builder.dragAndDrop(football,dropzone2).build().perform();
        driver.close();


    }
}