import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected WebDriver driver;

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

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void createGroup(String name, String header, String footer) {
        driver.findElement(By.xpath("//a[@href='group.php']")).click();
        driver.findElement(By.xpath("//input[@name='new'][1]")).click();
        driver.findElement(By.xpath("//input[@name='group_name']")).sendKeys(name);
        driver.findElement(By.xpath("//textarea[@name='group_header']")).sendKeys(header);
        driver.findElement(By.xpath("//textarea[@name='group_footer']")).sendKeys(footer);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.xpath("//i/a[@href='group.php']")).click();
    }

    protected void deleteGroup() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='delete'][1]")).click();
    }

    protected boolean isGroupPresent() {
        return !isElementPresent(By.xpath("//input[@type='checkbox']"));
    }

    protected void clickLinkGroup() {
        driver.findElement(By.xpath("//a[@href='group.php']")).click();
    }
}
