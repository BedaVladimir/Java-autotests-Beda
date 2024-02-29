package tests;
import model.ContactData;
import org.junit.jupiter.api.Test;

public class CreateContactTest extends TestBase{
    @Test
    public void createContactTest() {
        app.contact().clickContactLink();
        app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                .withAddress("Lenin Street"));
    }
}
