package composition;

import java.io.IOException;
import java.util.Scanner;

public class CompositionMain {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String personProvider = sc.nextLine();

        if (personProvider.equalsIgnoreCase("fromfile")) {
            PersonReportGenerator generator = new PersonReportGenerator();
            generator.generateReport(new FileReportGenerator(), "src/main/resources/output-file-composition.txt");

        }
        if (personProvider.equalsIgnoreCase("frommemory")) {
            PersonReportGenerator generator = new PersonReportGenerator();
            generator.generateReport(new InMemoryReportGenerator(), "src/main/resources/output-memory-composition.txt");
        }
    }
}