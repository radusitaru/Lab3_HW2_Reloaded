package composition;

import PersonClass.Person;

import java.util.List;

public interface personProvider {

    List<Person> readPeople();
}
