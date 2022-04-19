import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeSuite
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void Login(){
        driver.get("https://accounts.google.com/signin/chrome/sync/identifier?ssp=1&continue=https%3A%2F%2Fwww.google.com%2F&flowName=GlifDesktopChromeSync");
        driver.manage().window().setSize(new Dimension(1296, 688));
        driver.findElement(By.id("identifierId")).sendKeys("m30918034");
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.name("password")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[3]")).click();
    }
    public void quit(){
        driver.quit();
    }

}



