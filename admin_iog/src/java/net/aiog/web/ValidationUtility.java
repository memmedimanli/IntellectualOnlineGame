/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.aiog.domain.Contest;
import net.aiog.domain.Question;
import org.apache.commons.validator.GenericValidator;

/**
 *
 * @author memmedimanli
 */
public class ValidationUtility {
     public static Map<String, List<String>> validateAddQuestion(Question question)
    {
        Map<String, List<String>> errorMap = new HashMap<String, List<String>>();
        
        List<String> contentErrors = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(question.getContent())) {
            contentErrors.add("Content can not be empty");
        }
        
        errorMap.put("content", contentErrors);
        
        List<String> answerErrors = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(question.getContent())) {
            answerErrors.add("Answer can not be empty");
        }
        
        errorMap.put("answer", answerErrors);
        
        List<String> authorErrors = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(question.getContent())) {
            authorErrors.add("Author field can not be empty");
        }
        
        errorMap.put("author", authorErrors);
        
        List<String> commentErrors = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(question.getContent())) {
            commentErrors.add("Comment field can not be empty");
        }
        
        errorMap.put("comment", commentErrors);
        
        return errorMap;
    }
     
      public static Map<String, List<String>> validateCreateContest(Contest contest)
    {
        Map<String, List<String>> errorMap = new HashMap<String, List<String>>();
        
        List<String> contestNameError = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(contest.getContestName())) {
            contestNameError.add("Contest name can not be empty");
        }
        
        errorMap.put("content", contestNameError);
        
        List<String> contestDateError = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(contest.getContestDate())) {
            contestDateError.add("Date must be shown");
        }
        
        errorMap.put("answer", contestDateError);
        
        List<String> beginTimeError = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(contest.getBeginTime())) {
            beginTimeError.add("Begin time must be shown");
        }
        
        errorMap.put("author", beginTimeError);
        
        List<String> commentErrors = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(contest.getBeginTime())) {
            commentErrors.add("Comment field can not be empty");
        }
        
        errorMap.put("comment", commentErrors);
        
        return errorMap;
    }
    
    
}
