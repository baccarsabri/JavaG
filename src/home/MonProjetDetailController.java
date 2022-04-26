/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Projet;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class MonProjetDetailController implements Initializable {

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
    private TextField nom;
    @FXML
    private TextField pmin;
    @FXML
    private TextField pmax;
    @FXML
    private TextArea desc;
    @FXML
    private Label statut;
    @FXML
    private Button btn;
    
     private Stage stage;
    private Scene scene;
    private Parent parent;  
      private Parent root;
    private Parent root1;
    
    int user_id;
    int  p_id;
    
     ServiceProjet sp =new ServiceProjet();

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
    private void modifier(ActionEvent event) throws IOException {
        user_id=4;
        
        System.out.println("to change "+ nom.getText());
        
        sp.updateProjet(p_id, nom.getText(),desc.getText(), Double.parseDouble(pmin.getText()),Double.parseDouble(pmax.getText()) );
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MesProjets.fxml"));
      root = loader.load();
      MesProjetsController mp = loader.getController();
     mp.listAll();
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
    @FXML
      public void setData(int id ){
          Projet pS = sp.detailProjet(id);
          statut.setText(pS.getStatut());
        nom.setText(pS.getNom());
        pmin.setText(String.valueOf(pS.getMin_salaire()));
        pmax.setText(String.valueOf(pS.getMax_salaire())); 
        desc.setText(pS.getDescription());
        p_id=pS.getId();
        user_id=4;
        
        
    }
    
}
