/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

import home.Controller;

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
import services.ServiceProposition;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class ItemController implements Initializable {
    
    private Controller cont;

    ServiceProjet sp =new ServiceProjet();
    ServiceProposition sprop =new ServiceProposition();
    
    Projet projet;
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
    private Button prop_b;

    
     private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent root1;
    
    int a ;
    
    int user_id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        
    } 
    
    
    public void setData(Projet p){
        nom_p.setText(p.getNom());
        min_s.setText(String.valueOf(p.getMin_salaire()));
        max_s.setText(String.valueOf(p.getMax_salaire())); 
        a=p.getId();
        user_id=4;
        if (sprop.verifProp(user_id, a)==false){
            
            prop_b.setVisible(false);
        }
        
    }

    @FXML
    private void detail(ActionEvent event) throws IOException {
        System.out.println("//////////////"+a);
      FXMLLoader loader = new FXMLLoader(getClass().getResource("DProjet.fxml"));
      root = loader.load();
      DProjetController dp = loader.getController();
      dp.display(a);
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
      
     
        
    }

    @FXML
    private void proposer(ActionEvent event) throws IOException {
        
        System.out.println("will send"+a);
        
          System.out.println("///Proppppp"+a);
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Proposer.fxml"));
      root = loader.load();
       
      
      ProposerController pc = loader.getController();
      pc.setData(a);
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        
    }
    
}
