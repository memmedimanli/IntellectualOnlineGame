/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.database;

import net.iog.domain.TeamRegistration;

/**
 *
 * @author memmedimanli
 */
public interface TeamDao {
    
    public boolean isUniqueTeamName(String teamName);
    
    public boolean registerTeam (TeamRegistration team);
    
}
