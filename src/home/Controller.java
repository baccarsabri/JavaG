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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Projet;
import services.ServiceProjet;

public class Controller implements Initializable {
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
    private Pane pnlDetailP;
    
    @FXML
    private Pane det;
    
    
    
   private Stage stage;
    private Scene scene;
    private Parent parent;   
    @FXML
    private Label tt_pr;
    @FXML
    private Button bt_add_pr;
    
  
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       List<Projet> l = sp.readProjets();
       tt_pr.setText(String.valueOf(l.size()));
        Node[] nodes = new Node[l.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("Item.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemController ItemController= fxmlLoader.getController();
           
               ItemController.setData(l.get(i));
               
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
        
        

    }
    
    
     


@FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
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
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
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

    @FXML
    private void addProjet(ActionEvent actionEvent) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ajouterProjet.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
}
