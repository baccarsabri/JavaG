/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import models.Projet;
import models.Proposition;
import services.ServiceProjet;
import services.ServiceProposition;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class DProjetController implements Initializable {

    
    
    ServiceProjet sp =new ServiceProjet();
    ServiceProposition sprop = new ServiceProposition();
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
    private Parent root;  
    
    int user_id;
    @FXML
    private Label tt_prop;
    @FXML
    private ScrollPane listProp;
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
    
     public void display(int id , String from){
        Projet p = sp.detailProjet(id);
       List<Proposition> l = sprop.PropoisitionsByProj(id);
       tt_prop.setText(String.valueOf(l.size()));
        
       
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("detailP.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  DetailPController ItemController= fxmlLoader.getController();
           
               ItemController.setData(p,from);
               
                det.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
           
           
           
             Node[] nodes = new Node[l.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(Main.class.getResource("itemUserProp.fxml"));
           try {
               Pane pane = fxmlLoader1.load();
               
               
                  ItemUserPropController ItemController1= fxmlLoader1.getController();
           
               ItemController1.setData(l.get(i),from);
               
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
     
     }
    
    
    
    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
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
    
}