/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import net.iog.domain.RegistrationForm;

/**
 *
 * @author memmedimanli
 */
public interface RegistrationDao {
    
    public boolean isUniqueUsername (String username);
    
    public boolean register (RegistrationForm form);
}
