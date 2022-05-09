/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Transaction;
import services.ServiceTransaction;
import static utils.SessionManager.getUser;
import static utils.SessionManager.setUser;


/**
 * FXML Controller class
 *
 * @author bacca
 */
public class TransactionsController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField search;
    @FXML
    private Label tt_pr;
    @FXML
    private VBox pnItems;
    @FXML
    private Button btnTransaction;
        private Stage stage;
    private Scene scene;
    private Parent parent;
    private Parent root;
    
    int user_id;
    
    ServiceTransaction st= new ServiceTransaction();
    @FXML
    private Button btnBids;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        List<Transaction> l = st.AllTransactions(getUser());
        System.out.print("hhh : "+ getUser());
        Node[] nodes = new Node[l.size()];
        tt_pr.setText(String.valueOf(l.size()));
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(NewFXMain.class.getResource("itemTransaction.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemTransactionController ItemControllere= fxmlLoader.getController();
           
               ItemControllere.setData(l.get(i));
               
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(TransactionsController.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    } 
    }

    @FXML
    private void handleClicks(ActionEvent actionEvent) throws IOException {
            user_id=4;
        if (actionEvent.getSource() == btnCustomers) {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("MesProjets.fxml"));
      root = loader.load();
      MesProjetsController mp = loader.getController();
     mp.listAll();
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
        
        if (actionEvent.getSource() == btnOverview) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
      root = loader.load();
      Controller c = loader.getController();
      c.listell();
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
        if(actionEvent.getSource()==btnOrders)
        {
               Parent root = FXMLLoader.load(getClass().getResource("MesPropositions.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        } if(actionEvent.getSource()==btnTransaction)
        {
               Parent root = FXMLLoader.load(getClass().getResource("Transactions.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }if(actionEvent.getSource()==btnBids)
        {
               Parent root = FXMLLoader.load(getClass().getResource("buyBids.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
        
    }

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        
        
        setUser(null);
         Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
}
