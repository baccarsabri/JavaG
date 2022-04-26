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
import static jdk.nashorn.internal.runtime.Debug.id;
import models.Reclamation;
import services.ServiceReclamation;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class ItemBController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label col_desc;
    @FXML
    private Label col_date;
    @FXML
    private Label col_stat;
    @FXML
    private Button suppr;
    @FXML
    private Button boutonmodifier;
    public Reclamation currentRec;
    ServiceReclamation sr=new ServiceReclamation();
    Runnable runnable;
    int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   public void setData(Reclamation r){
        currentRec = r;
        col_desc.setText(r.getDescription());
        col_date.setText(String.valueOf(r.getDate_de_reclamation()));
        col_stat.setText(r.getStatut()); 
        id=r.getId();
        
    }
    
    public void setController(Runnable c)
    {
        runnable = c;
    }
    @FXML
    private void supprimer(ActionEvent event) throws IOException {
  
        //R = listRec.getSelectionModel().getSelectedItem();
        
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("vous êtes sûr de supprimer la réclamation?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                ServiceReclamation SR= new ServiceReclamation();
                System.out.println("id deleted is " + id);
                SR.deleteReclamation(id);
                runnable.run();
                JOptionPane.showMessageDialog(null, "Réclamation supprimée");
            }
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
                   boutonmodifier.getScene().getWindow().hide();
                   FXMLLoader loader = new FXMLLoader();
                  loader.setLocation(getClass().getResource("ModifierReclamationBack.fxml"));
                    Parent root = loader.load();
                    ((ModifierReclamationBackController)loader.getController()).setData(currentRec);
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);    
             }
    
}
