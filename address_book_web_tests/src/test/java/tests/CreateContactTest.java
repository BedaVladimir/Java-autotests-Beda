package tests;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateContactTest extends TestBase{
    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        //var result = new ArrayList<ContactData>(List.of(
                //        new ContactData(),
                //        new ContactData().withFirstName("Test"),
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {});
        result.addAll(value);
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
