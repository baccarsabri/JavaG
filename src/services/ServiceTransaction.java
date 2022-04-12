/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.InterfaceTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import models.User;
import utils.MaConnexion;

/**
 *
 * @author bacca
 */
public class ServiceTransaction implements InterfaceTransaction{

    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();
    @Override
    public void transaction(User user , String type) {
            try {
            int idTransaction;
            long millis=System.currentTimeMillis();  
            java.sql.Date now=new java.sql.Date(millis);  
            
            
        String req = "INSERT INTO `Transaction`(`user_id`, `type`, `statut`, `created_at`, `prix` ) VALUES (?,?,?,?,?)";
       
            int prix;
            int bids;
            
           
            PreparedStatement st = cnx.prepareStatement(req,
                                      Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, user.getId());
            st.setString(2, type);
            st.setString(3, "Payment Par Card");
            st.setDate(4, now);
            if (type=="BASIC_PLANS"){
            prix=30;
            bids=50;
            }
            else {
            if (type=="STANDARD_PLANS"){
            prix=60;
            bids=100;
            }
            else {
            prix=100;
            bids=200;
            }
            
            }
            st.setInt(5, prix);
          
            
           st.executeUpdate();
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idTransaction = generatedKeys.getInt(1);
                
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
            }
           
            String reqUser="UPDATE `User` SET bids=? WHERE id="+user.getId();
            
            PreparedStatement stt = cnx.prepareStatement(reqUser);
            stt.setInt(1, bids);
            stt.executeUpdate();
           
           Calendar cal = Calendar.getInstance();
            cal.setTime(now);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            System.out.println(month);
            System.out.println(day);
            System.out.println(year);
            String stringid=""+user.getId()+idTransaction+day+month+year;
            int idFacture=Integer.parseInt(stringid);
            
            String reqF = "INSERT INTO `Facture`(`id`,`created_at`) VALUES (?,?)";
            PreparedStatement stF = cnx.prepareStatement(reqF);
            stF.setInt(1, idFacture);
            stF.setDate(2, now);
            
            stF.executeUpdate();
            
            String reqUpadateTransaction="UPDATE `transaction` SET facture_id=? WHERE id="+idTransaction;
            
            PreparedStatement sttr = cnx.prepareStatement(reqUpadateTransaction);
            sttr.setInt(1, idFacture);
            sttr.executeUpdate();
            
     
            
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
    }
    
}
