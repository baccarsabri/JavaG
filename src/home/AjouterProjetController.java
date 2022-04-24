/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

import static home.ItemPropController.isNumeric;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Projet;
import models.Proposition;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class AjouterProjetController implements Initializable {

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
    private TextField nom;
    @FXML
    private TextField prix_min;
    @FXML
    private TextField prix_max;
    @FXML
    private TextArea desc;
    @FXML
    private Button btn;
    
     int user_id;
    
     private Stage stage;
    private Scene scene;
    private Parent parent; 
    
    ServiceProjet spr = new ServiceProjet();

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
    private void ajouter(ActionEvent event) throws IOException {
        
          
        
        if(nom.getText().isEmpty() || prix_min.getText().isEmpty() || prix_max.getText().isEmpty() ||desc.getText().isEmpty()){
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur");
            alert1.setHeaderText("Erreur!");
            alert1.setContentText("Veuillez remplir tout les champs ! ");
            alert1.show();
            
        }else if(isNumeric(prix_min.getText())==false ||isNumeric(prix_max.getText())==false  ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur!");
            alert.setContentText("Le prix doit etre un nombre ");
            alert.show();
        }else
        
       {
            
            
            System.out.println("okkk");
            
            user_id=4;
             
            Projet p = new Projet(user_id,nom.getText(),desc.getText(),Integer.parseInt(prix_min.getText()),Integer.parseInt(prix_max.getText()),"pending");
            spr.createProjet(p);
            
            
              Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
            
        }
    }

    
}
