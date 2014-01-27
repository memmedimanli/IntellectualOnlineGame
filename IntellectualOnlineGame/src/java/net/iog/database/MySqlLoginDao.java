/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import net.iog.domain.User;

/**
 *
 * @author memmedimanli
 */
public class MySqlLoginDao implements LoginDao {
    
    private DataSource dataSource;
    
    public MySqlLoginDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Override
    public User login(String username, String password) {
        
        User user = null;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
      try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.LOGIN);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setAbout(rs.getString("about"));
                user.setEmail(rs.getString("email"));
            }            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtility.close(rs, ps, con);
        }
        
        return user;
    }
    
}
