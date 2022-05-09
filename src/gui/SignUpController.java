/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import services.ServiceUser;
import static utils.SessionManager.setUser;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirm_password;
    
     
    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    ServiceUser u = new ServiceUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signup(ActionEvent event) throws IOException {
        if (email.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie l'email");
            alert.show();

      }
      else{
      if (password.getText().length() < 7 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie le mot de passe");
            alert.show();

      }
      else{
       if (confirm_password.getText().length() == 0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas confirmer votre mot de passe");
            alert.show();

      }
       else{
           if (!(confirm_password.getText().toString().equals(password.getText().toString()))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas taper le meme mot de passe");
            alert.show();

      }
           else{
            if (u.getUserByEmail( email.getText()) !=null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur!");
            alert.setContentText("Email existe");
            alert.show();
            }
            else{
                
             User user= new User(email.getText(),password.getText());
             
             u.signup(user);
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Success !");
            alert.setContentText("Votre compte a éte crée");
            alert.show();
            
            
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
            }
               
          
           
           }
       
       
       }
      }
        }
        
    }

    @FXML
    private void verslogin(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
}
