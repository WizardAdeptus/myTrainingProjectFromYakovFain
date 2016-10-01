package info.introToJava.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassB {
    public static void main(String[] args) {
        Employee employee = null;

        try(
            FileInputStream fIn = new FileInputStream("out\\Employee.ser");
            ObjectInputStream oIn = new ObjectInputStream(fIn)
        ) {
            employee = (Employee)oIn.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("The Employee object has been deserialized from Employee.ser");
    }
}
