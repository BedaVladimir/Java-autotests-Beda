package manager;
import model.ContactData;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper {
    protected final ApplicationManager manager;

    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void clickContactLink() {
        manager.driver.findElement(By.xpath("//ul/li/a[@href='edit.php']")).click();
    }

    public void createContact(ContactData contact) {
        fillContact(contact);
        manager.driver.findElement(By.name("submit")).click();
        returnHomePage();
    }

    public void deleteContact() {
        manager.driver.findElement(By.xpath("//tr/td/input[@type='checkbox']")).click();
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
        returnHomePage();
    }

    public int getCountContact() {
        return manager.driver.findElements(By.xpath("//tr/td/input[@type='checkbox']")).size();
    }

    public void deleteAllContacts() {
        var contacts = manager.driver.findElements(By.xpath("//tr/td/input[@type='checkbox']"));
        for (var contact : contacts) {
            contact.click();
        }
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
        returnHomePage();
    }

    public void modifyContact(ContactData contact, ContactData modcontact) {
        selectContact(contact);
        manager.driver.findElement(By.xpath("//tbody/tr[@name='entry']/td[8]/a")).click();
        manager.driver.findElement(By.name("firstname")).clear();
        fillContact(modcontact);
        manager.driver.findElement(By.xpath("//input[@name='update']")).click();
        returnHomePage();

    }

    private void fillContact(ContactData contact) {
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.fname());
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lname());
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).sendKeys(contact.number());
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
    }

    private void returnHomePage() {
        manager.driver.findElement(By.xpath("//ul//a[@href='./']")).click();
    }

    public List<ContactData> getContactList() {
        var contacts = new ArrayList<ContactData>();
        var recordings = manager.driver.findElements(By.xpath("//tbody/tr[@name='entry']"));
        for (var recording : recordings) {
            var fname = recording.findElement(By.xpath("//td[3]")).getText();
            var checkbox = recording.findElement(By.xpath("//input[@type='checkbox']"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(fname));
        }
        return contacts;
    }

    private void selectContact(ContactData contact) {
        manager.driver.findElement(By.xpath(String.format(
                "//tr/td/input[@type='checkbox'][@value='%s']", contact.id()))).click();
    }
}
