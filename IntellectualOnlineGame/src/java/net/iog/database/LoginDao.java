/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import net.iog.domain.User;

/**
 *
 * @author memmedimanli
 */
public interface LoginDao {
    User login (String username, String password);
}
