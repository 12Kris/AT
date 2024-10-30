package task_5;

/*
a) Make some complex models using your variant.
b) Make it serializable.
c) Read JSON from “input.json”
d) and deserialize it to POJO.
e) Then change a few fields and save it to “output.json”.
f) Do the same for XML.
*/

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Task5_JSON {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File inputJson = new File("src/main/resources/task_5/input.json");
            File outputJson = new File("src/main/resources/task_5/output.json");

            Person person = objectMapper.readValue(Files.readString(inputJson.toPath()), Person.class);

            System.out.println(person);
            person.setName("Anastasia");
            person.setWorking(false);
            person.setTimestamp(Long.parseLong("789586478279"));
            List<String> friends = Arrays.asList("Lilia", "Taras");
            person.setFriends(friends);
            System.out.println(person);
            objectMapper.writeValue(outputJson, person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
