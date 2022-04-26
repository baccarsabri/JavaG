/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import t2s.son.LecteurTexte;

/**
 *
 * @author Oussama Fdhila
 */
public class LanciTounsiFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamationBack.fxml"));
         // Parent root = FXMLLoader.load(getClass().getResource("AjouterFichier.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        /*LecteurTexte lecteur =new LecteurTexte("Bonjour, quel est votre problème?");
        lecteur.playAll();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
