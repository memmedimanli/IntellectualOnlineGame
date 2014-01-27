/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import net.iog.domain.User;

/**
 *
 * @author memmedimanli
 */
public class MySqlConfirmDao {

    private static DataSource dataSource;

    public MySqlConfirmDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static boolean confirm(String username, String email) throws SQLException {

        boolean success = false;

        Connection con = null;
        PreparedStatement ps = null;

        try {
           // con = dataSource.getConnection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_nhn", "root", "100105018");  
            ps = connection.prepareStatement(SqlQuery.CONFIRM_EMAIL);
            ps.setString(1, username);
            ps.setString(2, email);

            int count = ps.executeUpdate();
            if (count == 1) {
                success = true;
            }

            connection.commit();

        } catch (Exception ex) {

               // con.rollback();
             ex.printStackTrace();

        } finally {
            DatabaseUtility.close(null, ps, con);
        }

        return success;
    }
}
