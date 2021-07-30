package org.sbt.mrx.commonTask;

import org.sbt.mrx.commonTask.service.PersonService;
import org.sbt.mrx.commonTask.model.Person;

import java.io.IOException;
import java.util.*;

public class Task3_4_5_6 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String action = "";

        loop : while (true){
            System.out.println("=======================");
            System.out.println("0 - exit");
            System.out.println("1 - create new Person from console");
            System.out.println("2 - print list");
            System.out.println("3 - sort unique by secondName");
            System.out.println("4 - save to file");

            action = scanner.next();
            switch (action){
                case "-":
                    list.add(new Person("a", "zb"));
                    list.add(new Person("42a", "hgh"));
                    list.add(new Person("a", "hgh"));
                    list.add(new Person("1a", "akol"));
                    list.add(new Person("a32", "qwerdes"));
                    break;
                case "0":
                    break loop;
                case "1":
                    Person p = new Person();
                    System.out.println("Write First name:");
                    p.setFirstName(scanner.next());
                    System.out.println("Write Second name:");
                    p.setSecondName(scanner.next());
                    list.add(p);
                    break;
                case "2":
                    for (Person person : list)
                        System.out.println(person);
                    break;
                case "3":
                    TreeSet<Person> set = new TreeSet<>(Person::compareTo);
                    set.addAll(list);
                    list = new ArrayList<>(set);
                    break;
                case "4":
                    try{
                        PersonService.saveToFile(list);
                    } catch (IOException e){
                        System.out.println("Unable to write");
                    }
                    break;
                default:
                    System.out.println("Wrong action");
            }


        }

        scanner.close();
    }
}
