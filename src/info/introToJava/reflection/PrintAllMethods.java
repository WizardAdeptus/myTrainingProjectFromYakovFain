package info.introToJava.reflection;

import java.lang.reflect.Method;

public class PrintAllMethods {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("java.lang.Class");
            Method methods[] = c.getMethods();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
