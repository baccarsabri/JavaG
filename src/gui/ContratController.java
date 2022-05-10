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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Projet;
import models.contrat;
import services.ServiceContrat;
import services.ServiceProjet;

public class ContratController implements Initializable {
ServiceContrat ca = new ServiceContrat();
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
    @FXML
    private Label tt_pr;
    ServiceContrat sc=new ServiceContrat();
    
  
        java.util.Date dat = new java.util.Date(0, 0, 0);
    @FXML
    private Label dateC;
    @FXML
    private Button NextPage;
    @FXML
    private Button PreviousPage;
int a;
    int page=0;
    int perPage=5;
    @FXML
    private Label paj;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show();
        
    }
    
public void show()
    {
         pnItems.getChildren().clear();
          dat = sc.afficher_date();
        dateC.setText(""+dat);
         List<contrat> c = sc.readcontrats();
          a=a+0;
       paj.setText(""+page);
       tt_pr.setText(String.valueOf(c.size()));
       
        Node[] nodes = new Node[c.size()];
        System.out.println("fromm"+(page*perPage)+"to"+(page*(perPage+1)));
        for (int i = page*perPage; (i < (perPage*(page+1)) && i<nodes.length); i++) {
             FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Main.class.getResource("Itemcontrat.fxml"));
           try {
               Pane pane = fxmlLoader.load();
               
               
                  ItemcontratController ItemController= fxmlLoader.getController();
           
               
                  ItemController.setData(c.get(i));
               
                  ItemController.setController(new Runnable() {
                   @Override
                   public void run() {
                       show();
                   }
                    });
                pnItems.getChildren().add(pane);
               
           } catch (IOException ex) {
               Logger.getLogger(ContratController.class.getName()).log(Level.SEVERE, null, ex);
           }  
            
        }
    }    
     


@FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ajouterCategorie.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    private void next(ActionEvent event) {
        page+=1;
        show();
    }

    @FXML
    private void previous(ActionEvent event) {
        page=Math.max(0, page-1);
        System.out.println(page);
        show();
    }

    

}
