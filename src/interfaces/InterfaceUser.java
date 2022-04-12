/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Date;
import java.util.List;
import models.User;

/**
 *
 * @author bacca
 */
public interface InterfaceUser {
    
    public User UserDetails(int id);
    public User addUser(User user);
    public User login(String email , String password);
    public boolean DeleteUser(int id);
    public boolean updateUser(int id ,String email, String password, String nom, String prenom, Date date_naissance, String description, String profession, String address, int code_postal, String photo);
    public List<User> Users(); 
    public boolean verified(int id ,boolean v);
    public boolean banned(int id , boolean b);
    public User getUserByEmail(String email);
      
   
    
}
