package composition;

import person.Person;

import java.util.List;

public interface PersonProvider {

    List<Person> readPeople();
}
