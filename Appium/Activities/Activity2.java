package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AppiumDriver driver;
    WebDriverWait wait;
     @BeforeMethod
    public void setup() throws MalformedURLException, InterruptedException {
         UiAutomator2Options options=new UiAutomator2Options();
         options.setAppActivity("com.google.android.apps.chrome.Main");
         options.setAutomationName("UiAutomator2");
         options.setPlatformName("Android");
         options.setAppPackage("com.android.chrome");
         options.noReset();
         URL serverURL=new URL("http://127.0.0.1:4723/wd/hub");
         driver=new AppiumDriver(serverURL,options);
         wait=new WebDriverWait(driver, Duration.ofSeconds(30));
         driver.get("https://www.training-support.net/");
         Thread.sleep(3000);
     }

     @Test
    public void test1(){
         WebElement heading=driver.findElement
                 (AppiumBy.xpath("//android.view.View[contains(@text,'Training Support')]"));
         wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'Training Support')]")));
        String headingText=heading.getText();
         Assert.assertEquals(headingText,"Training Support");
     }
@Test
    public void test2(){
        WebElement aboutUs=driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'About Us')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'About Us')]")));
        String aboutUsText=aboutUs.getText();
        Assert.assertEquals(aboutUsText,"About Us");
    }

    @AfterMethod
    public void close(){
         driver.quit();
    }

}
