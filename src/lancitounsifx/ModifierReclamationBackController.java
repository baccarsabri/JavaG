/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Reclamation;
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class ModifierReclamationBackController implements Initializable {

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
    private Button boutonmodifier;
    @FXML
    private Button ret;
    @FXML
    private ComboBox<String> stat;
    int id;
    ServiceReclamation sr=new ServiceReclamation();
    Reclamation r=new Reclamation();
    String fa;
    String etat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stat.getItems().add("Pending");
        stat.getItems().add("Finished");
        stat.setValue(etat);
        setData(r);
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
    private void handleClicks(ActionEvent event) {
    }


    @FXML
    private void retour(ActionEvent event) throws IOException {
        ret.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamationBack.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);   
    }
    
    public void setData(Reclamation r)
    {
       id=r.getId();
      fa=r.getDescription();
      etat=r.getStatut();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        try {
    
          java.util.Date date = new java.util.Date();
           java.sql.Date myDate = new java.sql.Date(date.getTime()); 
       Reclamation maj =new Reclamation(id,0,fa, myDate, stat.getValue());
       sr.updateReclamation(maj);     
            System.out.println(id);
        JOptionPane.showMessageDialog(null, "Réclamation modifiée");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReclamationBack.fxml"));
            Parent root = loader.load(); 
            stat.getScene().setRoot(root);
        }catch (IOException ex){
            Logger.getLogger(ModifierReclamationBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
