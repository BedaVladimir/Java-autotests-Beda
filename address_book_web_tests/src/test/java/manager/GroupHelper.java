package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void clickLinkGroup() {
        manager.driver.findElement(By.xpath("//a[@href='group.php']")).click();
    }

    public void createGroup(GroupData group) {
        manager.driver.findElement(By.xpath("//input[@name='new'][1]")).click();
        manager.driver.findElement(By.xpath("//input[@name='group_name']")).sendKeys(group.name());
        manager.driver.findElement(By.xpath("//textarea[@name='group_header']")).sendKeys(group.header());
        manager.driver.findElement(By.xpath("//textarea[@name='group_footer']")).sendKeys(group.footer());
        manager.driver.findElement(By.xpath("//input[@name='submit']")).click();
        manager.driver.findElement(By.xpath("//i/a[@href='group.php']")).click();
    }

    public void deleteGroup() {
        manager.driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        manager.driver.findElement(By.xpath("//input[@name='delete'][1]")).click();
    }
    public void deleteAllGroups() {
        var groups = manager.driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (var group : groups) {
            group.click();
        }
        manager.driver.findElement(By.xpath("//input[@name='delete'][1]")).click();
    }

    public int getGroupCount() {
        clickLinkGroup();
        return manager.driver.findElements(By.xpath("//input[@type='checkbox']")).size();
    }
}
