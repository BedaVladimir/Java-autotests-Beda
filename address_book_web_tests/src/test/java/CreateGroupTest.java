import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CreateGroupTest {

    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @AfterEach
    public void tearDown() {
        driver.findElement(By.xpath("//a[@onclick='document.logout.submit();']")).click();
        driver.quit();
    }
    @Test
    public void createGroupTest() {
        driver.findElement(By.xpath("//a[@href='group.php']")).click();
        driver.findElement(By.xpath("//input[@name='new'][1]")).click();
        driver.findElement(By.xpath("//input[@name='group_name']")).sendKeys("Name1");
        driver.findElement(By.xpath("//textarea[@name='group_header']")).sendKeys("TXT");
        driver.findElement(By.xpath("//textarea[@name='group_footer']")).sendKeys("comment");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.xpath("//i/a[@href='group.php']")).click();
    }



}
