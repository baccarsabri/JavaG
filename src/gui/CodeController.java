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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceTransaction;
import services.ServiceUser;
import static utils.SessionManager.getUser;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class CodeController implements Initializable {

    @FXML
    private TextField code;
    private String type;
     private Stage stage;
    private Scene scene;
    private Parent parent;
    private int cpt=2;
    
    ServiceUser u = new ServiceUser();

    ServiceTransaction t= new ServiceTransaction();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void settype(String type){
    this.type=type;
    }

    @FXML
    private void submit(ActionEvent event) throws IOException {
        String cc= u.getCode(getUser());
        
        if(cpt!=0 && code.getText().equals(cc)){
            t.transaction(getUser(), type );
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Success !");
            alert.setContentText("Bids acheter ");
            alert.show();
             Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
          u.setcode(getUser(),null );
            
        }
        else {
            if (cpt==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error !");
            alert.setContentText("Vous avez utilisée toutes vos nombres de repetition");
            alert.show();
            
         Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
            }
            else {
                 cpt=cpt-1;
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error !");
            alert.setContentText("code incorrect il vous reste que "+(cpt+1)+" tentative");
            alert.show();
            }
        
           
            
        
        }
    }
    
}
