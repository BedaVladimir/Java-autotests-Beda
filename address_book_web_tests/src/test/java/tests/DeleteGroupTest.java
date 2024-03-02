package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroupTest() {
        if (app.groups().getGroupCount() == 0) {
            app.groups().createGroup(new GroupData("Name1", "TXT", "comment"));
        }
        int groupCountBef = app.groups().getGroupCount();
        app.groups().deleteGroup();
        int groupCountAft = app.groups().getGroupCount();
        Assertions.assertEquals(groupCountBef - 1, groupCountAft);
    }
    @Test
    public void deleteAllGroupsTest() {
        if (app.groups().getGroupCount() == 0) {
            app.groups().createGroup(new GroupData("Name1", "TXT", "comment"));
        }
        app.groups().deleteAllGroups();
        Assertions.assertEquals(0, app.groups().getGroupCount());
    }
}

