/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Transaction;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class ItemTransactionController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label facture;
    @FXML
    private Label type;
    @FXML
    private Label statut;
    @FXML
    private Label prix;
    @FXML
    private Label created_at;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void setData(Transaction t){
      facture.setText(String.valueOf(t.getFacture().getId()));
      type.setText(t.getType());
      statut.setText(t.getStatut());
      prix.setText(String.valueOf(t.getPrix()));
      created_at.setText(String.valueOf(t.getCreated_at()));
    
    
    }
    
}
