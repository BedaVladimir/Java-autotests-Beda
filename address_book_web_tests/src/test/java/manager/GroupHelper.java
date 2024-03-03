package manager;
import model.GroupData;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

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
        fillGroupForm(group);
        manager.driver.findElement(By.xpath("//input[@name='submit']")).click();
        returnGroupPage();
    }

    public void deleteGroup(GroupData group) {
        manager.driver.findElement(By.cssSelector(String.format("input[value='%s']", group.id()))).click();
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

    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>();
        var spans = manager.driver.findElements(By.xpath("//span[@class='group']"));
        for (var span : spans) {
            var name = span.getText();
            var checkbox = span.findElement(By.xpath("//input[@type='checkbox']"));
            var id = checkbox.getAttribute("value");
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

    public void modifyGroups(GroupData group) {
        clickLinkGroup();
        selectGroup();
        initGroupMod();
        manager.driver.findElement(By.xpath("//input[@name='group_name']")).clear();
        fillGroupForm(group);
        submitGroupMod();
        returnGroupPage();
    }

    private void returnGroupPage() {
        manager.driver.findElement(By.xpath("//i/a[@href='group.php']")).click();
    }

    private void submitGroupMod() {
        manager.driver.findElement(By.xpath("//input[@name='update']")).click();
    }

    private void fillGroupForm(GroupData group) {
        manager.driver.findElement(By.xpath("//input[@name='group_name']")).sendKeys(group.name());
        manager.driver.findElement(By.xpath("//textarea[@name='group_header']")).sendKeys(group.header());
        manager.driver.findElement(By.xpath("//textarea[@name='group_footer']")).sendKeys(group.footer());
    }

    private void initGroupMod() {
        manager.driver.findElement(By.xpath("//input[@name='edit'][1]")).click();
    }

    private void selectGroup() {
        manager.driver.findElement(By.xpath("//input[@type='checkbox']"));
    }
}
