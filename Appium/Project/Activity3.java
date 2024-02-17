package LiveProject;

import Examples.guestures;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity3 {
    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setAppPackage("com.android.chrome");
        options.noReset();
        URL serverURL=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AppiumDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @AfterMethod
    public void close(){

//        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'Selenium')]")));
        Dimension dims=driver.manage().window().getSize();

        Point start=new Point((int) (dims.getWidth()*0.5), (int) (dims.getHeight()*0.85));
        Point end=new Point((int) (dims.getWidth()*0.5), (int) (dims.getHeight()*0.5));
        guestures.doSwipe(driver,start,end,200);
        guestures.doSwipe(driver,start,end,200);

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath
                ("//android.view.View[contains(@text,'To-Do List')]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath
                ("//android.view.View[contains(@text,'To-Do List')]")));
        Thread.sleep(200);
        WebElement addTask= driver.findElement(AppiumBy.xpath("//android.view.View/android.widget.EditText"));
        WebElement click=driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]"));
        addTask.sendKeys("Add tasks to list");
        click.click();
        Thread.sleep(1000);
        addTask.sendKeys("Get number of tasks");
        click.click();
        Thread.sleep(1000);
        addTask.sendKeys("Clear the list");
        click.click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'Add tasks to list')]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'Get number of tasks')]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'Clear the list')]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'Clear List')]")).click();
        Thread.sleep(1000);
    }
}
