package jdbc;

import java.sql.*;
/**
 * Created by Zubo Gu on 8/24/2017.
 */
public class TestOrcaleConnection {

    static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String username = "system";
    static final String password = "root";
    public static void main(String[] args) throws SQLException {
        // write your code here
        Connection conn = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("Success connect to oracle database " + conn);
    }
}
