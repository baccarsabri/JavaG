/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IServiceProjet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Projet;
import utils.MaConnexion;

/**
 *
 * @author malek
 */
public class ServiceProjet implements IServiceProjet{
   MaConnexion instance = MaConnexion.getInstance();
   Connection cnx = instance.getCnx(); 
   
    @Override
    public void createProjet(Projet p) {
        
        //request
        String req = "INSERT INTO projet(user_id,nom, description, min_salaire, max_salaire, statut)"+" VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, p.getUser_id());
            st.setString(2, p.getNom());
            st.setString(3, p.getDescription());
            st.setDouble(4, p.getMin_salaire());
            st.setDouble(5, p.getMax_salaire());
            st.setString(6, p.getStatut());
            
            st.executeUpdate();
            System.out.println("Projet ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    @Override
    public List<Projet> readProjets() {
         ArrayList<Projet> projets = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM projet";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                projets.add(new Projet(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("description"), rs.getDouble(5), rs.getDouble(6), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return projets;
    }

    @Override
    public void updateProjet(int id,String nom,String description,double min_salaire,double max_salaire ) {
       String req = "UPDATE  projet SET nom = ?, description = ?, min_salaire = ?,max_salaire = ? where id = ? ";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, nom);
            st.setString(2, description);
            st.setDouble(3, min_salaire);
            st.setDouble(4, max_salaire);
            st.setInt(5, id);
            
            
            st.executeUpdate();
            System.out.println("Projet modifié avec succes.");
            
        } catch (SQLException ex) {
            
           ex.printStackTrace();
       
    }
    }
    @Override
    public void deleteProjet(int id) {
        String req = "DELETE FROM projet WHERE id = ?";
           try {
            PreparedStatement st = cnx.prepareStatement(req);
            
            st.setInt(1, id);
            
            
            st.executeUpdate();
            System.out.println("Projet supprimé avec succes.");
            
        } catch (SQLException ex) {
            
           ex.printStackTrace();
       
    }
    }

    @Override
    public Projet detailProjet(int id) {
          String req = "SELECT * FROM projet WHERE id ="+id;
          Projet pa =  new Projet();
        try {
            Statement st = cnx.createStatement();
            
            
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
					{
                          
                
              pa =  new Projet(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("description"), rs.getDouble(5), rs.getDouble(6), rs.getString("statut"));
                }
            
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return pa;
    }
    
    
       @Override
    public List<Projet> MesProjets(int id) {
         ArrayList<Projet> mesProjets = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM projet WHERE user_id="+id;
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                mesProjets.add(new Projet(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("description"), rs.getDouble(5), rs.getDouble(6), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return mesProjets;
    }

    @Override
    public List<Projet> readProjetsByCritere(String critere,String param) {
            ArrayList<Projet> mesProjets = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM projet ORDER BY "+critere+" "+param;
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                mesProjets.add(new Projet(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("description"), rs.getDouble(5), rs.getDouble(6), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return mesProjets;
    }

    @Override
    public List<Projet> MesProjetsByStatut(int id, String statut) {
          ArrayList<Projet> projets = new ArrayList();
        
        try {
            
            String req = "SELECT * FROM projet WHERE user_id = ? AND statut = ?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1,id);
            st.setString(2, statut);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                
                projets.add(new Projet(rs.getInt(1),rs.getInt(2), rs.getString("nom"), rs.getString("description"), rs.getDouble(5), rs.getDouble(6), rs.getString("statut")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return projets;
    }
    
    
    
    
}