package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Login page")
    public void user_is_on_login_page() {
       driver=new FirefoxDriver();
       wait=new WebDriverWait(driver, Duration.ofSeconds(15));
       driver.get("https://v1.training-support.net/selenium/login-form");
       driver.manage().window().maximize();
    }
    @When("User enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@onclick='signIn()']")).click();
    }
    @Then("Read the page title and confirmation message")
    public void read_the_page_title_and_confirmation_message() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
    }
    @Then("Close the Browser")
    public void close_the_browser() {
        driver.close();
    }

}
