/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import models.Reclamation;
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AfficherReclamationBackController implements Initializable {

    @FXML
    private TextField desc;

    @FXML
    private TableView<Reclamation> TableReclamation;
    @FXML
    private TableColumn<Reclamation,String> col_desc;
    @FXML
    private TableColumn<Reclamation,Date> col_date;
    @FXML
    private TableColumn<Reclamation,String> col_stat;
    @FXML
    private Button recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceReclamation rec= new ServiceReclamation();
        TableReclamation.setEditable(true);
        col_stat.setEditable(true);
        List<Reclamation> LR =rec.readReclamation();
        col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_de_reclamation"));
        col_stat.setCellValueFactory(new PropertyValueFactory<>("statut"));
        TableReclamation.getItems().setAll(LR);
        col_stat.setCellFactory(TextFieldTableCell.forTableColumn());
        col_stat.setOnEditCommit(new EventHandler<CellEditEvent<Reclamation, String>>() {
            public void handle(CellEditEvent<Reclamation,String> event) {
                Reclamation tt = event.getRowValue();
                tt.setStatut("finished");
               rec.updateReclamation(tt);
            }});
    }    

    @FXML
    private void rechercher(ActionEvent event) {
      /*ServiceReclamation rec= new ServiceReclamation();
         List<Reclamation> LR =rec.ListByStatus("pending");*/
    }
    
}
