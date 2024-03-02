package tests;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteContactTest extends TestBase{
    @Test
    public void deleteContactTest() {
        if (app.contact().getCountContact() == 0) {
            app.contact().clickContactLink();
            app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                    .withAddress("Lenin Street"));
        }
        int countContactBef = app.contact().getCountContact();
        app.contact().deleteContact();
        int countContactAft = app.contact().getCountContact();
        Assertions.assertEquals(countContactBef - 1, countContactAft);
    }
}
