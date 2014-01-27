/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.aiog.domain;

/**
 *
 * @author memmedimanli
 */
public class Question {
 
    private String author;
    private String content;
    private String answer;
    private String comment;
    private String game_id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }
    
    
    
}
