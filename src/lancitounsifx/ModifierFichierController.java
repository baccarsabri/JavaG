/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Fichier;
import services.ServiceFichier;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class ModifierFichierController implements Initializable {

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
    private TextArea link;
    @FXML
    private Button ret;
    ServiceFichier sf=new ServiceFichier();
    Fichier f=new Fichier();
int id;
String fa;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         setData(f);    
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
                   Parent root = FXMLLoader.load(getClass().getResource("AfficherFichier.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);   
    }
    
    public void setData(Fichier fich)
    {
        id=fich.getId();
        fa=fich.getLink();
        link.setText(fa);
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         try {
        Fichier fich =new Fichier(id,0,link.getText());
        sf.updateFichier(fich);       
        JOptionPane.showMessageDialog(null, "Fichier modifié");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherFichier.fxml"));
        Parent root = loader.load(); 
        link.getScene().setRoot(root);
        }catch (IOException ex) {
            Logger.getLogger(ModifierFichierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
