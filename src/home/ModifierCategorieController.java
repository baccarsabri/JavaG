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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import models.catégorie;
import services.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class ModifierCategorieController implements Initializable {

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
    private TextField cnom;
    @FXML
    private Button cmodify;
    ServiceCatégorie sc=new ServiceCatégorie();
    catégorie c=new catégorie();
    int id;
    String ca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setData(c);
    }    
    public void setData( catégorie c )
    {
       id=c.getId();
      ca=c.getNom();
      cnom.setText(ca);    
    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void modify(ActionEvent event) {
        try {
    
          java.util.Date date = new java.util.Date();
           java.sql.Date myDate = new java.sql.Date(date.getTime()); 
           catégorie cat =new catégorie(id,cnom.getText());
            System.out.println(cnom.getText());
        sc.updateCatégorie(cat);     
        
        
            System.out.println(id);
        JOptionPane.showMessageDialog(null, "Catégorie modifiée");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MesCategories.fxml"));
            Parent root = loader.load(); 
            cnom.getScene().setRoot(root);
        }catch (IOException ex) {
            Logger.getLogger(ModifierCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
