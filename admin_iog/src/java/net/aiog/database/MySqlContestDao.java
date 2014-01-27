/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import net.aiog.domain.Contest;

/**
 *
 * @author memmedimanli
 */
public class MySqlContestDao implements ContestDao{
     
    private DataSource dataSource;
    
    public MySqlContestDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    @Override
    public boolean isUniqueContestName(String contestName) {
         boolean unique = true;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.CHECK_CONTESTNAME);
            ps.setString(1, contestName);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                unique = false;
            }
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }finally {
            DatabaseUtility.close(rs, null, con);
        }
        
        return unique;
    }

    @Override
    public boolean createContest(Contest contest) {
        
          boolean success = false;
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(SqlQuery.CREATE_CONTEST);
            ps.setString(1, contest.getContestName());
            ps.setString(2, contest.getContestDate());
            ps.setString(3, contest.getBeginTime());
          
            int count = ps.executeUpdate();
            
            if(count == 1)
            {
                success = true;
            }
            
            con.commit();
            
        }catch(Exception ex)
        {
              try {
                  if(con.getAutoCommit())
                  {
                      con.setAutoCommit(false);
                  con.rollback();
                  }
              } catch (SQLException ex1) {
                  Logger.getLogger(MySqlContestDao.class.getName()).log(Level.SEVERE, null, ex1);
              }
            ex.printStackTrace();
        }finally
        {
            DatabaseUtility.close(null, ps, con);
        }
        
        return success;
    }
    
}
