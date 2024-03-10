package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contact;

    private Properties properties;

    public void init(String browser, Properties properties) {
        this.properties = properties;
        if (browser.equals("chrome")) { driver = new ChromeDriver(); }
        else if (browser.equals("firefox")) { driver = new FirefoxDriver(); }
        else { throw new IllegalArgumentException(String.format("Браузер - %s не используется", browser));}
        driver.get(properties.getProperty("web.url"));
        driver.manage().window().maximize();
        session().login(properties.getProperty("web.login"), properties.getProperty("web.password"));
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
