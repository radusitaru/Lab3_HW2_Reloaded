package inheritance;

import PersonClass.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class PersonReportGenerator {
    public abstract List<Person> readPeople();

    protected String source;

    public void generateReport(String outputFile) throws IOException {
        List<Person> people = readPeople();
        generateReport(people, outputFile);
    }

    private void generateReport(List<Person> people, String outputFile) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            people.stream()
                    .map(person -> person.getAgeGroup() + " : " + person.getLastName() + " " + person.getFirstName())
                    .forEach(line -> writeLine(writer, line));
        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
