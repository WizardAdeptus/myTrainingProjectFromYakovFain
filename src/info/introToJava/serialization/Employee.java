package info.introToJava.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    private String lName;
    private String fName;
    private transient double salary;

    public Employee(String lName, String fName, double salary) {
        this.lName = lName;
        this.fName = fName;
        this.salary = salary;
    }
}
