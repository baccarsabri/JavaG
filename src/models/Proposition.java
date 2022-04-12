/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;



/**
 *
 * @author malek
 */
public class Proposition {
     private int id;
    private Projet projet;
    private int user_id;
    
    private int prix;
    private int date_max;
    private String description;
    private Date created_at;
    private String statut;

    public Proposition(int id, Projet projet, int user_id, int prix, int date_max, String description, Date created_at, String statut) {
        this.id = id;
        this.projet = projet;
        this.user_id = user_id;
        this.prix = prix;
        this.date_max = date_max;
        this.description = description;
        this.created_at = created_at;
        this.statut = statut;
    }

    public Proposition(Projet projet, int user_id, int prix, int date_max, String description,  String statut) {
        this.projet = projet;
        this.user_id = user_id;
        this.prix = prix;
        this.date_max = date_max;
        this.description = description;
        
        this.statut = statut;
    }

    public Proposition() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getDate_max() {
        return date_max;
    }

    public void setDate_max(int date_max) {
        this.date_max = date_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    
}

