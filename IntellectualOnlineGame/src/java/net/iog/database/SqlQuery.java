
package net.iog.database;

/**
 *
 * @author memmedimanli
 */
public class SqlQuery {
    
    public static final String LOGIN = "SELECT user_id, name, surname, about, email FROM db_nhn.Users where username=? and password=? and isActive=1" ;
    
    public static final String REGISTER_USER = "INSERT INTO db_nhn.Users(name, surname, username, password, email, isActive) values (?, ?, ?, ?, ?, 0)";
    
    public static final String CHECK_USERNAME = "SELECT user_id FROM db_nhn.Users where username = ? ";
    
    public static final String CHECK_TEAMNAME = "SELECT team_id FROM db_nhn.Team where teamName = ?";
    
    public static final String REGISTER_TEAM = "INSERT INTO db_nhn.Team(teamName) values (?)";
    
    public static final String POST_QUESTION = "INSERT INTO db_nhn.forum(title, content, author) values (?, ?, ?)";
    
    public static final String CONFIRM_EMAIL = "UPDATE users SET isActive='1' WHERE username = ? and email = ?";
    
    public static final String CHOOSE_QUESTION = "SELECT content FROM db_nhn.question";
}
