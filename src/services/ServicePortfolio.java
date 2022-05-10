/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServicePortfolio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Portfolio;
import utils.MaConnexion;

/**
 *
 * @author YOGA
 */
public class ServicePortfolio implements IServicePortfolio {

    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    @Override
    public void createPortfolio(Portfolio p) {

        //request
        String req = "INSERT INTO `portfolio` (`image`, `title`) VALUES(?,?)";

        // System.out.println(p.getImage());
        //System.out.println(p.getTitle());
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, p.getImage());
            st.setString(2, p.getTitle());

            st.executeUpdate();
            System.out.println("Portfolio ajoutée avec succés.");

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }

    public ResultSet getall_p() {

        try {
            PreparedStatement req = cnx.prepareStatement("SELECT * FROM portfolio");
            ResultSet rs = req.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void modifier_portfolio(Portfolio p, String image, int id) {
        try {
            PreparedStatement req = cnx.prepareStatement("update portfolio set image=?,title=? where id=?");

            req.setString(1, p.getImage());
            req.setString(2, p.getTitle());
            req.setInt(3, id);

            req.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void supprimer_portfolio(int id) {
        //boolean ok=false;
        try {

            PreparedStatement req = cnx.prepareStatement("delete from portfolio where id =?");
            req.setInt(1, id);
            req.executeUpdate();
            System.out.println("portfolio supprimée");
//ok=true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        // return ok;
    }

    public List<Portfolio> AfficherAll(Portfolio t) {
        List<Portfolio> ProduitList = new ArrayList<>();
        try {
            String requete = "SELECT id,title,image FROM portfolio ORDER BY id DESC";
            Statement pst = MaConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                Portfolio r = new Portfolio();
                ///
                r.setId(rs.getInt(1));
                r.setTitle(rs.getString(2));
                r.setImage(rs.getString(3));
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
