/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Fichier;
import services.ServiceFichier;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class ItemFController implements Initializable {

    @FXML
    private Label col_link;
    @FXML
    private Button suppr;
    @FXML
    private Button boutonmodifier;
    @FXML
    private HBox itemFich;
    Runnable runnable;
 int id;
ServiceFichier sf= new ServiceFichier();
public Fichier currentRec;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Fichier f){
        currentRec = f;
        col_link.setText(f.getLink());
        id=f.getId();
    }
      public void setController(Runnable c)
    {
        runnable = c;
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("vous êtes sûr de supprimer ce fichier?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                ServiceFichier SF= new ServiceFichier();
                System.out.println("id deleted is " + id);
                SF.deleteFichier(id);
                runnable.run();
                JOptionPane.showMessageDialog(null, "Fichier supprimé");
                //loadReclamations();
            }
  
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
                   boutonmodifier.getScene().getWindow().hide();
                   FXMLLoader loader = new FXMLLoader();
                   loader.setLocation(getClass().getResource("ModifierFichier.fxml"));
                    Parent root = loader.load();
                    ((ModifierFichierController)loader.getController()).setData(currentRec);
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);    
    }
    
}
