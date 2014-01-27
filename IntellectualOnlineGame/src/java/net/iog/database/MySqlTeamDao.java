
package net.iog.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import net.iog.domain.TeamRegistration;
import net.iog.utility.EncryptionUtility;

/**
 *
 * @author memmedimanli
 */
public class MySqlTeamDao implements TeamDao {

    private DataSource dataSource;

    public MySqlTeamDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isUniqueTeamName(String teamName) {
        boolean unique = true;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.CHECK_TEAMNAME);
            ps.setString(1, teamName);
            rs = ps.executeQuery();
            if (rs.next()) {
                unique = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtility.close(rs, null, con);
        }

        return unique;
    }

    @Override
    public boolean registerTeam(TeamRegistration team) {

        boolean success = false;

        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.REGISTER_TEAM);
            ps.setString(1, team.getTeamName());
            int count = ps.executeUpdate();
            
            if (count == 1) {
                success = true;
            }

            con.commit();
        } catch (Exception e) {
            try {
                 if (con.getAutoCommit()) {
                    con.setAutoCommit(false); 
                    con.rollback();
                 }
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DatabaseUtility.close(null, ps, con);
        }

        return success;
    }
}
