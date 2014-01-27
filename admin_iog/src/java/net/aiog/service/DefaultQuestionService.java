/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.service;

import net.aiog.database.QuestionDao;
import net.aiog.domain.Question;

/**
 *
 * @author memmedimanli
 */
public class DefaultQuestionService implements QuestionService{
        
    private QuestionDao questionDao;
    
    public DefaultQuestionService(QuestionDao questionDao)
    {
        this.questionDao = questionDao;
    }
    
    @Override
    public boolean add_question(Question question) {
       
        return questionDao.addQuestion(question);
    }
    
}
