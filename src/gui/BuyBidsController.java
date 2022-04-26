/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class BuyBidsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String type;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void toPayment(ActionEvent event) throws IOException  {
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
         root= loader.load();
         PaymentController pc=loader.getController();
         pc.settype(type);
         
         
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }  

    @FXML
    private void basic(ActionEvent event) throws IOException {
        this.type="BASIC_PLANS";
        toPayment(event);
    }

    @FXML
    private void standrad(ActionEvent event) throws IOException {
        this.type="STANDARD_PLANS";
        toPayment(event);
    }

    @FXML
    private void prof(ActionEvent event) throws IOException {
        this.type="PROFFESIONAL_PLANS";
        toPayment(event);
    }
    
}
