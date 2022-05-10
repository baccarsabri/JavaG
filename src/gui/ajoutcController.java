/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Projet;
import models.User;
import models.contrat;
import services.ServiceContrat;
import utils.EmailSender;

/**
 * FXML Controller class
 *
 * @author 21655
 */
public class ajoutcController implements Initializable {

    ServiceContrat ct = new ServiceContrat();

    @FXML
    private TextField cprix;
    private ComboBox<String> cstatut;
    @FXML
    private Label pfinis;
    @FXML
    private Label pencours;
    @FXML
    private Button ajout;
    @FXML
    private ChoiceBox c;

    ServiceContrat sr = new ServiceContrat();
    List<Projet> l = sr.MesProjets(1);
    List<User> u = sr.Mesuser();
    List<User> y = sr.Mesuser();

    @FXML
    private ChoiceBox c1;
    @FXML
    private ChoiceBox c11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Node[] nodes = new Node[l.size()];
        for (int i = 0; i < nodes.length; i++) {
            c.getItems().add((i + 1) + "-" + l.get(i).getNom());

            Node[] node = new Node[u.size()];
            for (int j = 0; j < node.length; j++) {
                c1.getItems().add((j + 1) + "-" + u.get(j).getNom() + " " + u.get(j).getPrenom());
            }
            Node[] nodey = new Node[u.size()];
            for (int o = 0; o < nodey.length; o++) {
                c11.getItems().add((o + 1) + "-" + u.get(o).getNom());
            }
            System.out.println("a");
            float fini = ct.Sommetotalefini();
            String a = String.valueOf(fini);
            float encours = ct.Sommetotaleencours();
            String b = String.valueOf(encours);
            pfinis.setText(a);
            pencours.setText(b);

            // TODO
        }
    }

    @FXML
    private void ajouter(ActionEvent event) throws Exception {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        float f = Float.parseFloat(cprix.getText());
        int idProjet = l.get(c.getSelectionModel().getSelectedIndex()).getId();
        int idUser = u.get(c1.getSelectionModel().getSelectedIndex()).getId();
        int idUsern = u.get(c11.getSelectionModel().getSelectedIndex()).getId();

        System.out.println(f);

        if (f <= 0) {
            JOptionPane.showMessageDialog(null, "Vous devez saisir un prix valide positif et different de 0  ");

        } else {

            EmailSender.sendEmailWithAttachments("samaali.mohamedyassine@esprit.tn", "Contrat Ajouté ", "Le contrat ayant le prix " + f + " a éte ajouté avec succés le " + sqlDate + "");

            contrat c = new contrat(idUsern, idUser, idProjet, f, sqlDate, "pending");
            System.out.println(f);
            ct.createContrat(c);

            ajout.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("ContratController.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);

        }
    }

}
