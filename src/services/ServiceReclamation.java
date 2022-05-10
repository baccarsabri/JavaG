/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceReclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.Projet;
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
        String req = "INSERT INTO `reclamation`(`description`, `date_de_reclamation`, `statut`,`projet_id`) VALUES (?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, r.getDescription());
            st.setDate(2, r.getDate_de_reclamation());
            st.setString(3, r.getStatut());
            st.setInt(4, r.getProjet_id());
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
     String req = "DELETE FROM reclamation WHERE id = ?";
           try {
            PreparedStatement st = cnx.prepareStatement(req);  
            st.setInt(1, id);
            
            
            st.executeUpdate();
            System.out.println("Réclamation supprimée!!");
            
        } catch (SQLException ex) {
            
           ex.printStackTrace();
       
    }
    }
        public void updateReclamation(Reclamation r) {
        try {

            if (r.getId() != 0) { 
                String sql = "UPDATE reclamation  SET description=?,date_de_reclamation=?,statut=? WHERE id=?";

                PreparedStatement st = cnx.prepareStatement(sql);
                           //     st.setInt(1, r.getProjet_id());

                st.setString(1, r.getDescription());
                st.setDate(2, r.getDate_de_reclamation());
                st.setString(3, r.getStatut());
                st.setInt(4, r.getId());
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
    public Date afficher_date(){

    java.sql.Date dt = new java.sql.Date(0,0,0);   
        String req="SELECT DATE(date_de_reclamation) AS date, COUNT(*) AS count FROM reclamation GROUP BY date ORDER BY count DESC LIMIT 1";
        
        try {
            PreparedStatement ste = cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                dt = rs.getDate("date");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dt;
    }
     @Override
    public String CreateCaptchaValue() {
        Random random = new Random();
        int length = 7 + (Math.abs(random.nextInt()) % 3);
        StringBuffer captchaStrBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int baseCharacterNumber = Math.abs(random.nextInt()) % 62;
            int characterNumber = 0;
            if (baseCharacterNumber < 26) {
                characterNumber = 65 + baseCharacterNumber;
            } else if (baseCharacterNumber < 52) {
                characterNumber = 97 + (baseCharacterNumber - 26);
            } else{
                characterNumber = 48 + (baseCharacterNumber - 52);
            }
            captchaStrBuffer.append((char) characterNumber);
        }
        return captchaStrBuffer.toString();

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

}