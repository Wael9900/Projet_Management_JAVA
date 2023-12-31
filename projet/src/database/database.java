
package database;
import java.sql.*;

public class database {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test0", "root", "0000");
    }
    //Connection connection = database.getConnection();
}