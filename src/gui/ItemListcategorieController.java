/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Proposition;
import models.catégorie;
import services.ServiceCatégorie;
import services.ServiceContrat;
import services.ServiceProposition;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class ItemListcategorieController implements Initializable {

    @FXML
    private HBox itemC;
    private Label prix;
    private Label date;
    private Label desc;
    
    ServiceProposition sp =new ServiceProposition();
    ServiceCatégorie c = new ServiceCatégorie();
            
    int id_cat;
    public catégorie currentRec;
    
     private Stage stage;
    private Scene scene;
    private Parent parent;  
    @FXML
    private Label cat;
    @FXML
    private Button suppr;
    @FXML
    private Button modif;
        Runnable runnable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void setData(catégorie c){
       currentRec = c;
        cat.setText(c.getNom()); 
        id_cat=c.getId();
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
            alert.setContentText("Are you sure to delete this categorie ?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
        ServiceCatégorie SC= new ServiceCatégorie();
                System.out.println("id deleted is " + id_cat);
                SC.DeleteCatégorie(id_cat);
                runnable.run();
                JOptionPane.showMessageDialog(null, "catégorie  deleted!");
            }
    }


    @FXML
    private void modify(ActionEvent event) throws IOException {
        modif.getScene().getWindow().hide();
                   FXMLLoader loader = new FXMLLoader();
                  loader.setLocation(getClass().getResource("ModifierCategorie.fxml"));
                    Parent root = loader.load();
                    ((ModifierCategorieController)loader.getController()).setData(currentRec);
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);   
    }
    

    
    
}
