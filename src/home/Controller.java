package home;

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
import models.Projet;
import services.ServiceProjet;

public class Controller implements Initializable {
ServiceProjet sp =new ServiceProjet();
    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

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
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;
    private Pane pnlDetailP;
    
    private Pane det;
    
    
    
   private Stage stage;
    private Scene scene;
    private Parent parent; 
    private Parent root; 
    @FXML
    private Label tt_pr;
    @FXML
    private Button bt_add_pr;
    @FXML
    private TextField search;
    
    int user_id;
    
    
  
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("search : "+search.getText());
      /* 
       List<Projet> l = sp.readProjets();
       tt_pr.setText(String.valueOf(l.size()));
        Node[] nodes = new Node[l.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("Item.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemController ItemController= fxmlLoader.getController();
           
               ItemController.setData(l.get(i));
               
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }*/
        
        

    }
    
    
     


@FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
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
        } if(actionEvent.getSource()==btnMenus)
        {
               Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
        
        
    }
    
    @FXML
    public void listell() throws IOException {
         System.out.println("search : "+search.getText());
       
       List<Projet> l = sp.readProjets();
       tt_pr.setText(String.valueOf(l.size()));
        Node[] nodes = new Node[l.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("Item.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemController ItemController= fxmlLoader.getController();
           
               ItemController.setData(l.get(i));
               
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
    }

    @FXML
    private void addProjet(ActionEvent actionEvent) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ajouterProjet.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        System.out.println(search.getText());
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
      root = loader.load();
      Controller c = loader.getController();
      c.searchL(search.getText());
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    
     @FXML
    private void searchL(String like) throws IOException {
        pnItems.getChildren().removeAll();
         System.out.println(search.getText());
       List<Projet> la = sp.readProjetsLike(like);
         System.out.println("Liste like : "+la);
       tt_pr.setText(String.valueOf(la.size()));
        Node[] nodes = new Node[la.size()];
        for (int i = 0; i < nodes.length; i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("Item.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemController ItemController= fxmlLoader.getController();
           
               ItemController.setData(la.get(i));
               
                pnItems.getChildren().add(pane);
                 

       
               
           } catch (IOException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
    }
    
}
