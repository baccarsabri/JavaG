/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Projet;
import models.Proposition;
import services.ServiceProposition;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class MesPropositionsController implements Initializable {

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
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private Pane pnlDetailP;
    @FXML
    private Pane det;
    ServiceProposition sp = new ServiceProposition();
    int user_id;
    
    
     
   private Stage stage;
    private Scene scene;
    private Parent parent;   
    @FXML
    private Label tt_prop;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user_id = 4;
            List<Proposition> l = sp.MesPropositions(user_id);
            
            tt_prop.setText(String.valueOf(l.size()));
        Node[] nodes = new Node[l.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("itemListProp.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemListPropController ItemController= fxmlLoader.getController();
           
               ItemController.setData(l.get(i));
               
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
    }    

    @FXML
    private void handleClicks(ActionEvent actionEvent) throws IOException {
        
         if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            
            pnlCustomer.toFront();
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
