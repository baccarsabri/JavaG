/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceFichier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Fichier;
import utils.MaConnexion;

/**
 *
 * @author Oussama Fdhila
 */
public class ServiceFichier implements IServiceFichier{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();
 @Override
    public void createFichier(Fichier f) {
        //request
        String req = "INSERT INTO `fichier`(`projet_id`,`link`) VALUES (?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1,f.getProjet_id());
            st.setString(2, f.getLink());
            st.executeUpdate();
            System.out.println("Fichier ajouté avec succés.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }
 @Override
    public List<Fichier> readFichier() {
        ArrayList<Fichier> fichiers = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM fichier";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                fichiers.add(new Fichier(rs.getInt(1), rs.getInt(2),rs.getString(3)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return fichiers;
    }
    
    @Override
    public void deleteFichier(int id) {
       String req = "DELETE FROM fichier WHERE id = ?";
           try {
            PreparedStatement st = cnx.prepareStatement(req);  
            st.setInt(1, id);
            
            
            st.executeUpdate();
            System.out.println("Fichier supprimé!!");
            
        } catch (SQLException ex) {
            
           ex.printStackTrace();
       
    }
    }
    
        public void updateFichier(Fichier f) {
        try {

            if (f.getId() != 0) {
                String sql = "UPDATE fichier  SET link=? WHERE id=?";

                PreparedStatement st = cnx.prepareStatement(sql);
             //   st.setInt(1, f.getProjet_id());
                st.setString(1, f.getLink());
                st.setInt(2, f.getId());
                st.executeUpdate();
                System.out.println("le fichier est à jour !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    @Override
    public Fichier findFichById(int id) throws SQLException {

        Fichier fichier = new Fichier();

        String req1 = "SELECT * FROM fichier where id=?";
        PreparedStatement preparedStatement = cnx.prepareStatement(req1);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            fichier.setId(result.getInt("id"));
            fichier.setProjet_id(result.getInt(2));
            fichier.setLink(result.getString(3));
        }

        return fichier;
    }
     @Override
    public List<Fichier> RechercheByLink(String lnk) {
        ArrayList<Fichier> fichiers = new ArrayList();
        try {
            String requete = "SELECT * FROM fichier where link =?";
            PreparedStatement P = cnx.prepareStatement(requete);
            P.setString(1, lnk);
            ResultSet rs = P.executeQuery();
            
            while (rs.next()) {                
                
                fichiers.add(new Fichier(rs.getInt(1), rs.getString(2)));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return fichiers;
    }
    
    
    
    
}