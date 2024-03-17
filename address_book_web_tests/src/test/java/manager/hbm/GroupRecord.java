package manager.hbm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name="group_list")
@Entity
public class GroupRecord {
    @Id
    @Column(name = "group_id")
    public int id;
    @Column(name = "group_name")
    public String name;
    @Column(name = "group_header")
    public String header;
    @Column(name = "group_footer")
    public String group_footer;
}
