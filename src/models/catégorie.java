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
public class catégorie {
    
  //var
    private int id;
    private String nom;  

    public catégorie() {
    }

  
    
    
    public catégorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    
    
    
    
      public catégorie( String nom) {
        this.nom = nom;
    }
    




//GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "cat\u00e9gorie{" + "id=" + id + ", nom=" + nom + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
