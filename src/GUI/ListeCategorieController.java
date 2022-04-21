/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import models.catégorie;
import services.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class ListeCategorieController implements Initializable {

    @FXML
    private ListView<String> cat;
    @FXML
    private Button mod;
    @FXML
    private Button bsup;
List<catégorie> liste = new ArrayList<>();
    ServiceCatégorie cats= new ServiceCatégorie();
    @FXML
    private TextField search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
          List<catégorie> liste = new ArrayList<>();
     liste = cats.readCatégories();
         
         liste.forEach((l) -> {
             cat.getItems().addAll(l.getNom()); 
        });   

       }    

    @FXML
    private void modi(ActionEvent event) {
    }

    @FXML
    private void supp(ActionEvent event) {
     
                    liste = cats.readCatégories();
           int a= liste.get(cat.getSelectionModel().getSelectedIndex()).getId();                 
                 cats.DeleteCatégorie(a);
              
                 
       }    

    @FXML
    private void rechercher(ActionEvent event) {
           List<catégorie> liste = new ArrayList<>();
                               liste = cats.readCatégories();


 
        String title=search.getText();
          liste =  cats.RechercherparNom(title);
   
         
         liste.forEach((l) -> {
             cat.getItems().addAll(l.getNom()); 
        });   
       

                 }
   
   
        
        
      

   

    
    }    



