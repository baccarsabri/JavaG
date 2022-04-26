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
import models.Projet;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class ItemMesProjetsController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label nom_p;
    @FXML
    private Label min_s;
    @FXML
    private Label max_s;
    @FXML
    private Button detail_b;
    @FXML
    private Button supp;
    
    int user_id;
    int id_pr;
    
    ServiceProjet pr= new ServiceProjet();
    
     private Stage stage;
    private Scene scene;
    private Parent parent;  
    private Parent root; 
    
    Projet p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setData(Projet p){
        nom_p.setText(p.getNom());
        min_s.setText(String.valueOf(p.getMin_salaire()));
        max_s.setText(String.valueOf(p.getMax_salaire())); 
        id_pr=p.getId();
        user_id=4;
        p=p;
        
        
    }

    @FXML
    private void detail(ActionEvent event) throws IOException {
        System.out.println("projet is : "+id_pr);
           
              FXMLLoader loader = new FXMLLoader(getClass().getResource("monProjetDetail.fxml"));
      root = loader.load();
      MonProjetDetailController mp = loader.getController();
     mp.setData(id_pr);
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        
        pr.deleteProjet(id_pr);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("MesProjets.fxml"));
      root = loader.load();
      MesProjetsController mp = loader.getController();
     mp.listAll();
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
}
