package jdbc;

import java.sql.*;

/**
 * Created by Zubo Gu on 8/24/2017.
 */
public class TestManageDBResource {

    public static void main(String[] args) throws SQLException {
        // write your code here
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //conn = DriverManager.getConnection(dbUrl, username, password);
            conn = DBUtil.getConnection(DBType.MYSQLDB);
            System.out.println(" Connnet to MySQL database " + conn);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("select * from Country");
            rs.last();
            System.out.println("Total No. of Rows :" +rs.getRow());

        } catch (SQLException e) {
            // System.err.println(e.getMessage());
            DBUtil.showErrorMessage(e);
        }
        finally {
            if (stmt != null) rs.close();
            if (rs != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}
