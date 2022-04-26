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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import models.Facture;
import models.Transaction;

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
            int userBids=0;
           
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
            String reqBids="Select bids from `User` WHERE id="+user.getId();
          
            Statement stBids = cnx.createStatement();
            ResultSet rsBids = stBids.executeQuery(reqBids);
             while (rsBids.next()) { 
                userBids= rsBids.getInt(1);
             }
           
            String reqUser="UPDATE `User` SET bids=? WHERE id="+user.getId();
            
            PreparedStatement stt = cnx.prepareStatement(reqUser);
            stt.setInt(1, userBids+bids);
            stt.executeUpdate();
           
           Calendar cal = Calendar.getInstance();
            cal.setTime(now);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            System.out.println(month);
            System.out.println(day);
            System.out.println(year);
            String stringid=""+idTransaction+day+month+(year);
            System.out.println("yes : " + stringid);
            int idFacture=(int) Long.parseLong(stringid.trim());
            System.out.println(((Object)idFacture).getClass().getSimpleName());
            System.out.println("var : "+idFacture);
            
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
    
    public Facture getFactureById(int id){
    Facture user = new Facture();
        
        try {
           
            String req = "SELECT * FROM facture where id="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) { 
                user.setId(rs.getInt(1));
               
                user.setCreated_at(rs.getDate("created_at"));
                
                
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return user;
    
    }
    
    public List<Transaction> AllTransactions(User user) {
        ArrayList<Transaction> t = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM `Transaction` where user_id="+user.getId();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) { 
              
                
                t.add(new Transaction(rs.getInt(1), getFactureById(rs.getInt("facture_id")), rs.getString("type"), rs.getString("statut"), rs.getDate("created_at") , rs.getInt("prix")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return t;
    }
    
    
}
