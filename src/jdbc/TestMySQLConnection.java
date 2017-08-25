package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Zubo Gu on 8/24/2017.
 */
public class TestMySQLConnection {

    static final String username = "root";
    static final String password = "root";
    static final String dbUrl = "jdbc:mysql://localhost:3306/world";

    public static void main(String[] args) throws SQLException {
        // write your code here
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println(" Connnet to MySQL database " + conn);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            conn.close();
        }
    }
}
