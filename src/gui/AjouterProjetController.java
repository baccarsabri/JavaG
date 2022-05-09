/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import static gui.ItemPropController.isNumeric;
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
import utils.Mailer;
import utils.wordDetect;

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
     private Parent root; 
    
    ServiceProjet spr = new ServiceProjet();
    wordDetect wd = new wordDetect();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
        private void handleClicks(ActionEvent actionEvent) throws IOException {
        
            user_id=4;
        if (actionEvent.getSource() == btnCustomers) {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("MesProjets.fxml"));
      root = loader.load();
      MesProjetsController mp = loader.getController();
     mp.listAll();
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
        
        if (actionEvent.getSource() == btnOverview) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
      root = loader.load();
      Controller c = loader.getController();
      c.listell();
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
        if(actionEvent.getSource()==btnOrders)
        {
               Parent root = FXMLLoader.load(getClass().getResource("MesPropositions.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        } if(actionEvent.getSource()==btnMenus)
        {
               Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
        
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException, InterruptedException {
        
          
        
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
        }else if(wd.testAng(desc.getText())==true || wd.testWithFile(desc.getText())==true){
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur!");
            alert.setContentText("Texte malveillant !");
            alert.show();
            String message = "<i>Attention!</i><br>";
        message += "<b>Interdit de publier cette proposition!</b><br>";
        message += "<font color=red>Essayer de ne pas faire ca</font>";
            Mailer.send("gamesmalek2@gmail.com","Malek*123", "malekabasise@gmail.com", "Avertissement",  message);
            
        }else
        
       {
            
            
            System.out.println("okkk");
            
            user_id=4;
             
            Projet p = new Projet(user_id,nom.getText(),desc.getText(),Integer.parseInt(prix_min.getText()),Integer.parseInt(prix_max.getText()),"pending");
            spr.createProjet(p);
            
            
              FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
      root = loader.load();
      Controller c = loader.getController();
      c.listell();
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
            
        }
    }

    
}
