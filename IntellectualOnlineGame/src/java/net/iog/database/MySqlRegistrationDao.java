/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import net.iog.domain.RegistrationForm;
import net.iog.utility.EncryptionUtility;

/**
 *
 * @author memmedimanli
 */
public class MySqlRegistrationDao implements RegistrationDao {
    
    private DataSource dataSource;
    
    public MySqlRegistrationDao (DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Override
    public boolean isUniqueUsername(String username) {
       
        boolean unique = true;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.CHECK_USERNAME);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()) {
                unique = false;
            }            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtility.close(rs, null, con);
        }
        
        return unique;
    }

    @Override
    public boolean register(RegistrationForm form) {
        
         boolean success = false;
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.REGISTER_USER);
            ps.setString(1, form.getName());
            ps.setString(2, form.getSurname());
            ps.setString(3, form.getUsername());
            ps.setString(4, EncryptionUtility.sha1(form.getPassword()));
            ps.setString(5, form.getEmail());
            
            int count = ps.executeUpdate();
            if(count == 1) {
                success = true;
            }
            if(con.getAutoCommit())
            {
                con.setAutoCommit(false);
                 con.commit();
            }
           
        } catch(Exception e) {
            try {
                if(con.getAutoCommit())
                {
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
