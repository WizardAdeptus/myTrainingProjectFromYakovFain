package info.introToJava.annotation;

@DBParams(dbName = "Students", password = "mysecret", uid = 108)
public class MyDBWorker  {

    void startDB(){
        System.out.println("starting database...");
    }
}
