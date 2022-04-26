/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modifierContrat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.catégorie;
import models.contrat;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class Controller implements Initializable {

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
    private Label tt_pr;
    @FXML
    private VBox pnItems;
    @FXML
    private Button cmodify;
    @FXML
    private ComboBox<String> statut;
      int id ;
      String ca;
      contrat c=new contrat();
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statut.getItems().add("Pending");
        statut.getItems().add("Finished");
        setData(c);
        // TODO
    }    
    public void t()
    {
        
    }
 public void setData( contrat c )
    {
       id=c.getId();
      ca=c.getStatut();
       
    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void modify(ActionEvent event) {
       
    }
    
}
