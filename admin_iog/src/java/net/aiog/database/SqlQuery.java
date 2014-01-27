/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.database;

/**
 *
 * @author memmedimanli
 */
public class SqlQuery {
    
    public static final String ADD_QUESTION = "INSERT INTO db_nhn.question(content, answer, author, comment, game) values (?, ?, ?, ?, ?)";
    
    public static final String CHECK_CONTESTNAME = "SELECT contest_id from db_nhn.contest where contestName = ?";
    
    public static final String CREATE_CONTEST = "INSERT INTO db_nhn.contest (contestName, Date, BeginTime) values (?, ?, ?)";
}
