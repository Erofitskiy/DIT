package org.sbt.mrx.commonTask;

import org.sbt.mrx.commonTask.model.Person;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Person p = new Person();
        System.out.println("Write First name:");
        p.setFirstName(sc.nextLine());

        System.out.println("Write Second name:");
        p.setSecondName(sc.nextLine());

        System.out.println("Result : " + p.getFirstName() + " " + p.getSecondName());
        sc.close();
    }
}
