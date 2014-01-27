/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.service;

import net.iog.domain.User;

/**
 *
 * @author memmedimanli
 */
public interface LoginService {
    
    User login(String username, String password);
}
