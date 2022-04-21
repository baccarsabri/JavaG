/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.contrat;
import services.ServiceContrat;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class AffController implements Initializable {
            ServiceContrat ct= new ServiceContrat();
    @FXML
    private TextField aprix;
    @FXML
    private ComboBox<String> astatut;
    @FXML
    private TableView<contrat> TableContrat;
    @FXML
    private TableColumn<contrat, Float> pp;
    @FXML
    private TableColumn<contrat, String> ss;
    @FXML
    private TableColumn<contrat, Date> dd;

    

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         ServiceContrat con= new ServiceContrat();
         List<contrat> LC =con.readcontrats();
        pp.setCellValueFactory(new PropertyValueFactory<>("prix"));
        dd.setCellValueFactory(new PropertyValueFactory<>("created_at"));
        ss.setCellValueFactory(new PropertyValueFactory<>("statut"));
        TableContrat.getItems().setAll(LC);     
        
        astatut.getItems().add("Pending");
          astatut.getItems().add("Finished");
  float fini=ct.Sommetotalefini();
  String a=String.valueOf(fini);
  float encours=ct.Sommetotaleencours(); 
    String b=String.valueOf(encours);
  
    }    

   


    @FXML
    private void aj(ActionEvent event) {
         java.util.Date date = new java.util.Date();
         java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        float f=Float.parseFloat(aprix.getText());  
       contrat c=new contrat(1,1,f,sqlDate,astatut.getValue());
       ct.createContrat(c);
        
    }
    
}
