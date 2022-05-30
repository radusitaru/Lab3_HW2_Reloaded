package composition;

import person.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;


public class PersonReportGenerator {


    public void generateReport(PersonProvider provider, String outputFile) throws IOException {
        List<Person> people = provider.readPeople();
        generateReport(people, outputFile);
    }

    private void generateReport(List<Person> people, String outputFile) throws IOException {

        Map<String, List<String>> groupNames = people.stream()
                .collect((groupingBy(Person::getAgeGroup, mapping(Person::getFullName, toList()))));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writeLine(writer, groupNames);
        }
    }


    private void writeLine(BufferedWriter writer, Map<String, List<String>> groupNames) {
        try {
            writer.write(groupNames.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
