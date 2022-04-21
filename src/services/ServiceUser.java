/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.InterfaceUser;
import java.sql.Statement;
import utils.MaConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author bacca
 */
public class ServiceUser implements InterfaceUser{
    
    MaConnexion instance = MaConnexion.getInstance();
    Connection cnx = instance.getCnx();
    

    @Override
    public User UserDetails(int id) {
        
        User user = new User();
        
        try {
           
            String req = "SELECT * FROM user where id="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) { 
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setDate_naissance(rs.getDate("date_naissance"));
                user.setDescription(rs.getString("description"));
                user.setProfession(rs.getString("profession"));
                user.setVerified(rs.getBoolean("verified"));
                user.setCode(rs.getString("code"));
                user.setCreated_at(rs.getDate("created_at"));
                user.setBanned(rs.getBoolean("banned"));
                user.setBids(rs.getInt("bids"));
                user.setAddress(rs.getString("address"));
                user.setCode_postal(rs.getInt("code_postal"));
                user.setPhoto(rs.getString("photo"));
                
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return user;
    }
    
    @Override
    public User getUserByEmail(String email) {
        
        User user = new User();
        
        try {
           
            String req = "SELECT * FROM user where email='"+email+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) { 
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setDate_naissance(rs.getDate("date_naissance"));
                user.setDescription(rs.getString("description"));
                user.setProfession(rs.getString("profession"));
                user.setVerified(rs.getBoolean("verified"));
                user.setCode(rs.getString("code"));
                user.setCreated_at(rs.getDate("created_at"));
                user.setBanned(rs.getBoolean("banned"));
                user.setBids(rs.getInt("bids"));
                user.setAddress(rs.getString("address"));
                user.setCode_postal(rs.getInt("code_postal"));
                user.setPhoto(rs.getString("photo"));
                
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return user;
    }
    public User addUser(User user){
        //request
        String req = "INSERT INTO `User`(`email`, `password`, `nom`, `prenom`, `date_naissance`, `description` , `profession` , `verified` , `code` , `created_at` ,  `banned` ,`bids` , `address` , `code_postal` , `photo`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
            st.setString(3, user.getNom());
            st.setString(4, user.getPrenom());
            st.setDate(5, user.getDate_naissance());
            st.setString(6, user.getDescription());
            st.setString(7, user.getProfession());
            st.setBoolean(8, user.isVerified());
            st.setString(9, user.getCode());
            st.setDate(10, user.getCreated_at());
            st.setBoolean(11 , user.isBanned());
            st.setInt(12, user.getBids());
            st.setString(13, user.getAddress());
            st.setInt(14, user.getCode_postal());
            st.setString(15, user.getPhoto());
            
            
            st.executeUpdate();
            System.out.println("User ajoutée avec succes.");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return user;
        
    }
    public User login (String email , String password){
          User user = new User();
        
        try {
           
            String req = "SELECT * FROM user where email='"+email+"' AND password='"+password+"'";
           
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) { 
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setDate_naissance(rs.getDate("date_naissance"));
                user.setDescription(rs.getString("description"));
                user.setProfession(rs.getString("profession"));
                user.setVerified(rs.getBoolean("verified"));
                user.setCode(rs.getString("code"));
                user.setCreated_at(rs.getDate("created_at"));
                user.setBanned(rs.getBoolean("banned"));
                user.setBids(rs.getInt("bids"));
                user.setAddress(rs.getString("address"));
                user.setCode_postal(rs.getInt("code_postal"));
                user.setPhoto(rs.getString("photo"));
                
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        if(user.getId()!=0){
        return user;
        }
        else {
            return null;
        }
        
    }
    public boolean DeleteUser(int id){
        
        //request
        String req = "DELETE FROM `User` WHERE id="+id;
        try {
           Statement st = cnx.createStatement();
           st.executeUpdate(req);
           System.out.println("user deleted");
           return true;
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        System.out.println(" not deleted");
        return false;
    }
    
       public boolean updateUser(int id ,String email, String password, String nom, String prenom, Date date_naissance, String description, String profession, String address, int code_postal, String photo){
           
           //request
        String req = "UPDATE `User` SET email=? , password=? , nom = ? , prenom=? , date_naissance=? , description=? , profession=? , address=? , code_postal=? , photo=?   WHERE id="+id;
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, email);
            st.setString(2, password);
            st.setString(3, nom);
            st.setString(4, prenom);
            st.setDate(5, date_naissance);
            st.setString(6, description);
            st.setString(7, profession);
            st.setString(8, address);
            st.setInt(9, code_postal);
            st.setString(10, photo);
          st.executeUpdate();
            System.out.println("User ajoutée avec succes.");
            return true;
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
           
        return false; 
        
        
       }
       
    @Override
    public List<User> Users() {
        ArrayList<User> users = new ArrayList();
        
        try {
            Statement st = cnx.createStatement();
            String req = "SELECT * FROM user ORDER by created_at DESC";
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {                
                
                users.add(new User(rs.getInt(1), rs.getString("email"), rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date_naissance"),rs.getString("description"),rs.getString("profession") , rs.getString("address") ,rs.getInt("code_postal"), rs.getString("photo")));
                
            }
            
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return users;
    }
    
    public boolean verified(int id ,boolean v){
     //request
        String req = "UPDATE `User` SET verified=? WHERE id="+id;
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setBoolean(1, v);
          
          st.executeUpdate();
            System.out.println("succes.");
            return true;
        }
        catch (SQLException ex) {
          ex.printStackTrace();
        }
        System.out.println("failed");
        return false;
    
    
    }
    public boolean banned(int id ,boolean b){
     //request
        String req = "UPDATE `User` SET banned=? WHERE id="+id;
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setBoolean(1, b);
          
          st.executeUpdate();
            System.out.println("succes.");
            return true;
        }
        catch (SQLException ex) {
          ex.printStackTrace();
        }
        System.out.println("failed");
        return false;
    
    
    }
       

    
}
