/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.service;

import net.aiog.database.ContestDao;
import net.aiog.database.QuestionDao;
import net.aiog.domain.Contest;

/**
 *
 * @author memmedimanli
 */
public class DefaultContestService implements ContestService{
    
     private ContestDao contestDao;
     
     public DefaultContestService(ContestDao contestDao)
     {
      this.contestDao = contestDao;  
     }

    @Override
    public boolean isUniqueContestName(String contestName) {
        return contestDao.isUniqueContestName(contestName);
    }

    @Override
    public boolean createContest(Contest contest) {
        return contestDao.createContest(contest);
    }
    
}
