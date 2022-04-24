/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package home;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Projet;
import models.Proposition;
import services.ServiceProposition;

/**
 * FXML Controller class
 *
 * @author malek
 */
public class ItemPropController implements Initializable {
    
    Projet projet;

    @FXML
    private TextField prix;
    @FXML
    private TextField date;
    @FXML
    private TextArea desc;
    @FXML
    private Button btn;
    
    int user_id;
    
     private Stage stage;
    private Scene scene;
    private Parent parent; 
    
    ServiceProposition sprp = new ServiceProposition();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void proposer(ActionEvent event) throws IOException {
        
        System.out.println("Projet**************"+projet);
        
        if(prix.getText().isEmpty() || date.getText().isEmpty() || desc.getText().isEmpty()){
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur");
            alert1.setHeaderText("Erreur!");
            alert1.setContentText("Veuillez remplir tout les champs ! ");
            alert1.show();
            
        }else if(isNumeric(prix.getText())==false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur!");
            alert.setContentText("Le prix doit etre un nombre ");
            alert.show();
        }else
        
        if(isNumeric(date.getText())==false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur!");
            alert.setContentText("Periode doit etre un nombre !");
            alert.show();
        }else {
            
            
            System.out.println("okkk");
            
            user_id=4;
             
            Proposition p = new Proposition(projet,user_id,Integer.parseInt(prix.getText()),Integer.parseInt(date.getText()),desc.getText(),"pending");
            sprp.createProposition(p);
            
            
              Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
            
        }
    }
    @FXML
    public void getProjet(Projet p){
        projet=p;
        
        
    }
    
    public static boolean isNumeric(String string) {
    int intValue;
		
    
		
    if(string == null || string.equals("")) {
        
        return false;
    }
    
    try {
        intValue = Integer.parseInt(string);
        if(intValue <= 0){
            return false ;
        }else{
         return true;
        }
        
    } catch (NumberFormatException e) {
        
    }
    return false;
}

    
}
