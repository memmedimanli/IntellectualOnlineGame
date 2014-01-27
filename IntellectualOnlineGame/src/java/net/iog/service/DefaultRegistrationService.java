/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.service;

import net.iog.database.RegistrationDao;
import net.iog.domain.RegistrationForm;

/**
 *
 * @author memmedimanli
 */
public class DefaultRegistrationService implements RegistrationService {
    
    private RegistrationDao registrationDao;
    
    public DefaultRegistrationService (RegistrationDao registrationDao){
        this.registrationDao = registrationDao;
    }

    @Override
    public boolean isUniqueUsername(String username) {
      return  registrationDao.isUniqueUsername(username);
    }

    @Override
    public boolean register(RegistrationForm form) {
        return registrationDao.register(form);
    }
}
