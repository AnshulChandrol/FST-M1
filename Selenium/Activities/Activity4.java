import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
    public static void main(String[]args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Webpage title : "+driver.getTitle());
        String text=driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("3rd hearder text: "+text);
        String colour=driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println("Colour of 5th header: "+colour);
        String violet_class=driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("classes of violet button : "+violet_class);
        String greyColourText=driver.findElement(By.xpath("//button[@class='ui grey button']")).getText();
        System.out.println("Grey colour button text : "+greyColourText);
        driver.close();
    }

}
