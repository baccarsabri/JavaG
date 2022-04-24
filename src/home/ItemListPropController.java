/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Proposition;
import services.ServiceProposition;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class ItemListPropController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label prix;
    @FXML
    private Label date;
    @FXML
    private Label desc;
    @FXML
    private Button modif;
    @FXML
    private Button supp;
    
    ServiceProposition sp =new ServiceProposition();

    int id_prop;
    
     private Stage stage;
    private Scene scene;
    private Parent parent;  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void setData(Proposition p){
        prix.setText(String.valueOf(p.getPrix()));
        date.setText(String.valueOf(p.getDate_max()));
        desc.setText(p.getStatut()); 
        id_prop=p.getId();
    }
    @FXML
    private void modif(ActionEvent event) {
    }

    @FXML
    private void supp(ActionEvent event) throws IOException {
        sp.deleteProposition(id_prop);
               Parent root = FXMLLoader.load(getClass().getResource("MesPropositions.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        
    }
    
}
