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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.User;
import utils.SessionManager;
import services.ServiceUser;
import static utils.SessionManager.setUser;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField password;
    ServiceUser u = new ServiceUser();
    @FXML
    private Text affiche;
    
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        
      if (email.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie l'email");
            alert.show();

      }
      else{
      if (password.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie le mot de passe");
            alert.show();

      }
      else  {
       User user= u.login(email.getText(), password.getText());
     String e="error";
     System.out.println(user);
     if(user != null){
         System.out.println("this is "+user);
       setUser(user);
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
      root = loader.load();
      Controller c = loader.getController();
      c.listell();
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
     else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de connexion!");
            alert.setContentText("Email ou mot de passe incorrect");
            alert.show();
     }
      }
      }
      
    
    }

    @FXML
    private void verssignup(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    
}
