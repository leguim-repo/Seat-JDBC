package jdbc.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaMySQLBasic {
    Connection connection;

    public Connection connectDatabase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:33060/",
                    "root",
                    "secret");

            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");

        } catch (SQLException exception) {
            System.out.println("Error: " + exception);
        }

        return connection;
    }
}
