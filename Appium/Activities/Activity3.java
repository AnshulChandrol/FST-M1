package Activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AppiumDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");

// Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
// Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
@Test(priority = 4)
    public void test1(){
    System.out.println("Addition of number");
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        String result= driver.findElement(By.id("com.android.calculator2:id/result")).getAttribute("text");
        Assert.assertEquals(result,"14");
    }
@Test(priority = 1)
    public void test2(){
        System.out.println("Subtraction of number");
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_sub")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        String result= driver.findElement(By.id("com.android.calculator2:id/result")).getAttribute("text");
        Assert.assertEquals(result,"5");
    }
@Test(priority = 5)
    public void test3(){
        System.out.println("multipication of number");
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        String result= driver.findElement(By.id("com.android.calculator2:id/result")).getAttribute("text");
        Assert.assertEquals(result,"500");
    }
    @Test
    public void test4() {
        System.out.println("division of number");
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getAttribute("text");
        Assert.assertEquals(result, "25");
    }
}
