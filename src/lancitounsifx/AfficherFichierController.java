/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Fichier;
import models.Reclamation;
import services.ServiceFichier;
import services.ServiceReclamation;



/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AfficherFichierController implements Initializable {

    private TableView<Fichier> TableFichiers;
    private TableColumn<Fichier,String> col_link;
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
    private TextField sear;
    @FXML
    private Label tt_pr;
    @FXML
    private VBox pnItems;
    @FXML
    private Button bt_add_fich;
    @FXML
    private Button sea;
    ServiceFichier sf= new ServiceFichier();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
       }    
    public void show()
    {
                pnItems.getChildren().clear();

         List<Fichier> f = sf.readFichier();
       tt_pr.setText(String.valueOf(f.size()));
        Node[] nodes = new Node[f.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(LanciTounsiFX.class.getResource("ItemF.fxml"));
           try {
                  Pane pane = fxmlLoader.load();
               
               
                  ItemFController ItemController= fxmlLoader.getController();
           
               
                  ItemController.setData(f.get(i));
               
                  ItemController.setController(new Runnable() {
                   @Override
                   public void run() {
                       show();
                   }
                    });
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(AfficherFichierController.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
    }

    /*private void supprimer(ActionEvent event) {
        ServiceFichier sf = new ServiceFichier();
        Fichier t=new Fichier();
        t=TableFichiers.getSelectionModel().getSelectedItems().get(0);
        sf.deleteFichier(t);
        System.out.println(t);
      initialize(null,null);
    }*/

     @FXML
    private void handleClicks(ActionEvent event)  {
        if (event.getSource() == btnCustomers) {
            
        }
        if (event.getSource() == btnMenus) {
            
          
        }
       
    }

    @FXML
    private void addFichier(ActionEvent event) throws IOException {
        
                   bt_add_fich.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("AjouterFichier.fxml"));
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   stage.setResizable(false);   
    }

    @FXML
    private void search(ActionEvent event) {
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
