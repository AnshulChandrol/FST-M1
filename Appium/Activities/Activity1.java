package Activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    AppiumDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

       URL serverURL=new URL("http://127.0.0.1:4723/wd/hub");
       driver=new AppiumDriver(serverURL,options);
    }

    @Test
    public void test() throws IOException {
        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
        driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        takeScreenshot();
       String result= driver.findElement(By.id("com.android.calculator2:id/result")).getAttribute("text");
        Assert.assertEquals(result,"16");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
    public void takeScreenshot() throws IOException {
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenShotName = new File("target/screenshot.jpg");
        FileUtils.copyFile(scrShot, screenShotName);
        String filepath="../"+screenShotName;
        String logSC="<img src='"+filepath+"'/>";
        Reporter.log(logSC);
    }
}
