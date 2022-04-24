/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.User;
import models.contrat;
import services.ServiceCatégorie;
import services.ServiceContrat;
import services.ServiceUser;


/**
 * FXML Controller class
 *
 * @author 21655
 */
public class AfficherContratController implements Initializable {
   
    @FXML
    private TableView<contrat> TableContrat;
    @FXML
    private TableColumn<contrat,Float> col_prix;
    @FXML
   private TableColumn<contrat,Date> col_date;
    @FXML
    private TableColumn<contrat,String> col_stat;
    @FXML
    private Button suppr;
    @FXML
    private TableColumn<contrat,String> col_free;
    @FXML
    private TableColumn<contrat,String> col_client;
    @FXML
    private Button modif;
    @FXML
    private Button NextPage;
    @FXML
    private Button PreviousPage;
   
   private static int row;
    private static int size = 5;
    private static int nb;
        ObservableList<contrat> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
         ServiceContrat con= new ServiceContrat();
         TableContrat.setEditable(true);
         col_prix.setEditable(true);
    //     List<contrat> LC =con.readcontrats();
         
        
            User u=new User();
            
            List lis= new ArrayList();
            ServiceUser us=new ServiceUser();
            u=us.UserDetails(1);
            String nom=u.getNom();
            String prenom=u.getPrenom();
        this.contratList(AfficherContratController.size, AfficherContratController.row);
               //this.contratList(5, 1);


/*
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("created_at"));
        col_stat.setCellValueFactory(new PropertyValueFactory<>("statut"));
                col_free.setCellValueFactory(new PropertyValueFactory<>("user_freelancer_id"));
                             
*/

       // TableContrat.getItems().setAll(LC);   
      col_stat.setCellFactory(TextFieldTableCell.forTableColumn());
        col_stat.setOnEditCommit(new EventHandler<CellEditEvent<contrat, String>>() {
            public void handle(CellEditEvent<contrat,String> event) {
                contrat ct = event.getRowValue();
                ct.setStatut(event.getNewValue());
               con.updatecontrat(ct);
            }});
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceContrat sc = new ServiceContrat();
        contrat c=new contrat();
        c=TableContrat.getSelectionModel().getSelectedItems().get(0);
        sc.Deletecontrat(c);
        System.out.println(c);
        initialize(null,null);
    }

    @FXML
    private void modifier(ActionEvent event) {
       ServiceContrat sc = new ServiceContrat();
        contrat c=new contrat();
        c=TableContrat.getSelectionModel().getSelectedItems().get(0);
        sc.updatecontrat(c);
        System.out.println(c);
      initialize(null,null);
    }

    
    
    
    
    
    
    
    
    
    
    private void contratList(int i, int j) {

     //   ImageView imageView = new ImageView(getClass().getResource("..\\images\\icons8-next-page-100.png").toExternalForm());
       // NextPage.setGraphic(imageView);
        //ImageView imageViewv = new ImageView(getClass().getResource("..\\images\\icons8-next-page-99.png").toExternalForm());
        //PreviousPage.setGraphic(imageViewv);
        ServiceContrat cat=new ServiceContrat();
        int testEndPage = cat.getRowCount() - AfficherContratController.row;
        
        if (this.size >= cat.getRowCount() || this.size >= testEndPage) {
            NextPage.setDisable(true);

        } else {
            NextPage.setDisable(false);

        }
        if (AfficherContratController.row < this.size) {
            PreviousPage.setDisable(true);
        } else {
            PreviousPage.setDisable(false);
        }

        // TODO
        List<contrat> li = cat.pagination(i, j);
        
       /* col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("created_at"));
        col_stat.setCellValueFactory(new PropertyValueFactory<>("statut"));
                col_free.setCellValueFactory(new PropertyValueFactory<>("user_freelancer_id"));
                
                  TableContrat.getItems().setAll(LC);   
        System.out.println(LC);
        
        */
        
        

        li.forEach(e
                -> {
            oblist.add(e);
            
             col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("created_at"));
        col_stat.setCellValueFactory(new PropertyValueFactory<>("statut"));
                col_free.setCellValueFactory(new PropertyValueFactory<>("user_freelancer_id"));

          

        }
        );


        TableContrat.setItems(oblist);


    }

    
    
    @FXML
    private void next(ActionEvent event) throws IOException {
                    Stage primaryStage = new Stage();

              AfficherContratController.row = AfficherContratController.row + AfficherContratController.size;
        Parent root = FXMLLoader.load(getClass().getResource("AfficherContrat.fxml"));
        LanciTounsii.primaryStage.setScene(new Scene(root));
        LanciTounsii.primaryStage.show();
    }

    @FXML
    private void previous(ActionEvent event) throws IOException {
               Stage primaryStage = new Stage();

              AfficherContratController.row = AfficherContratController.row + AfficherContratController.size;
        Parent root = FXMLLoader.load(getClass().getResource("AfficherContrat.fxml"));
       LanciTounsii.primaryStage.setScene(new Scene(root));
       LanciTounsii.primaryStage.show();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}