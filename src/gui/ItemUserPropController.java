/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Proposition;
import models.User;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class ItemUserPropController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label min_s;
    @FXML
    private Label max_s;
    String a ="aa";
    ServiceUser su = new ServiceUser();
    @FXML
    private Label nom_u;
    @FXML
    private Button accepter;
    @FXML
    private Button supprimer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setData(Proposition p,String from){
       
        User u = su.UserDetails(p.getUser_id());
       
        
         System.out.println("User : "+u.getNom());
        
        nom_u.setText(p.getNomUser());
        min_s.setText(String.valueOf(p.getPrix()));
        max_s.setText(String.valueOf(p.getDate_max())); 
        
        if(from=="all"){
            accepter.setVisible(false);
            supprimer.setVisible(false);
        }
        
        
    }

    @FXML
    private void accepter(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    
}
