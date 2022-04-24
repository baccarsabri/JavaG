/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Projet;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class DetailPController implements Initializable {

    @FXML
    private Label id_p;
    @FXML
    private Label nom_p;
    @FXML
    private Label s_min;
    @FXML
    private Label s_max;
    @FXML
    private Label desc;
    @FXML
    private Label statut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Projet p){
        id_p.setText(id_p.getText()+p.getId());
        nom_p.setText(nom_p.getText()+p.getNom());
        s_min.setText(s_min.getText()+String.valueOf(p.getMin_salaire()));
        s_max.setText(s_max.getText()+String.valueOf(p.getMax_salaire()));
    }
    
}
