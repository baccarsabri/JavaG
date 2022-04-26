/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsi;

import java.sql.Connection;
import java.util.List;
import models.User;
import services.ServiceTransaction;
import services.ServiceUser;
import utils.MaConnexion;
import javafx.fxml.FXML;
import models.Transaction;

/**
 *
 * @author bacca
 */
public class Lancitounsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // TODO code application logic he
        long millis=System.currentTimeMillis();  
        java.sql.Date now=new java.sql.Date(millis);  
        
     
        MaConnexion instance = MaConnexion.getInstance();
        Connection cnx = instance.getCnx();
        
        ServiceUser s=new ServiceUser();
        ServiceTransaction t= new ServiceTransaction();
        User user= s.UserDetails(1);
        
        
        // o
        User u;
       // u = new User( "sabri@gmail.com" , "password" , "malek" , "abassisse" , now , "ok" , "ok" , true , "1234", now , false , 100, "tunis", 2015, "sabri");
        //s.addUser(u);
        
        User a=s.login("baccar_sabri@hotmail.com", "12345678");
        
       // t.transaction(user, "BASIC_PLANS");
       
       //boolean test=s.updateUser(2 ,"sabribaccar6@gmail.com", "12345678", "ghofrahn", "sabri", now, "okey", "developper", "la goulette", 2015, "photo2");
       System.out.println("user"+a.getAddress());
       List<User> l=s.Users();
       s.signup(a);
       System.out.println("hehehehehh");
       List<Transaction> mm=t.AllTransactions(user);
       System.out.println(mm);
       

    }
    
}
