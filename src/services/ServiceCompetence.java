/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceCompetence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Competence;
import utils.MaConnexion;

/**
 *
 * @author admin
 */
public class ServiceCompetence implements IServiceCompetence{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    @Override
    public void createCompetence(Competence c) {
        
        //request
        String req = "INSERT INTO `competence`(`nom`) VALUES (?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, c.getNom());
            st.executeUpdate();
            System.out.println("Competence ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    
    @Override
    public List<Competence> readCompetence() {
        ArrayList<Competence> competences = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM competence";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                competences.add(new Competence(rs.getInt(1), rs.getString("nom")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return competences;
    }
    
    
     public void deleteCompetence(int id) {
        try {

            if (id != 0) {
                String sql = "delete from competence WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("compétence supprimée !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
        public void updateCompetence(Competence c) {
        try {

            if (c.getId() != 0) {
                String sql = "UPDATE competence  SET nom=? WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setString(1, c.getNom());
                st.setInt(2, c.getId());
                st.executeUpdate();
                System.out.println("Competence updated !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Competence> SearchByName(String name) {
        ArrayList<Competence> competences = new ArrayList();
        try {
            String req = "SELECT * FROM competence where nom =?";
            PreparedStatement Ps = cnx.prepareStatement(req);
            Ps.setString(1, name);
            ResultSet rs = Ps.executeQuery();
            
            while (rs.next()) {                
                
                competences.add(new Competence(rs.getInt(1), rs.getString(2)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
      
        return competences;
        
    }
    
    public List<Competence> TriParName() {
        ArrayList<Competence> comps = new ArrayList();

        String req = "SELECT * FROM competence ORDER BY nom ASC";
        try {
            Statement st = cnx.createStatement();

            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                comps.add(new Competence(rs.getInt(1), rs.getString(2)));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return comps;
    }
    
    
}