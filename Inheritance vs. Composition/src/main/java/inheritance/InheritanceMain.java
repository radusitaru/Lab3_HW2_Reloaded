package inheritance;

import java.io.IOException;
import java.util.Scanner;

public class InheritanceMain {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String personProvider = sc.nextLine();

        if (personProvider.equalsIgnoreCase("fromfile")) {
            var generator = new FileReportGenerator();
            generator.setSourceFile("src/main/resources/people.txt");
            generator.generateReport("src/main/resources/output-file-inheritance.txt");
        }
        if (personProvider.equalsIgnoreCase("frommemory")) {
            var generator = new InMemoryReportGenerator();
            generator.generateReport("src/main/resources/output-memory-inheritance.txt");
        }
    }
}