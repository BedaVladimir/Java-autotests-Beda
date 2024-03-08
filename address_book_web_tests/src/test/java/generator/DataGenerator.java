package generator;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataGenerator {

    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-c"})
    int count;

    public static void main(String[] args) throws IOException {
        var generator = new DataGenerator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)) { return generateGroups(); }
        else if ("contacts".equals(type)) { return generateContacts(); }
        else { throw new IllegalArgumentException("Неправильный тип запроса");}
    }

    private Object generateContacts() {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            result.add(new ContactData("", CommonFunctions.randomString(i * 10),
                    CommonFunctions.randomString(i * 10), CommonFunctions.randomString(i * 10),
                    CommonFunctions.randomString(i * 10), CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData("", CommonFunctions.randomString(i * 10),
                    CommonFunctions.randomString(i * 10),
                    CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    private void save(Object data) throws IOException {
        if("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);

            try (var writer = new FileWriter(output)) {
            writer.write(json);
            }
        } else {
            throw new IllegalArgumentException("Только формат JSON");
        }
    }
}
