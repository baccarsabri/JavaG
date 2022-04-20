/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Fichier;
import org.controlsfx.control.Notifications;
import services.ServiceFichier;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AjouterFichierController implements Initializable {

    @FXML
    private Label link;
    @FXML
    private Button boutonajouter;
    @FXML
    private ImageView img;
    @FXML
    private Label ajt;
    @FXML
    private TextField text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event)throws Exception {
        if(text.getText().equals("")){
                       Notifications notifications=Notifications.create();
                       notifications.text("Hello please fill the required field");
                       notifications.show();             
            }else{
                   ServiceFichier sf = new ServiceFichier();
                   sf.createFichier(new Fichier(10,text.getText()));
                   Notifications notifications=Notifications.create();
                   notifications.text("Fichier ajouté");
                   notifications.title("Success Message");
                   notifications.show();
                   boutonajouter.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherListeFichier.fxml"));
               // Parent root = FXMLLoader.load(getClass().getResource("AfficherFichier.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);    
             }       
    }
 
    
}
