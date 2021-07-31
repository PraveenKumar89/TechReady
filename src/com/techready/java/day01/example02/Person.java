package com.techready.java.day01.example02;

import com.techready.java.day02.example01.Address;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }
    public Person(String name, Sex gender, LocalDate birthday, String email) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
    }
    String name;
    LocalDate birthday;
    Sex gender;
    String email;
    Address address;

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Period.between(birthday, now).getYears();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getName() { return name; }

    public void printPerson() {
        System.out.println("[ " + this.name + ", " + this.gender + ", " + this.birthday + "," + email + " ]");
    }
}
