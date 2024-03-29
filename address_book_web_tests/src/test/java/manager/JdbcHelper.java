package manager;
import model.GroupData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends GroupHelper{
    public JdbcHelper(ApplicationManager manager) {super(manager); }
    public List<GroupData> getGroupList() {
        var groups = new ArrayList<GroupData>();
        try (var connect = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = connect.createStatement();
             var result = statement.executeQuery("SELECT * FROM group_list"))
        {
            while (result.next()) {
                groups.add(new GroupData()
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }
}
