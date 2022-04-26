/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Fichier;
import org.controlsfx.control.Notifications;
import services.ServiceFichier;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AjouterFichierController implements Initializable {

    @FXML
    private Button boutonajouter;
    @FXML
    private TextArea text;
    @FXML
    private Button btnRec;
    @FXML
    private Button btnFich;
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
    private Pane col_desc;
    @FXML
    private Pane col_date;
    @FXML
    private Pane col_stat;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Label descr;
    @FXML
    private Button ret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event)throws Exception {
       if((text.getText().equals("")) || (text.getText().equals(" "))||(text.getText().equals("  "))||(text.getText().equals("   "))||(text.getText().equals("    "))||(text.getText().equals("     "))||(text.getText().equals("      "))||(text.getText().equals("       "))||(text.getText().equals("        "))||(text.getText().equals("         "))||(text.getText().equals("          "))||(text.getText().equals("           "))||(text.getText().equals("            "))||(text.getText().equals("             "))||(text.getText().equals("              "))||(text.getText().equals("               "))||(text.getText().equals("                "))||(text.getText().equals("                 "))||(text.getText().equals("                  "))||(text.getText().equals("                   "))||(text.getText().equals("                    "))||(text.getText().equals("                     "))||(text.getText().equals("                      "))||(text.getText().equals("                       "))||(text.getText().equals("                        "))||(text.getText().equals("                         "))||(text.getText().equals("                          "))||(text.getText().equals("                           "))||(text.getText().equals("                            "))||(text.getText().equals("                             "))||(text.getText().equals("                              "))||(text.getText().equals("                               "))||(text.getText().equals("                                "))||(text.getText().equals("                                 "))||(text.getText().equals("                                  "))||(text.getText().equals("                                   "))||(text.getText().equals("                                    "))||(text.getText().equals("                                     "))||(text.getText().equals("                                      "))||(text.getText().equals("                                       "))||(text.getText().equals("                                        "))||(text.getText().equals("                                         "))||(text.getText().equals("                                          "))||(text.getText().equals("                                           "))||(text.getText().equals("                                            "))||(text.getText().equals("                                             "))||(text.getText().equals("                                             "))||(text.getText().equals("                                              "))||(text.getText().equals("                                               "))||(text.getText().equals("                                                "))) {
                       Notifications notifications=Notifications.create();
                       notifications.text("Veuillez saisir le lien du fichier!!");
                       notifications.show();               
            }else{
                   ServiceFichier sf = new ServiceFichier();
                   sf.createFichier(new Fichier(10,text.getText()));
                   Notifications notifications=Notifications.create();
                   notifications.text("Fichier ajouté");
                   notifications.title("Success Message");
                   notifications.show();
                   boutonajouter.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherFichier.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);    
             }       
    }

   @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         ret.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherFichier.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);   
    }
    
   @FXML
    private void aff_rec(ActionEvent event) throws IOException {
        btnRec.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);   
    }

    @FXML
    private void aff_fich(ActionEvent event) throws IOException {
         btnFich.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherFichier.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false); 
    }
    
}
