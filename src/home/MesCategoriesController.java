/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.catégorie;
import models.contrat;
import services.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class MesCategoriesController implements Initializable {
ServiceCatégorie ca = new ServiceCatégorie();

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
    private Label tt_pr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
       } 
   
    public void show()
    {
        pnItems.getChildren().clear();
        List<catégorie> l = ca.readCatégories();
       tt_pr.setText(String.valueOf(l.size()));
        Node[] nodes = new Node[l.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("itemListcategorie.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemListcategorieController ItemController= fxmlLoader.getController();
           
               ItemController.setData(l.get(i));
              
               ItemController.setController(new Runnable() {
                   @Override
                   public void run() {
                       show();
                   }
                    });
               
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(MesCategoriesController.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
        
         

    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }
    
}
