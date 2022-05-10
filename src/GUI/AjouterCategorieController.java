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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.catégorie;
import services.ServiceCatégorie;


/**
 * FXML Controller class
 *
 * @author 21655
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlDetailP;
    @FXML
    private TextField cacategorie;
    @FXML
    private Button ajt;
ServiceCatégorie cat=new ServiceCatégorie() ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

   @FXML
    private void lllll(ActionEvent event) throws IOException {
     List test= new ArrayList();
           test=  cat.RechercherparNom(cacategorie.getText());
   
        if(cacategorie.getText().trim().equals(""))
        {
             JOptionPane.showMessageDialog(null, "Veuillez saisir un nom de catégorie   ");
        }
        
        else if(!test.isEmpty())
        {
                       JOptionPane.showMessageDialog(null, "Nom d'une catégorie qui existe déja  ");
  
        }
        else{
        catégorie c=new catégorie(cacategorie.getText());
      

        cat.createCatégorie(c);
        
         ajt.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("MesCategories.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        }
    }
    
}

