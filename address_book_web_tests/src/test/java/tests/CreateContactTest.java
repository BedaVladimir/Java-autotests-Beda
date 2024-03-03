package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class CreateContactTest extends TestBase{
    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData(),
                new ContactData().withFirstName("Test"),
                new ContactData().withLastName("Test"),
                new ContactData().withAddress("Test address"),
                new ContactData().withNumber("Test number"),
                new ContactData().withEmail("Test email")));
        for (int i = 0; i < 3; i++) {
            result.add(new ContactData("", randomString(i * 10), randomString(i * 10), randomString(i * 10),
                    randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }

    @Test
    public void createContactTest() {
        int countContactBef = app.contact().getCountContact();
        app.contact().clickContactLink();
        app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                .withAddress("Lenin Street"));
        int countContactAft = app.contact().getCountContact();
        Assertions.assertEquals(countContactBef + 1, countContactAft);
    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void createMultipleContacts(ContactData contact) {
        int countContactBef = app.contact().getCountContact();
        app.contact().clickContactLink();
        app.contact().createContact(contact);
        int countContactAft = app.contact().getCountContact();
        Assertions.assertEquals(countContactBef + 1, countContactAft);
    }
}
