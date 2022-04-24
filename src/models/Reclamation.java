/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Oussama Fdhila
 */
public class Reclamation {

    //var
    private int id;
    private int projet_id;
    private String description;
    private Date date_de_reclamation;
    private String statut;


    //Constructor
    public Reclamation() {

    }
    //..

    public Reclamation(int id, int projet_id, String description, Date date_de_reclamation, String statut) {
        this.id = id;
        this.projet_id = projet_id;
        this.description = description;
        this.date_de_reclamation = date_de_reclamation;
        this.statut = statut;

    }

  

    //..
    public Reclamation(String description, Date date_de_reclamation, String statut) {
       this.description = description;
       this.date_de_reclamation = date_de_reclamation;
       this.statut=statut;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_de_reclamation() {
        return date_de_reclamation;
    }

    public void setDate_de_reclamation(Date date_de_reclamation) {
        this.date_de_reclamation = date_de_reclamation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", projet_id=" + projet_id + ", description=" + description + ", date_de_reclamation=" + date_de_reclamation + ", statut=" + statut + '}';
    }

  

  

}