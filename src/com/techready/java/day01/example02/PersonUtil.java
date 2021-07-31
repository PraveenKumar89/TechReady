package com.techready.java.day01.example02;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PersonUtil {
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for(Person p: roster) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for(Person p: roster) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPerson(Supplier<List<Person>> roster,
                                     Predicate<Person> tester,
                                     Function<Person, String> transform,
                                     Consumer<String> block
                                    ) {
        for(Person p: roster.get()) {
            if(tester.test(p)) {
                String email = transform.apply(p);
                block.accept(email);
            }
        }
    }
}
