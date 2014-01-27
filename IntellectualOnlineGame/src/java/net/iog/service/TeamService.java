/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.service;

import net.iog.domain.TeamRegistration;

/**
 *
 * @author memmedimanli
 */
public interface TeamService {
    
    public boolean isUniqueTeamName (String teamName);
    
    public boolean registerTeam (TeamRegistration team);
}
