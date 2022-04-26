/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Reclamation;
import org.controlsfx.control.Notifications;
import services.ServiceReclamation;
import utils.MaConnexion;

/**
 *
 * @author Oussama Fdhila
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextArea desc;
    @FXML
    private Button boutonajouter;
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
    private Pane pnlOverview;
    @FXML
    private Pane col_desc;
    @FXML
    private Pane col_date;
    @FXML
    private Pane col_stat;
    @FXML
    private Label descr;
    @FXML
    private Button ret;
    @FXML
    private Button btnRec;
    @FXML
    private Button btnFich;
    @FXML
    private Label CaptchaCode;
    @FXML
    private TextField captchaField;

  
  
   
  private static String GeneratedCode;

    private final int totalattempts = 5;
    private static int nbOfClicks = 0;
    ServiceReclamation sr=new ServiceReclamation();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLDocumentController.GeneratedCode = sr.CreateCaptchaValue();
        CaptchaCode.setText(FXMLDocumentController.GeneratedCode);
        MotionBlur mb = new MotionBlur();
        mb.setRadius(7.0f);
        mb.setAngle(30.0f);

//        CaptchaCode.setCache(true);
        CaptchaCode.setEffect(mb);
    }    


    
    @FXML
    private void ajouter(ActionEvent event) throws Exception {
      String captcha_code = captchaField.getText();
     if( (captcha_code.isEmpty())||(desc.getText().equals("")) || (desc.getText().equals(" "))||(desc.getText().equals("  "))||(desc.getText().equals("   "))||(desc.getText().equals("    "))||(desc.getText().equals("     "))||(desc.getText().equals("      "))||(desc.getText().equals("       "))||(desc.getText().equals("        "))||(desc.getText().equals("         "))||(desc.getText().equals("          "))||(desc.getText().equals("           "))||(desc.getText().equals("            "))||(desc.getText().equals("             "))||(desc.getText().equals("              "))||(desc.getText().equals("               "))||(desc.getText().equals("                "))||(desc.getText().equals("                 "))||(desc.getText().equals("                  "))||(desc.getText().equals("                   "))||(desc.getText().equals("                    "))||(desc.getText().equals("                     "))||(desc.getText().equals("                      "))||(desc.getText().equals("                       "))||(desc.getText().equals("                        "))||(desc.getText().equals("                         "))||(desc.getText().equals("                          "))||(desc.getText().equals("                           "))||(desc.getText().equals("                            "))||(desc.getText().equals("                             "))||(desc.getText().equals("                              "))||(desc.getText().equals("                               "))||(desc.getText().equals("                                "))||(desc.getText().equals("                                 "))||(desc.getText().equals("                                  "))||(desc.getText().equals("                                   "))||(desc.getText().equals("                                    "))||(desc.getText().equals("                                     "))||(desc.getText().equals("                                      "))||(desc.getText().equals("                                       "))||(desc.getText().equals("                                        "))||(desc.getText().equals("                                         "))||(desc.getText().equals("                                          "))||(desc.getText().equals("                                           "))||(desc.getText().equals("                                            "))||(desc.getText().equals("                                             "))||(desc.getText().equals("                                              "))||(desc.getText().equals("                                               "))||(desc.getText().equals("                                                "))||(desc.getText().equals("                                                 "))||(desc.getText().equals("                                                  "))||(desc.getText().equals("                                                   "))||(desc.getText().equals("                                                    "))||(desc.getText().equals("                                                     "))||(desc.getText().equals("                                                      "))) {
                       Notifications notifications=Notifications.create();
                       notifications.text("Veuillez saisir votre réclamation!!");
                       notifications.show();                   
            }else if (!captchaField.getText().equals(FXMLDocumentController.GeneratedCode)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("WrongCaptchaCode");
            alert.showAndWait();
            }else{
                   ServiceReclamation se = new ServiceReclamation();
                   java.util.Date date = new java.util.Date();
                   java.sql.Date myDate = new java.sql.Date(date.getTime());
                   se.createReclamation(new Reclamation(desc.getText(),myDate,"pending"));
                   Notifications notifications=Notifications.create();
                   notifications.text("Reclamation ajoutée");
                   notifications.title("Success Message");
                   notifications.show();
                   boutonajouter.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
                 //Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamationBack.fxml"));
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
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
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

    @FXML
    private void ChangeCode(MouseEvent event) {
        if (FXMLDocumentController.nbOfClicks < this.totalattempts) {
            FXMLDocumentController.GeneratedCode = sr.CreateCaptchaValue();
            CaptchaCode.setText(FXMLDocumentController.GeneratedCode);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("null");
            alert.setContentText("No More Attempts");
            alert.showAndWait();
        }
        FXMLDocumentController.nbOfClicks = FXMLDocumentController.nbOfClicks + 1;
    }

    


 

  
    
}
