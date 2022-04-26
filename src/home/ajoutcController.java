/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.contrat;
import services.ServiceContrat;
import utils.EmailSender;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class ajoutcController implements Initializable {

    ServiceContrat ct = new ServiceContrat();

    @FXML
    private TextField cprix;
    @FXML
    private ComboBox<String> cstatut;
    @FXML
    private Label pfinis;
    @FXML
    private Label pencours;
    @FXML
    private Button ajout;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
        cstatut.getItems().add("Pending");
        cstatut.getItems().add("Finished");
        System.out.println("a");
        float fini = ct.Sommetotalefini();
        String a = String.valueOf(fini);
        float encours = ct.Sommetotaleencours();
        String b = String.valueOf(encours);
        pfinis.setText(a);
        pencours.setText(b);

        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) throws Exception {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        float f = Float.parseFloat(cprix.getText());
        
        System.out.println(f);
      
        if (f<=0 ) {
            JOptionPane.showMessageDialog(null, "Vous devez saisir un prix valide positif et different de 0  ");
          
        }
        else if(cstatut.getSelectionModel().getSelectedIndex()==-1 )
        {
            JOptionPane.showMessageDialog(null, "Vous devez séléctionner l'etat du contrat ");
        }
        
        else 
        {
            
                    EmailSender.sendEmailWithAttachments("samaali.mohamedyassine@esprit.tn", "Contrat Ajouté ", "Le contrat ayant le prix " +f+ " a éte ajouté avec succés le " +sqlDate+"");

              contrat c = new contrat(1, 1, f, sqlDate, cstatut.getValue());
              System.out.println(f);
            ct.createContrat(c);
            
            ajout.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ContratController.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            
            }
        }
  
    }


