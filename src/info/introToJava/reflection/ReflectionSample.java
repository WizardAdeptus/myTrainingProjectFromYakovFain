package info.introToJava.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSample {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("info.introToJava.reflection.Employee");
            Method method[] = c.getDeclaredMethods();
            System.out.println("The Employee methods:");

            for (int i = 0; i < method.length; i++) {
                System.out.println("*** Method Signature: " + method[i].toString());
            }

            Class superClass = c.getSuperclass();
            System.out.println("The name of superclass is " + superClass.getName());

            Method superMethods[] = superClass.getDeclaredMethods();

            for (int i = 0; i < superMethods.length; i++) {
                System.out.println("*** Method Signature: " + superMethods[i].toString());
                System.out.println("Return type: " + superMethods[i].getReturnType().getName());
            }

            Class parameterTypes[] = new Class[] {String.class};

            @SuppressWarnings("unchecked")
            Method myMethod = c.getMethod("changeAddress", parameterTypes);

            Object arguments[] = new Object[1];
            arguments[0] = "250 Broadway";
            myMethod.invoke(c.newInstance(), arguments);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
