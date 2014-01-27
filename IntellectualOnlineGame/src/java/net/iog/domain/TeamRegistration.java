/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.domain;

/**
 *
 * @author memmedimanli
 */
public class TeamRegistration {
    
    private String teamName;
    private String captain;
    private int count;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
