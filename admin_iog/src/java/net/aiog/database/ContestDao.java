/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.database;

import net.aiog.domain.Contest;

/**
 *
 * @author memmedimanli
 */
public interface ContestDao {
    
    public boolean isUniqueContestName(String contestName);
    
    public boolean createContest(Contest contest);
    
}
