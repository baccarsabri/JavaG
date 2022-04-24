/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import models.catégorie;
import services.ServiceCatégorie;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private TextField cacategorie;
    @FXML
    private ImageView img;
    @FXML
    private Button ajt;
     ServiceCatégorie cat=new ServiceCatégorie() ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void lllll(ActionEvent event) {
     List test= new ArrayList();
           test=  cat.RechercherparNom(cacategorie.getText());
     if(test.isEmpty())
     {
           System.out.println("zebi");
     }
           
        if(cacategorie.getText().trim().equals(""))
        {
             JOptionPane.showMessageDialog(null, "Veuillez saisir un nom de catégorie   ");
        }
        
        else if(!test.isEmpty())
        {
                       JOptionPane.showMessageDialog(null, "Nom d'une catégorie qui existe déja  ");
  
        }
        else{
        catégorie c=new catégorie(cacategorie.getText());
      

       
       
        cat.createCatégorie(c);
        
        }
    }
    
}
