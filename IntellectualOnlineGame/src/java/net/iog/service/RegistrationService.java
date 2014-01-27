/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.service;

import net.iog.domain.RegistrationForm;

/**
 *
 * @author memmedimanli
 */
public interface RegistrationService {
    
    public boolean isUniqueUsername (String username);
    
    public boolean register (RegistrationForm form);
}
