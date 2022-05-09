/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.stage.Stage;
import models.Projet;
import models.Proposition;
import services.ServiceProposition;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class DetailPController implements Initializable {

    @FXML
    private Label id_p;
    @FXML
    private Label nom_p;
    @FXML
    private Label s_min;
    @FXML
    private Label s_max;
    @FXML
    private Label desc;
    @FXML
    private Label statut;
    
    ServiceProposition sprop = new ServiceProposition();
    @FXML
    private Button modifier;
    
     private Stage stage;
    private Scene scene;
    private Parent parent;  
    private Parent root; 
    
    int id_pr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Projet p,String from){
        id_pr=p.getId();
        id_p.setText(id_p.getText()+p.getId());
        nom_p.setText(nom_p.getText()+p.getNom());
        s_min.setText(s_min.getText()+String.valueOf(p.getMin_salaire()));
        s_max.setText(s_max.getText()+String.valueOf(p.getMax_salaire()));
        desc.setText(desc.getText()+p.getDescription());
        statut.setText(statut.getText()+p.getStatut());
        
         if(from=="all"){
            modifier.setVisible(false);
           
        }
        
       // List<Proposition> l = sprop.PropoisitionsByProj(p.getId());
        
        //bidders.setText(bidders.getText()+String.valueOf(l.size()));
        
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("monProjetDetail.fxml"));
      root = loader.load();
      MonProjetDetailController mp = loader.getController();
     mp.setData(id_pr);
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
}
