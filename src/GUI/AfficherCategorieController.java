/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import models.catégorie;
import services.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class AfficherCategorieController implements Initializable {
  @FXML
    private TableView<catégorie > TableCategorie;
    @FXML
    private TableColumn<catégorie , String> col_nom;
    @FXML
    private ImageView img;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ServiceCatégorie con= new ServiceCatégorie();
         List<catégorie> af =con.readCatégories();
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    
        TableCategorie.getItems().setAll(af); 
        
        
        
        
        
        
        
        
    }    
    
}
