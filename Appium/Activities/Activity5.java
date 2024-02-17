package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {

    AppiumDriver driver;
WebDriverWait wait;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
        Thread.sleep(300);
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("999148292");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
        String messageTextSent = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }
}
