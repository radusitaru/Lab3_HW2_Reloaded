package inheritance;

import person.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReportGenerator extends PersonReportGenerator {

    public void setSourceFile(String sourceFile) {
        this.source = sourceFile;
    }

    @Override
    public List<Person> readPeople() {
        try {
            return Files.lines(Path.of(source))
                    .map(this::toPerson)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Person toPerson(String line) {
        String[] tokens = line.split("\\,");
        return new Person(tokens[0], tokens[1],Integer.parseInt(tokens[2]));
    }
}
