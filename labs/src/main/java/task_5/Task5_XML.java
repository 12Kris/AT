package task_5;

/*
a) Make some complex models using your variant.
b) Make it serializable.
c) Read JSON from “input.json”
d) and deserialize it to POJO.
e) Then change a few fields and save it to “output.json”.
f) Do the same for XML.
*/

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Task5_XML {
    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            File inputXML = new File("src/main/resources/task_5/input.xml");
            File outputXML = new File("src/main/resources/task_5/output.xml");

            Person person = xmlMapper.readValue(Files.readString(inputXML.getAbsoluteFile().toPath()),  Person.class);

            System.out.println(person);
            person.setName("Bogdan");
//            person.isWorking(false);
            person.setTimestamp(Long.parseLong("48881846835"));
            List<String> friends = Arrays.asList("Oleg", "Yana", "Olena");
            person.setFriends(friends);
            System.out.println(person);

            xmlMapper.writeValue(outputXML, person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
