/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServicePortfolio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    public List<Portfolio> readPortfolio() {
        ArrayList<Portfolio> portfolios = new ArrayList();

        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM portfolio";
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                portfolios.add(new Portfolio(rs.getInt(1), rs.getString(4), rs.getString(3), rs.getInt(2)));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return portfolios;
    }

    public void modifier_portfolio(Portfolio p, String title) {
        try {
            PreparedStatement req = cnx.prepareStatement("update portfolio set title=?,image=? where title=?");

            req.setString(1, p.getImage());
            req.setString(2, p.getTitle());
            req.setString(3, p.getTitle());

            req.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void supprimer_portfolio(Portfolio p) {
        //boolean ok=false;
        try {

            PreparedStatement req = cnx.prepareStatement("delete from portfolio where id =?");
            req.setInt(1, p.getId());
            req.executeUpdate();
            System.out.println("portfolio supprimée");
//ok=true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        // return ok;
    }

}
