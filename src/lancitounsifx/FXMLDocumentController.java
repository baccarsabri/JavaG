/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Reclamation;
import org.controlsfx.control.Notifications;
import services.ServiceReclamation;

/**
 *
 * @author Oussama Fdhila
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextArea desc;
    @FXML
    private Button boutonajouter;
   
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws Exception {
         if(desc.getText().equals("")){
                       Notifications notifications=Notifications.create();
                       notifications.text("Hello please fill the required field");
                       notifications.show();             
            }else{
                   ServiceReclamation se = new ServiceReclamation();
                   java.util.Date date = new java.util.Date();
                   java.sql.Date myDate = new java.sql.Date(date.getTime());
                   se.createReclamation(new Reclamation(desc.getText(),myDate,"pending"));
                   Notifications notifications=Notifications.create();
                   notifications.text("Reclamation ajoutée");
                   notifications.title("Success Message");
                   notifications.show();
                   boutonajouter.getScene().getWindow().hide();
                  // Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
                 Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamationBack.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);    
             }       
       
       
    }

 

  
    
}
