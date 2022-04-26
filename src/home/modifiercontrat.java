/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.catégorie;
import models.contrat;
import services.ServiceContrat;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class modifiercontrat implements Initializable {

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
    private ComboBox<String> statut;
    @FXML
    private Button cmodify;
         int id ;
      String ca;
      float prix;
      contrat c=new contrat();
      ServiceContrat ser=new ServiceContrat();
private Stage stage;
    private Scene scene;
    private Parent parent; 
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

    
    public void setData( contrat c )
    {
       id=c.getId();
      ca=c.getStatut();
      prix=c.getPrix();
      
       
    }

    
    
    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("MesCategories.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        
    }

    @FXML
    private void modify(ActionEvent event) throws IOException {
        try{
         java.util.Date date = new java.util.Date();
           java.sql.Date myDate = new java.sql.Date(date.getTime()); 
           contrat c = new contrat(id,1, 1,prix , myDate, statut.getValue());
        
           // System.out.println(cnom.getText());
        ser.updatecontrat(c);
        
        
            System.out.println(id);
        JOptionPane.showMessageDialog(null, "Contrat modifié");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ContratController.fxml"));
            Parent root = loader.load(); 
           statut.getScene().setRoot(root);
        }catch (IOException ex) {
            Logger.getLogger(ModifierCategorieController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
}
