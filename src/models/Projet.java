/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author malek
 */
public class Projet {
    private int id;
    private int user_id;
    private String nom;
    private String description;
    private double min_salaire;
    private double max_salaire;
    private String statut;

    public Projet(int id, int user_id, String nom, String description, double min_salaire, double max_salaire, String statut) {
        this.id = id;
        this.user_id = user_id;
        this.nom = nom;
        this.description = description;
        this.min_salaire = min_salaire;
        this.max_salaire = max_salaire;
        this.statut = statut;
    }

    public Projet(int user_id, String nom, String description, double min_salaire, double max_salaire, String statut) {
        this.user_id = user_id;
        this.nom = nom;
        this.description = description;
        this.min_salaire = min_salaire;
        this.max_salaire = max_salaire;
        this.statut = statut;
    }
    

    public Projet() {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMin_salaire() {
        return min_salaire;
    }

    public void setMin_salaire(double min_salaire) {
        this.min_salaire = min_salaire;
    }

    public double getMax_salaire() {
        return max_salaire;
    }

    public void setMax_salaire(double max_salaire) {
        this.max_salaire = max_salaire;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", user_id=" + user_id + ", nom=" + nom + ", description=" + description + ", min_salaire=" + min_salaire + ", max_salaire=" + max_salaire + ", statut=" + statut + '}';
    }
    
}

