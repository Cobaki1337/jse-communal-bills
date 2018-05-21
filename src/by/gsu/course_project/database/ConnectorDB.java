package by.gsu.course_project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static by.gsu.course_project.database.DBConstants.*;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle(DATABASE_FILE);
        String url = rb.getString(URL);
        String user = rb.getString(USER);
        String password = rb.getString(PASSWORD);
        return DriverManager.getConnection(url, user, password);
    }
}
