package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateContactTest extends TestBase{
    @Test
    public void createContactTest() {
        int countContactBef = app.contact().getCountContact();
        app.contact().clickContactLink();
        app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                .withAddress("Lenin Street"));
        int countContactAft = app.contact().getCountContact();
        Assertions.assertEquals(countContactBef + 1, countContactAft);
    }
}
