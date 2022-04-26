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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ServiceUser;
import static utils.SessionManager.getUser;
import static utils.SessionManager.setUser;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class HomeController implements Initializable {

    @FXML
    private Text user;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    @FXML
    private Text nbBids;
    ServiceUser u = new ServiceUser();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (getUser().getNom()!=null){
              user.setText("Hello "+ getUser().getNom());
        }
        int b= u.getBids(getUser());
        nbBids.setText("Vous avez "+b + " Bids ");
      
    }    

    @FXML
    private void versBids(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource(  "buyBids.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        
         setUser(null);
         Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        
        
    }

    @FXML
    private void transaction(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Transactions.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
}
