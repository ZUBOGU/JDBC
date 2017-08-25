package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by Zubo Gu on 8/24/2017.
 */
public class DBUtil {

    static final String oraCS = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String oraUser = "hr";
    static final String oraPed = "password";

    static final String mySqlUser = "root";
    static final String mySqlPwd = "root";
    static final String mySQLCS = "jdbc:mysql://localhost:3306/world";

    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType) {
            case ORADB:
                return DriverManager.getConnection(oraCS, oraUser, oraPed);
            case MYSQLDB:
                return DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
            default:
                return null;
        }
    }

    public static void showErrorMessage(SQLException e) {
        System.err.println("Error : " + e.getMessage());
        System.err.println("Error Code : " + e.getErrorCode());
    }
}
