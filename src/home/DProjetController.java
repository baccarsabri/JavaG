/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import models.Projet;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class DProjetController implements Initializable {

    
    
    ServiceProjet sp =new ServiceProjet();
    @FXML
    private VBox pnItems = null;
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
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlDetailP;
    
    @FXML
    private Pane det;
    
    
    
   private Stage stage;
    private Scene scene;
    private Parent parent;   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           /*  Projet p = sp.detailProjet(1);
        
       
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("detailP.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  DetailPController ItemController= fxmlLoader.getController();
           
               ItemController.setData(p);
               
                pnlDetailP.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
       */
       
        
    }  
    
     @FXML
     public void display(int id){
        Projet p = sp.detailProjet(id);
        
       
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("detailP.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  DetailPController ItemController= fxmlLoader.getController();
           
               ItemController.setData(p);
               
                pnlDetailP.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
     
     }
    
    
    
    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnCustomers) {
            
        }
        if (actionEvent.getSource() == btnMenus) {
            
           pnlDetailP.setStyle("-fx-background-color : #02030A");
           det.setStyle("-fx-background-color : #02030A");
            pnlDetailP.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
           Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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
        }
    }
    
}
