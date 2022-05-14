package PersonClass;

public class Person {


    public Person(String firstName, String lastName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        setAgeGroup();
    }

    private final String lastName;
    private final String firstName;
    private final int age;
    private String ageGroup;

    public String getAgeGroup() {
        return ageGroup;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setAgeGroup() {
        if (age >= 0 && age <= 30) {
            ageGroup = "1-30";
        } else if (age > 30 && age <= 50) {
            ageGroup = "30-50";
        } else if (age > 50) {
            ageGroup = "50+";
        }
    }
}
