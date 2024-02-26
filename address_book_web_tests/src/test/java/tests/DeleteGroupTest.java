package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroupTest() {
        app.groups().clickLinkGroup();
        if (app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("Name1", "TXT", "comment"));
        }
        app.groups().deleteGroup();
    }
}

