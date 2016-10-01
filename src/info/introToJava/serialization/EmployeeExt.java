package info.introToJava.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class EmployeeExt implements Externalizable {
    private String lName;
    private String fName;
    private String address;
    private int id;
    private double salary;

    public EmployeeExt(String lName, String fName, String address, int id, double salary) {
        this.lName = lName;
        this.fName = fName;
        this.address = address;
        this.id = id;
        this.salary = salary;
    }

    public void writeExternal(ObjectOutput stream)
            throws IOException {
        // Serializing only the salary and id
        stream.writeDouble(salary);
        stream.writeInt(id);
    }

    public void readExternal(ObjectInput stream)
            throws IOException {
        // Read fields in the same order as they were written
        salary = stream.readDouble();
        id = stream.readInt();
    }
}
