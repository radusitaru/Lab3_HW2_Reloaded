package person;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public record Person(String lastName, String firstName, int age) {

    public int getAge() {
        return age;
    }
    public String getFullName(){
        return firstName+" "+lastName.substring(0,1)+".";
    }

    public static String getAgeGroup(Person person){
        if(person.getAge()<=30&&person.getAge()>0){
            return "Age group: 1-30";
        }
        else if(person.getAge()<=50 && person.getAge()>30){
            return "Age group: 30-50";
        }
        else if(person.getAge()<=150 && person.getAge()>50){
            return "Age group: 50+";
        }
        return "wrong input";
    }
}