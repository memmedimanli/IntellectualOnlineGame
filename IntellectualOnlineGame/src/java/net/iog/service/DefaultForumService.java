/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.service;

import net.iog.database.ForumDao;
import net.iog.domain.Forum;

/**
 *
 * @author memmedimanli
 */
public class DefaultForumService implements ForumService{
     
    private ForumDao forumDao;
    
    public DefaultForumService (ForumDao forumDao)
    {
        this.forumDao = forumDao;
    }
    @Override
    public boolean posted(Forum forum) {
       
        return forumDao.posted(forum);
    }
    
}
