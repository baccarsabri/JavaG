/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import models.catégorie;
import services.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private TextField cacategorie;
    @FXML
    private ImageView img;
    @FXML
    private Button ajt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void lllll(ActionEvent event) {
        
       catégorie c=new catégorie(cacategorie.getText());
       ServiceCatégorie cat=new ServiceCatégorie() ;

        cat.createCatégorie(c);
        
        
    }
    
}
