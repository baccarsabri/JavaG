/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


/**
 *
 * @author Oussama Fdhila
 */
public class Fichier {

    //var
    private int id;
    private int projet_id;
    private String link;


    //Constructor
    public Fichier() {

    }
    //..

    public Fichier(int id, int projet_id, String link) {
        this.id = id;
        this.projet_id = projet_id;
        this.link = link;

    }

  

    //..
    public Fichier(int projet_id, String link) {
       this.projet_id=projet_id;
       this.link = link;
    }


    //GETTERS & SETTERS
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
      public int getProjet_id() {
        return projet_id;
    }

    public void setProjet_id(int projet_id) {
        this.projet_id = projet_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Fichier{" + "id=" + id + ", projet_id=" + projet_id + ", link=" + link + '}';
    }

  

  

}