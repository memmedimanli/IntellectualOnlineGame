/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.domain;

/**
 *
 * @author memmedimanli
 */
public class User extends BaseDomain {
    
    private String username;
    private String name;
    private String surname;
    private String about;
    private String email;
    private String university;

   public User(){
       this.name = "";
       this.surname = "";
       this.username = "";
       this.about = "";
       this.email = "";
       this.university = "";
   }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

   @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", username=" + username + ", about=" + about + ", email=" + email + ", university=" + university + '}';
    }  
   
   
    
    
}
