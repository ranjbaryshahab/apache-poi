package ir.maktab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        Person shervin = new Person(1L, "Shervin", "Zadsorur", "09999999999");
        Person shahab = new Person(2L, "Shahab", "Ranjbary", "09999999999");
        Person reza = new Person(3L, "Reza", "Dehghani", "09999999999");
        List<Person> persons = new ArrayList<>();
        persons.add(shervin);
        persons.add(shahab);
        persons.add(reza);

        PersonService personService = new PersonService();
        //personService.saveToNewFile(persons);

        //personService.loadAll().forEach(System.out::println);

        //System.out.println(personService.loadById(2));

    }
}
