package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Zubo Gu on 8/24/2017.
 */
public class ResultSetScrollingDemo {

    public static void main(String[] args) throws SQLException {
        try (
            Connection conn = DBUtil.getConnection(DBType.ORADB);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select * from EMPLOYEES Where Rownum <= 10");
        )
        {   String format = "%-4s%-20s%-25s%-10f\n";
            rs.beforeFirst();
            System.out.println("First 10 Rows :  ");
            while (rs.next()) {
                System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));            }

            rs.afterLast();
            System.out.println("Last 10 Rows :  ");
            while (rs.previous()) {
                System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));
            }

            rs.first();
            System.out.println("First Record : ");
            System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));

            rs.last();
            System.out.println("Last Record : ");
            System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));

            rs.absolute(4);
            System.out.println("Record at 4th row : ");
            System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));

            rs.relative(2);
            System.out.println("Record at 6th row : ");
            System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));

            rs.relative(-4);
            System.out.println("Record at 2th row : ");
            System.out.format(format, rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),rs.getFloat("SALARY"));

        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }

    }
}
