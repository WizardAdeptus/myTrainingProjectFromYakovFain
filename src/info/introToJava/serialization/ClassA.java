package info.introToJava.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClassA {
    public static void main(String[] args) {
        Employee employee = new Employee("Ivan", "Ivanov", 1000);

        try (
            FileOutputStream fOut = new FileOutputStream("out\\Employee.ser");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut)
        ){
            oOut.writeObject(employee);
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("The Employee object has been serialized into Employee.ser");
    }
}
