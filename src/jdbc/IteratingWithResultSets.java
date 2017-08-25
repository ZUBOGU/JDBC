package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Zubo Gu on 8/24/2017.
 */
public class IteratingWithResultSets {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection(DBType.ORADB);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from Employees");
            String format = "%-4s%-20s%-25s%-10f\n";

            while (rs.next()) {
                System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));
            }

        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
        finally {
            if (stmt != null) rs.close();
            if (rs != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}
