/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;


import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import models.Reclamation;
import models.Fichier;
import services.ServiceFichier;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AfficherListeFichierController implements Initializable {

    @FXML
    private AnchorPane TableFichiers;
    @FXML
    private ListView<Fichier> TableFichier;
    @FXML
    private Label fich;
    @FXML
    private ListView<String> linkDisplay;
    @FXML
    private Button boutonsupprimer;
    List<Fichier> liste = new ArrayList<>();
    ServiceFichier fiche= new ServiceFichier();
    @FXML
    private Button rech;
    @FXML
    private TextField desc;
    int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
List<Fichier> liste = new ArrayList<>();
     liste = fiche.readFichier();
         liste.forEach((l) -> {
                     linkDisplay.getItems().addAll(l.getLink());        
        });    }    

    @FXML
    private void supprimer(ActionEvent event) {
       ServiceFichier sf = new ServiceFichier();
        Fichier t=new Fichier();
        t=TableFichier.getSelectionModel().getSelectedItems().get(0);
        sf.deleteFichier(id);
        System.out.println(t);
        initialize(null,null);
    }

    @FXML
    private void rechercher(ActionEvent event) {
        /*
        List<Reclamation> liste = new ArrayList<>();
 
 
        String title=search.getText();
          liste =  fiche.FindReclamationByTitle(title);
         liste.forEach((l) -> {
                        TableFichiers.getItems().addAll(l.getLink());
                                 
         }*/
    }
    
}
