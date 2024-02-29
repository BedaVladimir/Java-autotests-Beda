package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contact;

    public void init() {
        driver = new ChromeDriver();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().maximize();
        session().login("admin", "secret");
    }
    public void closeDriver() {
        driver.findElement(By.xpath("//a[@onclick='document.logout.submit();']")).click();
        driver.quit();
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }
    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }
    public ContactHelper contact() {
        if (contact == null) {
            contact = new ContactHelper(this);
        }
        return contact;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
