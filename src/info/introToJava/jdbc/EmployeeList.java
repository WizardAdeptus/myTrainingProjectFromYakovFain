package info.introToJava.jdbc;

import java.sql.*;

public class EmployeeList {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

            // Create a Statement object
            statement = connection.createStatement();

            // Execute SQL and get obtain the Result object
            resultSet = statement.executeQuery("SELECT * FROM Employee");

            // Process the result set - print Employees
            while (resultSet.next()) {
                int empNo = resultSet.getInt("EMPNO");
                String eName = resultSet.getString("ENAME");
                String job = resultSet.getString("JOB_TITLE");
                System.out.println(empNo + ", " + eName + ", " + job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // clean up the system resources
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
