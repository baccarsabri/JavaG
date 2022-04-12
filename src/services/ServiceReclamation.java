/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceReclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Reclamation;
import utils.MaConnexion;

/**
 *
 * @author Oussama Fdhila
 */
public class ServiceReclamation implements IServiceReclamation{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    public void createReclamation(Reclamation r) {
        //request
        String req = "INSERT INTO `reclamation`(`description`, `date_de_reclamation`, `statut`) VALUES (?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, r.getDescription());
            st.setDate(2, r.getDate_de_reclamation());
            st.setString(3, r.getStatut());
            st.executeUpdate();
            System.out.println("Réclamation ajoutée avec succés.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    public List<Reclamation> readReclamation() {
        ArrayList<Reclamation> reclamations = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM reclamation";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                reclamations.add(new Reclamation(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getDate("date_de_reclamation"), rs.getString(5)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return reclamations;
    }
public void deleteReclamation(int id) {
        try {

            if (id != 0) {
                String sql = "delete from reclamation WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("Réclamation supprimée !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void updateReclamation(Reclamation r) {
        try {

            if (r.getId() != 0) {
                String sql = "UPDATE reclamation  SET projet_id=?,description=?,date_de_reclamation=?,statut=? WHERE id=?";

                PreparedStatement st = cnx.prepareStatement(sql);
                                st.setInt(1, r.getProjet_id());

                st.setString(2, r.getDescription());
                st.setDate(3, r.getDate_de_reclamation());
                st.setString(4, r.getStatut());
                st.setInt(5, r.getId());
                st.executeUpdate();
                System.out.println("la réclamation est à jour !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

        public Reclamation findRecById(int id) {

        Reclamation reclamation = new Reclamation();

        String req1 = "SELECT * FROM reclamation where id=?";
         try {
        PreparedStatement preparedStatement = cnx.prepareStatement(req1);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            reclamation.setId(result.getInt("id"));
            reclamation.setProjet_id(result.getInt("projet_id"));
            reclamation.setDescription(result.getString(3));
            reclamation.setDate_de_reclamation(result.getDate(4));
            reclamation.setStatut(result.getString(5));
        }
            // System.out.println(reclamation);
  } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return reclamation;
    }
    
     public List<Reclamation> ListByStatus(String status) {
        ArrayList<Reclamation> reclamations = new ArrayList();
        
        try {
           String requete = "SELECT * FROM reclamation where statut=?";
            PreparedStatement P = cnx.prepareStatement(requete);
            P.setString(1, status);
            ResultSet rs = P.executeQuery();
            
            while (rs.next()) {                
                
                reclamations.add(new Reclamation(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getDate("date_de_reclamation"), rs.getString(5)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return reclamations;
    }
    
    
    public List<Reclamation> TriParDescription() {
        ArrayList<Reclamation> recs = new ArrayList();

        String req = "SELECT * FROM reclamation ORDER BY description ASC";
        try {
            Statement st = cnx.createStatement();

            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                recs.add(new Reclamation(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getDate("date_de_reclamation"), rs.getString(5)));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return recs;
    }
     
      public List<Reclamation> RechercheByDescription(String desc) {
        ArrayList<Reclamation> reclamations = new ArrayList();
        try {
            String requete = "SELECT * FROM reclamation where description =?";
            PreparedStatement P = cnx.prepareStatement(requete);
            P.setString(1, desc);
            ResultSet rs = P.executeQuery();
            
            while (rs.next()) {                
                
                reclamations.add(new Reclamation(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getDate("date_de_reclamation"), rs.getString(5)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return reclamations;
    }
    
    
    
    
    
}