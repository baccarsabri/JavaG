/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.contrat;
import services.ServiceContrat;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class AjouterContrattController implements Initializable {

    ServiceContrat ct = new ServiceContrat();

    @FXML
    private TextField cprix;
    @FXML
    private ComboBox<String> cstatut;
    @FXML
    private Label pfinis;
    @FXML
    private Label pencours;
    @FXML
    private Button ajout;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cstatut.getItems().add("Pending");
        cstatut.getItems().add("Finished");
        float fini = ct.Sommetotalefini();
        String a = String.valueOf(fini);
        float encours = ct.Sommetotaleencours();
        String b = String.valueOf(encours);
        pfinis.setText(a);
        pencours.setText(b);

        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) throws Exception {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        float f = Float.parseFloat(cprix.getText());
        if (f != 0) {
            contrat c = new contrat(1, 1, f, sqlDate, cstatut.getValue());
            ct.createContrat(c);
            ajout.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("AfficherContrat.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        }
        else{System.out.println("error");}

    }

}
