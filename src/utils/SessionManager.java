/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import models.User;

/**
 *
 * @author bacca
 */
public class SessionManager {
    
   
    
    private static User  user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        SessionManager.user = user;
    }
    
    
    

    

    
}
