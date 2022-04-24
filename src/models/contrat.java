/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Date;
/**
 *
 * @author 21655
 */
public class contrat {

    public contrat() {
    }
    
    
    //var
    private int id;
    private int user_client_id;
    private int user_freelancer_id;
    private float prix;
    private Date created_at;
    private String statut;

    public contrat(int id, int user_client_id, int user_freelancer_id, float prix, Date created_at, String statut) {
        this.id = id;
        this.user_client_id = user_client_id;
        this.user_freelancer_id = user_freelancer_id;
        this.prix = prix;
        this.created_at = created_at;
        this.statut = statut;
    }

    
    public contrat( int user_client_id, int user_freelancer_id, float prix, Date created_at, String statut) {
        
        this.user_client_id = user_client_id;
        this.user_freelancer_id = user_freelancer_id;
        this.prix = prix;
        this.created_at = created_at;
        this.statut = statut;
    }
    
    
    //GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_client_id() {
        return user_client_id;
    }

    public void setUser_client_id(int user_client_id) {
        this.user_client_id = user_client_id;
    }

    public int getUser_freelancer_id() {
        return user_freelancer_id;
    }

    public void setUser_freelancer_id(int user_freelancer_id) {
        this.user_freelancer_id = user_freelancer_id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
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

    @Override
    public String toString() {
        return "contrat{" + "id=" + id + ", user_client_id=" + user_client_id + ", user_freelancer_id=" + user_freelancer_id + ", prix=" + prix + ", created_at=" + created_at + ", statut=" + statut + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
