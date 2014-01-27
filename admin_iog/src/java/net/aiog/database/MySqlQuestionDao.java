/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import net.aiog.domain.Question;

/**
 *
 * @author memmedimanli
 */
public class MySqlQuestionDao implements QuestionDao {
   
     public DataSource dataSource;
     
     public MySqlQuestionDao (DataSource datasource)
     {
         this.dataSource = dataSource;
     }
    @Override
    public boolean addQuestion(Question question) {
        
        boolean success = false;
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_nhn", "root", "100105018");  
            ps = connection.prepareStatement(SqlQuery.ADD_QUESTION);
            ps.setString(1, question.getContent());
            ps.setString(2, question.getAnswer());
            ps.setString(3, question.getAuthor());
            ps.setString(4, question.getComment());
            ps.setString(5, question.getGame_id());
            
            int count = ps.executeUpdate();
            
            if(count == 1)
            {
                success = true;
            }
            
            connection.commit();
        }catch(Exception ex)
        {
          ex.printStackTrace();
            
        }finally{
            DatabaseUtility.close(null, ps, con);
        }
        
        return success;
    }
    
}
