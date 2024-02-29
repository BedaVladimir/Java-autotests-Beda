package tests;
import model.ContactData;
import org.junit.jupiter.api.Test;

public class DeleteContactTest extends TestBase{
    @Test
    public void deleteContactTest() {
        if (app.contact().isContactPresent()) {
            app.contact().clickContactLink();
            app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                    .withAddress("Lenin Street"));
        }
        app.contact().deleteContact();
    }
}
