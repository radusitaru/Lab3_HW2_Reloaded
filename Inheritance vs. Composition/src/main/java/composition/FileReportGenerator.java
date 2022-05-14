package composition;

import PersonClass.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReportGenerator implements personProvider {



    @Override
    public List<Person> readPeople() {
        try {
            return Files.lines(Path.of("src/main/resources/people.txt"))
                    .map(this::toPerson)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Person toPerson(String line) {
        String[] tokens = line.split("\\,");
        return new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
    }
}
