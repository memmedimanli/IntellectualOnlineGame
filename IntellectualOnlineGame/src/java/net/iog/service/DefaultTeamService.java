/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.service;

import net.iog.database.TeamDao;
import net.iog.domain.TeamRegistration;

/**
 *
 * @author memmedimanli
 */
public class DefaultTeamService implements TeamService {
    
    private TeamDao teamDao;
    
    public DefaultTeamService (TeamDao teamDao)
    {
        this.teamDao = teamDao;
    }

    @Override
    public boolean isUniqueTeamName(String teamName) {
        return teamDao.isUniqueTeamName(teamName);
    }

    @Override
    public boolean registerTeam(TeamRegistration team) {
        return teamDao.registerTeam(team);
    }
    
}
