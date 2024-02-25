import org.junit.jupiter.api.Test;

public class DeleteGroupTest extends TestBase {

    @Test
    public void deleteGroupTest() {
        clickLinkGroup();
        if (isGroupPresent()) {
            createGroup("Name1", "TXT", "comment");
        }
        deleteGroup();
    }
}

