package tests;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;


public class CreateGroupTest extends TestBase {
    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("test name", "", ""),
                new GroupData(),
                new GroupData().withName("Name test").withHeader("Test").withFooter("Test")));
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }

    @Test
    public void createGroupTest() {
        int groupCountBef = app.groups().getGroupCount();
        app.groups().createGroup(new GroupData("Test name", "Test header", "Test footer"));
        int groupCountAft = app.groups().getGroupCount();
        Assertions.assertEquals(groupCountBef + 1, groupCountAft);
    }
    @ParameterizedTest
    @MethodSource("groupProvider")
    public void createMultipleGroups(GroupData group) {
        int groupCountBef = app.groups().getGroupCount();
        app.groups().createGroup(group);
        int groupCountAft = app.groups().getGroupCount();
        Assertions.assertEquals(groupCountBef + 1, groupCountAft);
    }
}
