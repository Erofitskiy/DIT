package org.sbt.mrx.commonTask.service;

import org.sbt.mrx.commonTask.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    public static void saveToFile(List<Person> list) throws IOException {
        Writer wr = new FileWriter("src/main/resources/persons.txt");
        for (Person p : list)
            wr.write(p.getFirstName() + " " + p.getSecondName() + "\n");
        wr.flush();
        wr.close();
    }

    public static List<Person> readFromFile() throws FileNotFoundException {
        List<Person> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/main/resources/persons.txt"));
        while(scanner.hasNextLine())
            list.add(new Person(scanner.next(), scanner.next()));
        return list;
    }
}
