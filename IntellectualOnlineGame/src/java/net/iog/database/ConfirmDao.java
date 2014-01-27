/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import java.util.Map;
import net.iog.domain.User;

/**
 *
 * @author memmedimanli
 */
public interface ConfirmDao {
    
    public boolean confirm(User user);
}
