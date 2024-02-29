package manager;
import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {
    protected final ApplicationManager manager;
    public ContactHelper(ApplicationManager manager) { this.manager = manager;}
    public void clickContactLink() {
        manager.driver.findElement(By.xpath("//ul/li/a[@href='edit.php']")).click();
    }
    public void createContact(ContactData contact) {
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.fname());
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lname());
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).sendKeys(contact.number());
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.xpath("//ul//a[@href='./']")).click();
    }
    public boolean isContactPresent() {
        return !manager.isElementPresent(By.xpath("//tr/td/input[@type='checkbox']"));
    }
    public void deleteContact() {
        manager.driver.findElement(By.xpath("//tr/td/input[@type='checkbox']")).click();
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
    }
}
