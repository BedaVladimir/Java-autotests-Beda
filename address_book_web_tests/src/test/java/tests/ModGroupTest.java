package tests;
import model.GroupData;
import org.junit.jupiter.api.Test;

public class ModGroupTest extends TestBase{

    @Test
    public void modGroupTest() {
        if (app.groups().getGroupCount() == 0) {
            app.groups().createGroup(new GroupData("", "Name1", "TXT", "comment"));
        }
        app.groups().modifyGroups(new GroupData().withName("Mod Group"));
    }
}
