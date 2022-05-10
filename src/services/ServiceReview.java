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
import models.Portfolio;
import models.Review;
import org.controlsfx.control.Rating;
import utils.MaConnexion;

/**
 *
 * @author YOGA
 */
public class ServiceReview implements IServiceReview {

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

    public ResultSet getall_review() {

        try {
            PreparedStatement req = cnx.prepareStatement("SELECT * FROM review");
            ResultSet rs = req.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void modifier_review(Review a) {

        try {
            PreparedStatement req = cnx.prepareStatement("update review set note=?,commentaire=? where id=?");

            req.setInt(1, a.getNote());
            req.setString(2, a.getCommentaire());
            req.setInt(3, a.getId());

            req.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void supprimer_review(int id) {
        //boolean ok=false;
        try {

            PreparedStatement req = cnx.prepareStatement("delete from review where id=?");
            req.setInt(1, id);
            req.executeUpdate();
            System.out.println("review supprimée");
//ok=true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        // return ok;
    }

    public List<Review> retrieveBestReview(int user_id) {

        ArrayList<Review> reviews = new ArrayList();
        try {

            PreparedStatement req = cnx.prepareStatement("Select * from review where user_id=? and note=(Select MAX(note) FROM review) ");
            req.setInt(1, user_id);
            ResultSet rs = req.executeQuery();

            while (rs.next()) {

                reviews.add(new Review(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString("commentaire")));

            }

            reviews.get(0).getId();

            System.out.println(String.format("meilleure note %s pour l'utilisateur %s", reviews.get(0).getNote(), reviews.get(0).getUser_id()));
//ok=true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        // return ok;
        return reviews;

    }

    public String MeilleurRate() {
        String response = "";
        try {

            PreparedStatement req = cnx.prepareStatement("Select * from review where note=(Select MAX(note) FROM review) ");
            ResultSet rs = req.executeQuery();

            while (rs.next()) {
                // response = rs.getString(1);
                response = "meilleure note " + rs.getString(3) + "";
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        // return ok;
        return response;

    }

    @Override
    public void modifier_review(Review a, int note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Review> AfficherAllReview(Review t) {
        List<Review> ProduitList = new ArrayList<>();
        try {
            String requete = "SELECT id,note,commentaire FROM review";
            Statement pst = MaConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                Review r = new Review();

                Rating rr = new Rating();
                rr.setRating(rs.getInt(2));
                rr.setDisable(true);
                r.setRateView(rr); //lel tableau
                
               
                r.setId(rs.getInt(1));
                r.setNote(rs.getInt(2));
                r.setCommentaire(rs.getString(3));
                ProduitList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return ProduitList;
    }
}
