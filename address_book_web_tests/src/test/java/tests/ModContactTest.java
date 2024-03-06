package tests;
import model.ContactData;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import org.junit.jupiter.api.Assertions;


public class ModContactTest extends TestBase {

    @Test
    public void modContactTest() {
        if (app.contact().getCountContact() == 0) {
            app.contact().clickContactLink();
            app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                    .withAddress("Lenin Street"));
        }
        var oldContactList = app.contact().getContactList();
        var index = new Random().nextInt(oldContactList.size());
        var testFirstName = new ContactData().withFirstName("Модифицированное значение");
        app.contact().modifyContact(index, testFirstName);
        var newContactList = app.contact().getContactList();
        var expectedContactList = new ArrayList<>(oldContactList);
        expectedContactList.set(index, testFirstName.withId(oldContactList.get(index).id()));
        Comparator<ContactData> dataComparator = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContactList.sort(dataComparator);
        expectedContactList.sort(dataComparator);
        Assertions.assertEquals(newContactList, expectedContactList);
    }
}
