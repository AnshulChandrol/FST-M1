import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class Activity14 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println(driver.getTitle());
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("number of rows : "+rows.size());
        List<WebElement> cols=driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("number of columns  : "+cols.size());
        WebElement secondColValue=driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("second row second column values : "+secondColValue.getText());
        driver.findElement(By.xpath("//table[@id='sortableTable']//thead//tr//th[1]")).click();
        System.out.println("second row second column values : "+secondColValue.getText());
        List<WebElement> footerValues=driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for(WebElement cells:footerValues){
            System.out.println("Footer values : "+cells.getText());
        }
        driver.close();
    }
}
