package tests;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateGroupTest extends TestBase {
    @Test
    public void createGroupTest() {
        int groupCountBef = app.groups().getGroupCount();
        app.groups().createGroup(new GroupData("Test name", "Test header", "Test footer"));
        int groupCountAft = app.groups().getGroupCount();
        Assertions.assertEquals(groupCountBef + 1, groupCountAft);
    }
}
