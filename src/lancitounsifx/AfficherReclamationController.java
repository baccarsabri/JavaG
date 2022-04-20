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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import models.Reclamation;
import services.ServiceReclamation;


/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AfficherReclamationController implements Initializable {

    private TextArea desc;
    @FXML
    private TableView<Reclamation> TableReclamation;
    @FXML
    private TableColumn<Reclamation,String> col_desc;
    @FXML
    private TableColumn<Reclamation,Date> col_date;
    @FXML
    private TableColumn<Reclamation,String> col_stat;
    @FXML
    private Button boutonsupprimer;
  

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO

         ServiceReclamation rec= new ServiceReclamation();
         TableReclamation.setEditable(true);
        col_desc.setEditable(true);
        List<Reclamation> LR =rec.readReclamation();
        col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_de_reclamation"));
        col_stat.setCellValueFactory(new PropertyValueFactory<>("statut")); 
        TableReclamation.getItems().setAll(LR);   
        col_desc.setCellFactory(TextFieldTableCell.forTableColumn());
        col_desc.setOnEditCommit(new EventHandler<CellEditEvent<Reclamation, String>>() {
            public void handle(CellEditEvent<Reclamation,String> event) {
                Reclamation tt = event.getRowValue();
                tt.setDescription(event.getNewValue());
               rec.updateReclamation(tt);
            }});
    }   

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceReclamation st = new ServiceReclamation();
        Reclamation t=new Reclamation();
        t=TableReclamation.getSelectionModel().getSelectedItems().get(0);
        st.deleteReclamation(t);
        System.out.println(t);
      initialize(null,null);
    }

  


    private void selectitem(MouseEvent event) {
        TableReclamation.setEditable(true);
       
        
    }
    
}
