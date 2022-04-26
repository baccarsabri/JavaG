/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceReview;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Review;
import utils.MaConnexion;


/**
 *
 * @author YOGA
 */
public class ServiceReview implements IServiceReview{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    
    public void createReview(Review r) {
        
        //request
        String req = "INSERT INTO `review`(`note`, `commentaire`) VALUES (?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, r.getNote());
            st.setString(2, r.getCommentaire());
            st.executeUpdate();
            System.out.println("review ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    
    public List<Review> readReviews() {
        ArrayList<Review> reviews = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM review";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                reviews.add(new Review(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString("commentaire")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return reviews;
    }
      public void modifier_review(Review a,int note ) {
        try {
            PreparedStatement req = cnx.prepareStatement("update review set note=?,commentaire=? where note=?");
            
            req.setInt(1, a.getNote());
            req.setString(2, a.getCommentaire());
            req.setInt(3,note);

          
            req.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
       public void supprimer_review(Review a,int id) {
         //boolean ok=false;
        try {
            
            PreparedStatement req = cnx.prepareStatement("delete from review where id =?");
            req.setInt(1, id);
            req.executeUpdate();
            System.out.println("review supprimée");
//ok=true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       // return ok;
    }
    
    }
    
