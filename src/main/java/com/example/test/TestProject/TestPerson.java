package com.example.test.TestProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestPerson {

    private int x = 10;
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("Charles","Dickens",60);
        Person p2 = new Person("Lewis","Carol",42);
        Person p3 = new Person("Thomas","Carlyle",51);
        Person p4 = new Person("Charlotte","Bronte",45);
        Person p5 = new Person("Mathew","Arnold",39);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);


//  sortListByLastname(people,(person1,person2)->person1.getLastName().compareTo(person2.getLastName()));
//
//        System.out.println("List after sorting based on last name");
//        System.out.println(people);
//
//        LastNameC lastNameC = (peopleList) -> {
//            for(Person person: peopleList) {
//                if(person.getLastName().startsWith("C"))
//                    System.out.println(person);
//            }
//        };
//
//        System.out.println("printing persons with last name C");
//        printPersonsWithLastNameC(people,lastNameC);

    }
    public void doSomething() {
        Process process = (y) -> {
            int x =15;
            return x+1;
        };
    }
    public static List<Person> sortListByLastname(List<Person> people, Comparator<Person> personComparator) {
        Collections.sort(people,personComparator);
        return people;
    }

    public static void printPersonsWithLastNameC(List<Person> people, LastNameC lastNameC) {
        lastNameC.printPersonsWithLastNameC(people);
    }
}

interface LastNameC {
    void printPersonsWithLastNameC(List<Person> people);
}

interface Process {
    int doProcess(int a);
}