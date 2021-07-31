package com.techready.java.day02;

import com.techready.java.day01.example02.Person;
import com.techready.java.day01.example02.PersonUtil;
import com.techready.java.day02.example01.Address;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Day02Main {
    public static void main(String[] args) throws InterruptedException {

        Date oldDate = new Date();

        Supplier<Date> now = () -> new Date();
        System.out.println(now.get());
        Thread.sleep(2000);
        System.out.println(now.get());

        System.out.println("Old Date --- " + oldDate);
        Thread.sleep(2000);
        System.out.println("Old Date --- " + oldDate);

        Address address = new Address("Bangalore", "Karnataka", "India", "560100");

        Consumer<Address> addressConsumer = (Address a) -> System.out.println(a.getCity() + ", " + a.getZipCode());

        addressConsumer.accept(address);

        Person person = new Person("Test", Person.Sex.MALE,  LocalDate.of(1990, 12, 23), "test@test.com");
        person.setAddress(address);

        Consumer<Person> personConsumer = (Person p) -> System.out.println(p.getName() + ", " + p.getEmail());

        Consumer<Person> printPersonAddress = (Person p) -> System.out.println(p.getAddress().getCity());

        personConsumer
                .andThen(printPersonAddress)
                .andThen(personConsumer)
                .accept(person);

        Person alice = new Person("Alice", Person.Sex.FEMALE, LocalDate.of(1990, 12, 23), "alice@test.com");
        Person bob = new Person("Bob", Person.Sex.MALE, LocalDate.of(1970, 3, 11), "bob@test.com");
        Person charlie = new Person("Charlie", Person.Sex.MALE, LocalDate.of(1960, 7, 16), "charlie@test.com");
        Person delta = new Person("Delta", Person.Sex.FEMALE, LocalDate.of(2000, 5, 26), "delta@test.com");
        Person emma = new Person("Emma", Person.Sex.FEMALE, LocalDate.of(2007, 9, 20), "emma@test.com");

        List<Person> personList = new ArrayList<>();
        personList.add(alice);
        personList.add(bob);
        personList.add(charlie);
        personList.add(delta);
        personList.add(emma);

        Predicate<Person> isMale = (Person p) -> p.getGender() == Person.Sex.MALE;
        Predicate<Person> above25 = (Person p) -> p.getAge() > 25;
        Predicate<Person> below25 = (Person p) -> p.getAge() < 25;

        Predicate<Person> maleAbove25 = isMale.and(above25);

        PersonUtil.printPersonsWithPredicate(personList, maleAbove25);

        Supplier<List<Person>> personSupplier = () -> personList;

        PersonUtil.processPerson(
                personSupplier,
                maleAbove25,
                (Person p) -> p.getEmail(),
                (email -> System.out.println(email)));
    }
}
