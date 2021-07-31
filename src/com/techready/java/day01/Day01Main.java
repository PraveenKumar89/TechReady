package com.techready.java.day01;

import com.techready.java.day01.casestudy.GlobalToken;
import com.techready.java.day01.example01.Add;
import com.techready.java.day01.example01.Computation;
import com.techready.java.day01.example01.MathOperator;
import com.techready.java.day01.example02.CheckPerson;
import com.techready.java.day01.example02.Person;
import com.techready.java.day01.example02.PersonUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Day01Main {
    public static void main(String[] args) {
        MathOperator<Integer> normalAdd = new Add();

        MathOperator<Integer> anonymousAdd = new MathOperator<Integer>() {
            @Override
            public Integer compute(Integer a, Integer b) {
                return a + b;
            }
        };

        MathOperator<Integer> addLambda = (x, y) -> x + y;

        MathOperator<Double> multiply = (x, y) -> x * y;

        MathOperator<Double> divide = (x, y) -> x / y;

        Computation<Integer> i = new Computation<>();

        Computation<Double> m = new Computation<>();

        System.out.println(i.operate(10, 20, normalAdd));

        System.out.println(i.operate(10, 20, anonymousAdd));

        System.out.println(i.operate(10, 20, addLambda));

        System.out.println(m.operate(10.0, 20.0, multiply));

        System.out.println(m.operate(40.0, 8.0, divide));

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

        CheckPerson maleGreaterThan25 = (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() > 25;

        PersonUtil.printPersons(personList, maleGreaterThan25);

        PersonUtil.printPersons(personList,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() > 25);

        System.out.println(GlobalToken.MY_TOKEN.getRandomNumber(10, 20));
    }
}
