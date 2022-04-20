/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import models.Fichier;
import services.ServiceFichier;



/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AfficherFichierController implements Initializable {

    @FXML
    private TableView<Fichier> TableFichiers;
    @FXML
    private TableColumn<Fichier,String> col_link;
    @FXML
    private Button boutonsupprimer;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceFichier fich= new ServiceFichier();
         TableFichiers.setEditable(true);
     
          col_link.setEditable(true);
         List<Fichier> LF =fich.readFichier();
        col_link.setCellValueFactory(new PropertyValueFactory<>("link"));
       TableFichiers.getItems().setAll(LF);   
        col_link.setCellFactory(TextFieldTableCell.forTableColumn());
       col_link.setOnEditCommit(new EventHandler<CellEditEvent<Fichier, String>>() {
          
            public void handle(CellEditEvent<Fichier,String> event) {
                Fichier tt = event.getRowValue();
                tt.setLink(event.getNewValue());             
                fich.updateFichier(tt);

            }});    }    

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceFichier sf = new ServiceFichier();
        Fichier t=new Fichier();
        t=TableFichiers.getSelectionModel().getSelectedItems().get(0);
        sf.deleteFichier(t);
        System.out.println(t);
      initialize(null,null);
    }
    
}
