package org.sbt.mrx.commonTask;

import org.sbt.mrx.commonTask.model.Person;
import org.sbt.mrx.commonTask.service.PersonService;

import java.io.IOException;
import java.util.*;

public class Task7_8 {

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;

        MenuItem(String name, Exec exec) {
            this.name = name;
            this.exec = exec;
        }

    }

    private static class Menu {

        private Scanner scanner;
        private List<MenuItem> items;


        private Menu(Scanner scanner) {
            this.scanner = scanner;
            items = new ArrayList<>();


            items.add(new MenuItem("add", (personList) -> {
                Person p = new Person();
                System.out.println("Write First name:");
                p.setFirstName(scanner.next());
                System.out.println("Write Second name:");
                p.setSecondName(scanner.next());
                personList.add(p);
            }));

            items.add(new MenuItem("show", (personList) -> {
                if (personList.size() == 0)
                    System.out.println("List is empty");
                else
                    personList.forEach(System.out::println);
            }));

            items.add(new MenuItem("sort", (personList) -> {
                TreeSet<Person> set = new TreeSet<>(Person::compareTo);
                set.addAll(personList);
                System.out.println(set);
            }));

            items.add(new MenuItem("save", (personList) -> {
                if (personList.size() != 0) {
                    try{
                        PersonService.saveToFile(personList);
                    } catch (IOException e){
                        System.out.println("Unable to write");
                    }
                } else {
                    System.out.println("List is empty");
                }
            }));

            items.add(new MenuItem("read", (personList) -> {
                try{
                    personList.clear();
                    personList.addAll(PersonService.readFromFile());
                } catch (IOException e){
                    System.out.println("Unable to read");
                }
            }));

        }


        public void getItem(List<Person> personList) throws Exception {
            loop : while (true) {
                System.out.println("=======================");
                System.out.println("0 - exit");
                System.out.println("1 - create new Person from console");
                System.out.println("2 - print list");
                System.out.println("3 - sort unique by secondName");
                System.out.println("4 - save to file");
                System.out.println("5 - read from file");
                System.out.println("6 - clear data in memory");

                switch (scanner.nextLine()) {
                    case "0":
                        break loop;
                    case "1":
                        items.get(0).exec.exec(personList);
                        break;
                    case "2":
                        items.get(1).exec.exec(personList);
                        break;
                    case "3":
                        items.get(2).exec.exec(personList);
                        break;
                    case "4":
                        items.get(3).exec.exec(personList);
                        break;
                    case "5":
                        items.get(4).exec.exec(personList);
                        break;
                    case "6":
                        personList.clear();
                        System.out.println("data was cleared");
                        break;
                    default:
                        System.out.println("Unable action");
                        break;
                }
            }
        }

    }


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        try {
            menu.getItem(personList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
