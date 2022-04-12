/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author bacca
 */
public class Transaction {
    private int id;
    private User user;
    private String type;
    private String statut;
    private Date created_at;
    private int prix;
    private Facture facture;

    public Transaction() {
    }

    public Transaction(User user, String type, String statut, Date created_at, int prix, Facture facture) {
        this.user = user;
        this.type = type;
        this.statut = statut;
        this.created_at = created_at;
        this.prix = prix;
        this.facture = facture;
    }

    public Transaction(int id, User user, String type, String statut, Date created_at, int prix, Facture facture) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.statut = statut;
        this.created_at = created_at;
        this.prix = prix;
        this.facture = facture;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public String getStatut() {
        return statut;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public int getPrix() {
        return prix;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", user=" + user + ", type=" + type + ", statut=" + statut + ", created_at=" + created_at + ", prix=" + prix + ", facture=" + facture + '}';
    }
    
    
    
}
