/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

import java.io.IOException;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Projet;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class TestController implements Initializable {

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
    private PieChart pie;
    int user_id;
    
     private Stage stage;
    private Scene scene;
    private Parent parent; 
    private Parent root; 
    
    ServiceProjet sp = new ServiceProjet();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ok test");
        
        user_id=4;
        
     List<Projet> lp =  sp.MesProjetsByStatut(user_id,"pending");
     
     List<Projet> la =  sp.MesProjetsByStatut(user_id,"accorded");
       
         PieChart.Data slice1 = new PieChart.Data("Pending : "+lp.size(), lp.size());
         
         
       PieChart.Data slice2 = new PieChart.Data("Accorded : "+la.size(), la.size());
      
        pie.getData().add(slice1);
       pie.getData().add(slice2);
      
       

       
    final Label caption = new Label("");
caption.setTextFill(Color.DARKORANGE);
caption.setStyle("-fx-font: 24 arial;");

for (final PieChart.Data data : pie.getData()) {
    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
        new EventHandler<MouseEvent>() {
            
            
            @Override public void handle(MouseEvent e) {
                
                System.out.println("pressed");
                caption.setTranslateX(e.getSceneX());
                caption.setTranslateY(e.getSceneY());
                caption.setText(String.valueOf(data.getPieValue()) + "%");
             }
        });
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
        } if(actionEvent.getSource()==btnMenus)
        {
               Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
         stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
    }
    
}
