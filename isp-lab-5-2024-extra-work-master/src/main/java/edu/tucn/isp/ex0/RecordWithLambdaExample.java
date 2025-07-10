package edu.tucn.isp.ex0;

import java.util.function.Predicate;

/**
 * @author Radu Miron
 */

record Person(String firstName, String lastName, int age) {
}

public class RecordWithLambdaExample {
    private static final String JOHNSON = "Johnson";
    private static final String JANE = "Jane";

    public static void main(String[] args) {
        Person[] people = {
                new Person("John", "Doe", 25),
                new Person(JANE, "Doe", 26),
                new Person("John", JOHNSON, 27),
                new Person(JANE, JOHNSON, 28),
                new Person("Jim", "Cramer", 29),
                new Person("Kim", "Costelo", 30),
        };

        // filter by last name
        Predicate<Person> filterByLastName = person -> JOHNSON.equals(person.lastName());
        System.out.println("Persons with last name " + JOHNSON);
        displayFilteredPersons(people, filterByLastName);

        // filter by first name and age
        System.out.printf("Persons with last name %s and age > 27\n", JANE);
        displayFilteredPersons(
                people,
                person -> JANE.equals(person.firstName()) && person.age() > 27);

    }

    public static void displayFilteredPersons(Person[] people, Predicate<Person> filter) {
        for (Person person : people) {
            if (filter.test(person)) {
                System.out.println(person);
            }
        }

        //alternative implementation
//        Arrays.stream(people)
//                .filter(filter)
//                .forEach(System.out::println);
//
        System.out.println();
    }
}