package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection {
    String userName = "root";
    String password = "";
    String dbName = "studentmis";

    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        return con;

    }
}

