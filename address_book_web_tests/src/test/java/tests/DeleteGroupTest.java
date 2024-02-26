package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroupTest() {
        app.clickLinkGroup();
        if (app.isGroupPresent()) {
            app.createGroup(new GroupData("Name1", "TXT", "comment"));
        }
        app.deleteGroup();
    }
}

