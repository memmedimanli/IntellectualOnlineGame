/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.iog.domain.RegistrationForm;
import net.iog.domain.TeamRegistration;
import org.apache.commons.validator.GenericValidator;


public class ValidationUtility {
    public static Map<String, List<String>> validateRegistrationForm(RegistrationForm form) {
        Map<String, List<String>> errorMap = new HashMap<String, List<String>>();
        
        //GenericValidator.
        
        // TODO 1.validate username
        List<String> usernameErrors = new ArrayList<String>();
        
        if(GenericValidator.isBlankOrNull(form.getUsername())) {
            usernameErrors.add("Username can not be empty");
        }
        
        if(form.getUsername().length() < 3) {
            usernameErrors.add("Minimum username length is 3 characters");
        }
        
        if(form.getUsername().length() > 30) {
            usernameErrors.add("Maximum username length is 30 characters");
        }
                       
        errorMap.put("username", usernameErrors);
        
        // TODO 2.validate name
        List<String> nameErrors = new ArrayList<String>();   
        if(GenericValidator.isBlankOrNull(form.getName())) {
            nameErrors.add("Name can not by empty");
        }
        
        if(form.getName().length() < 5) {
            nameErrors.add("Minimum name length is 5 characters");
        }
        
        if(form.getName().length() > 30) {
            nameErrors.add("Maximum name length is 30 characters");
        }
        errorMap.put("name", nameErrors);
        
        // TODO 3.validate surname
        List<String> surnameErrors = new ArrayList<String>();        
        if(GenericValidator.isBlankOrNull(form.getSurname())) {
            surnameErrors.add("Surname can not by empty");
        }
        
        if(form.getSurname().length() < 5) {
            surnameErrors.add("Minimum surname length is 5 characters");
        }
        
        if(form.getSurname().length() > 30) {
            surnameErrors.add("Maximum surname length is 30 characters");
        }
        errorMap.put("surname", surnameErrors);
        
        // TODO 4.validate email
        List<String> emailErrors = new ArrayList<String>();        
        if(!GenericValidator.isEmail(form.getEmail())) {
            emailErrors.add("Email is invalid");
        }
        errorMap.put("email", emailErrors);
        
        // TODO 5.validate password
        List<String> passwordErrors = new ArrayList<String>();       
        if(GenericValidator.isBlankOrNull(form.getPassword()) || GenericValidator.isBlankOrNull(form.getPasswordConfirmation())) {
            passwordErrors.add("Password and confirmation can not be the empty");
        }
        
        if(!form.getPassword().equals(form.getPasswordConfirmation())) {
            passwordErrors.add("Password and confirmation must be same.");
        }
        errorMap.put("password", passwordErrors);
        
        // TODO 6.validate captcha
        List<String> captchaErrors = new ArrayList<String>();
        errorMap.put("captcha", captchaErrors);
        
        return errorMap;
    }
    
    public static Map<String, List<String>> validateTeamRegistration(TeamRegistration team)
    {
        Map<String, List<String>> errorMap = new HashMap<String, List<String>>();
        
        List<String> teamNameErrors = new ArrayList<String>();   
        
        if(GenericValidator.isBlankOrNull(team.getTeamName())) {
            teamNameErrors.add("Team name can not be empty");
        }
        
        errorMap.put("teamName", teamNameErrors);
        
        return errorMap;
    }
    
    
}
