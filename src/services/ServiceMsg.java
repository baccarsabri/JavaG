/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceMsg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Msg;
import utils.MaConnexion;

/**
 *
 * @author admin
 */

public class ServiceMsg implements IServiceMsg{
    
    //var
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();

    
    @Override
    public void createMsg(Msg m) {
        
        //request
        String req = "INSERT INTO `message`(`msg`) VALUES (?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, m.getMsg());
            st.executeUpdate();
            System.out.println("message ajouté avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        
    }

    
    @Override
    public List<Msg> readMsg() {
        ArrayList<Msg> msgs = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM message";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                msgs.add(new Msg(rs.getInt(1), rs.getString("msg")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return msgs;
    }
    @Override
     public void deleteMsg(int id) {
        try {

            if (id != 0) {
                String sql = "delete from message WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, id);
                st.executeUpdate();
                System.out.println("message supprimée !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     @Override
        public void updateMsg(Msg m) {
        try {

            if (m.getId() != 0) {
                String sql = "UPDATE message  SET msg=? WHERE id=?";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setString(1, m.getMsg());
                st.setInt(2, m.getId());
                st.executeUpdate();
                System.out.println("Msg updated !");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


   
    }
    
    
    
    
    
