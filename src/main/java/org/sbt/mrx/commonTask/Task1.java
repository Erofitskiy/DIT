package org.sbt.mrx.commonTask;

import org.sbt.mrx.commonTask.model.Person;

public class Task1 {
    public static void main(String[] args) throws Exception {
        if (args.length != 2)
            throw new Exception("2 args expected");
        Person p = new Person(args[0], args[1]);
        System.out.println(p.getFirstName() + " " + p.getSecondName());





    }
}
