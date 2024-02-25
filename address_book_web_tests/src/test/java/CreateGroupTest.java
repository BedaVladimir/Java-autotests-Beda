import org.junit.jupiter.api.Test;

public class CreateGroupTest extends TestBase {
    @Test
    public void createGroupTest() {
        createGroup("Test name", "Test header","Test footer");
    }

}
