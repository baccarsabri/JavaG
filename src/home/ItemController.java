
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.contrat;
import services.ServiceContrat;
import services.ServiceProjet;

/**
 * FXML ContratController class
 *
 * @author 21655
 */
public class ItemController implements Initializable {
    
    private ContratController cont;

    ServiceProjet sp =new ServiceProjet();
    
    

    
     private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent root1;
    
    int id ;
    
    int user_id;
    @FXML
    private Label col_prix;
    @FXML
    private Label coll_date;
    @FXML
    private Label col_stat;
    @FXML
    private Button suppr;
    @FXML
    private Button modif;
    Runnable runnable;
    public contrat currentc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        
    } 
    
    
    public void setData(contrat c){
        currentc = c;
        
        col_prix.setText(String.valueOf(c.getPrix())); 
        coll_date.setText(String.valueOf(c.getCreated_at()));
        col_stat.setText(c.getStatut());;

        
        id=c.getId();
       
        
    }
      public void setController(Runnable c)
    {
        runnable = c;
    }

  
   

    @FXML
    private void delete(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete this contract?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
        ServiceContrat SC= new ServiceContrat();
                System.out.println("id deleted is " + id);
                SC.Deletecontrat(id);
                runnable.run();
                JOptionPane.showMessageDialog(null, "Contract deleted!");
            }
    }

    @FXML
    private void modify(ActionEvent event) throws IOException {
           modif.getScene().getWindow().hide();
                   FXMLLoader loader = new FXMLLoader();
                  loader.setLocation(getClass().getResource("modifierContrat.fxml"));
                    Parent root = loader.load();
                    ((modifiercontrat)loader.getController()).setData(currentc);
                    
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);   
    }
    
}
