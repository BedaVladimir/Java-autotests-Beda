package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class CreateGroupTest extends TestBase {
    @Test
    public void createGroupTest() {
        app.groups().createGroup(new GroupData("Test name", "Test header", "Test footer"));
        //createGroup(new GroupData().withName("Test"));
    }
}
