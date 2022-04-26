/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author YOGA
 */
public class Review {
    //var
    private int id;
     private int user_id;
    private int note;
    private String commentaire;

  public Review(int id, int user_id, int note, String commentaire) {
        this.id = id;
        this.user_id = user_id;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Review(int note, String commentaire) {
        this.note = note;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", user_id=" + user_id + ", note=" + note + ", commentaire=" + commentaire + '}';
    }
    
    
  

    
    

  
    }
    
    
    
    

