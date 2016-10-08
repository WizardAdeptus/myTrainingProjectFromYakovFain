package info.introToJava.jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCTest {

    public static void main(String[] args) {

        Connection connection = null;

        String url = "jdbc:postgresql://127.0.0.1:5432/test";
        String name = "user";
        String password = "123456";
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");

            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery("SELECT * FROM users where id >2 and id <10");

            System.out.println("Выводим statement");
            while (result1.next()) {
                System.out.println("Номер в выборке #" + result1.getRow()
                        + "\t Номер в базе #" + result1.getInt("id")
                        + "\t" + result1.getString("username"));
            }

            // Вставить запись
            statement.executeUpdate(
                    "INSERT INTO users(username) values('name')");
            //Обновить запись
            statement.executeUpdate(
                    "UPDATE users SET username = 'admin' where id = 1");

            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users where id > ? and id < ?");
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 10);

            //выполняем запрос
            ResultSet result2 = preparedStatement.executeQuery();

            System.out.println("Выводим PreparedStatement");
            while (result2.next()) {
                System.out.println("Номер в выборке #" + result2.getRow()
                        + "\t Номер в базе #" + result2.getInt("id")
                        + "\t" + result2.getString("username"));
            }

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO users(username) values(?)");
            preparedStatement.setString(1, "user_name");
            preparedStatement.executeUpdate();

            CallableStatement callableStatement = null;

            //Вызываем функцию myFunc (хранится в БД)
            callableStatement = connection.prepareCall(
                    " { call myfunc(?,?) } ");

            //Задаём входные параметры
            callableStatement.setString(1, "Dima");
            callableStatement.setString(2, "Alex");

            //Выполняем запрос
            ResultSet result3 = callableStatement.executeQuery();

            //Если CallableStatement возвращает несколько объектов ResultSet,
            //то нужно выводить данные в цикле с помощью метода next
            //у меня функция возвращает один объект
            result3.next();
            System.out.println(result3.getString("MESSAGE"));
            //если функция вставляет или обновляет, то используется метод executeUpdate()

        } catch (Exception ex) {
            Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}