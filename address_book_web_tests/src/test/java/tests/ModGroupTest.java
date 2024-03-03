package tests;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ModGroupTest extends TestBase{

    @Test
    public void modGroupTest() {
        if (app.groups().getGroupCount() == 0) {
            app.groups().createGroup(new GroupData("", "Name1", "TXT", "comment"));
        }
        var oldGroups = app.groups().getGroupList();
        var index = new Random().nextInt(oldGroups.size());
        var testData = new GroupData().withName("Mod Group");
        app.groups().modifyGroups(oldGroups.get(index), testData);
        var newGroups = app.groups().getGroupList();
        var expectList = new ArrayList<>(oldGroups);
        expectList.set(index, testData.withId((oldGroups.get(index).id())));
        Comparator<GroupData> dataComparator = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(dataComparator);
        expectList.sort(dataComparator);
        Assertions.assertEquals(newGroups, expectList);

    }
}
