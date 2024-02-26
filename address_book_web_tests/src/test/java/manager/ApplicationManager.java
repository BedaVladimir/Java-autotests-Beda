package manager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public static WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void createGroup(GroupData group) {
        driver.findElement(By.xpath("//a[@href='group.php']")).click();
        driver.findElement(By.xpath("//input[@name='new'][1]")).click();
        driver.findElement(By.xpath("//input[@name='group_name']")).sendKeys(group.name());
        driver.findElement(By.xpath("//textarea[@name='group_header']")).sendKeys(group.header());
        driver.findElement(By.xpath("//textarea[@name='group_footer']")).sendKeys(group.footer());
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.xpath("//i/a[@href='group.php']")).click();
    }

    public void deleteGroup() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='delete'][1]")).click();
    }

    public boolean isGroupPresent() {
        return !isElementPresent(By.xpath("//input[@type='checkbox']"));
    }

    public void clickLinkGroup() {
        driver.findElement(By.xpath("//a[@href='group.php']")).click();
    }
}
