/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.database;

import net.aiog.domain.Question;

/**
 *
 * @author memmedimanli
 */
public interface QuestionDao {
    
    public boolean addQuestion(Question question);
}
