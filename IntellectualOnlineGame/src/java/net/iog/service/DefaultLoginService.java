/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.service;

import net.iog.database.LoginDao;
import net.iog.domain.User;

/**
 *
 * @author memmedimanli
 */
public class DefaultLoginService implements LoginService {
    
    private LoginDao loginDao;
    
    public DefaultLoginService (LoginDao loginDao){
        this.loginDao = loginDao;
    }

    @Override
    public User login(String username, String password) {
        return loginDao.login(username, password);
    }
}
