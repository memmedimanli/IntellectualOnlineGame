/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import net.iog.domain.Forum;

/**
 *
 * @author memmedimanli
 */
public class MySqlForumDao implements ForumDao {

    DataSource dataSource;

    public MySqlForumDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean posted(Forum forum) {

        boolean success = false;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.POST_QUESTION);
            ps.setString(1, forum.getTitle());
            ps.setString(2, forum.getContent());
            ps.setString(3, forum.getAuthor());
            int count = ps.executeUpdate();

            if (count == 1) {
                success = true;
            }

            con.commit();
        } catch (Exception ex) {
            try {
                con.rollback();
                ex.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            DatabaseUtility.close(null, ps, con);
        }

        return success;
    }
}
