package tests;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CreateGroupTest extends TestBase {
    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
        //var result = new ArrayList<GroupData>(List.of(
                //        new GroupData("", "test name", "", ""),
                //        new GroupData(),
        //        new GroupData().withName("Name test").withHeader("Test").withFooter("Test")));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<GroupData>>() {});
        result.addAll(value);
        return result;
    }

    @Test
    public void createGroupTest() {
        app.groups().clickLinkGroup();
        var oldGroups = app.groups().getGroupList();
        app.groups().createGroup(new GroupData("", "Test name", "Test header", "Test footer"));
        var newGroups = app.groups().getGroupList();
        //var expectGroups = oldGroups.add(newGroups.get(2));
        //Assertions.assertEquals(expectGroups, newGroups);
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
