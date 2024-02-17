package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity4 {

    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();

       URL serverURL=new URL("http://127.0.0.1:4723/wd/hub");
       driver=new AppiumDriver(serverURL,options);
    }

    @Test
    public void test() throws IOException, InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.android.contacts:id/editor_menu_save_button")).click();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
