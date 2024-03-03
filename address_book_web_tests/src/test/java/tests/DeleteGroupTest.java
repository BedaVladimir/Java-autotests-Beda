package tests;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroupTest() {
        if (app.groups().getGroupCount() == 0) {
            app.groups().createGroup(new GroupData("", "Name1", "TXT", "comment"));
        }
        var oldGroups = app.groups().getGroupList();
        var index = new Random().nextInt(oldGroups.size());
        app.groups().deleteGroup(oldGroups.get(index));
        var newGroups = app.groups().getGroupList();
        var expectList = new ArrayList<>(oldGroups);
        expectList.remove(index);
        Assertions.assertEquals(newGroups, expectList);
    }
    @Test
    public void deleteAllGroupsTest() {
        if (app.groups().getGroupCount() == 0) {
            app.groups().createGroup(new GroupData("", "Name1", "TXT", "comment"));
        }
        app.groups().deleteAllGroups();
        Assertions.assertEquals(0, app.groups().getGroupCount());
    }
}

