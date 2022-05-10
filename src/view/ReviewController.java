/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXMasonryPane;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import static java.rmi.Naming.list;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.mail.MessagingException;
import models.Portfolio;
import models.Review;
import models.email;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.controlsfx.control.Rating;
import services.ServiceReview;
import utils.MaConnexion;

/**
 * FXML Controller class
 *
 * @author YOGA
 */
public class ReviewController implements Initializable {

    @FXML
    private Button ajout;

    @FXML
    private TextField cmnt;
    @FXML
    private ComboBox<String> nt;
    @FXML
    private TableView<Review> tb_review;
    @FXML
    private TableColumn<Review, Integer> tnot;
    @FXML
    private TableColumn<Review, String> tcmnt;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlDetailP;
    @FXML
    private ImageView imgg;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label MeilleurRate;
    Desktop desktop = Desktop.getDesktop();
    @FXML
    private Rating Ratinggg;
    @FXML
    private ScrollPane scrollPane;
    private final JFXMasonryPane mansoryPane = new JFXMasonryPane();
    Review rec = new Review();
    ServiceReview work = new ServiceReview();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        ObservableList<String> list = FXCollections.observableArrayList("1", "2", "3", "4", "5");
//        nt.setItems(list);
//        afficher_Review();

        /////////////////////////////////////////////////
        ServiceReview revSer = new ServiceReview();
        MeilleurRate.setText(String.valueOf(revSer.MeilleurRate()));

        initMansoryCard();
        LoadCard();

    }

    private void initMansoryCard() {

        mansoryPane.setPadding(new Insets(15, 15, 15, 15));
        mansoryPane.setVSpacing(5);
        mansoryPane.setHSpacing(5);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(mansoryPane);

    }

    private void LoadCard() {

        mansoryPane.getChildren().clear();
        Review ratee = new Review();

        List<Review> listeRate = new ArrayList<>();
        listeRate = work.AfficherAllReview(rec);

        if (!listeRate.isEmpty()) {
            int h = 0;
            int nbStarts = 0;
            for (int i = 0; i < listeRate.size(); i++) {
                VBox root = new VBox();
                Rating ook = new Rating();

                root.setStyle("-fx-background-color: #fff; -fx-background-radius: 15px;-fx-effect:dropshadow(three-pass-box, gray, 10, 0, 0, 0);");
                nbStarts = listeRate.get(i).getNote();
                int id = listeRate.get(i).getId();
                String nom = listeRate.get(i).getCommentaire();
                h++;
                ook.setRating(nbStarts);
                //System.out.println(""+nbStarts);
                ook.setDisable(true);
                // System.out.println(listeRate);
                // System.out.println(h);

                root.setPadding(new Insets(12, 17, 17, 17));

                root.setSpacing(13);
                ImageView btndelete, btnedit;
                ////////////////////////////////////////////////////////////////
                btndelete = new ImageView(new Image("/images/delete.png"));
                btndelete.setFitHeight(30);
                btndelete.setFitWidth(30);
                ////////////////////////////////////////////////////////////////
                btnedit = new ImageView(new Image("/images/edit.png"));
                btnedit.setFitHeight(30);
                btnedit.setFitWidth(30);
                HBox managebtn = new HBox(btndelete, btnedit);
                root.getChildren().addAll(new Label("Commentaire : " + nom), ook , managebtn);
                root.setAlignment(Pos.CENTER);
                mansoryPane.getChildren().add(root);

                btndelete.setOnMouseClicked((MouseEvent event) -> {

                    ServiceReview ps = new ServiceReview();

                   
                    ps.supprimer_review(id);

                    LoadCard();
                });

                btnedit.setOnMouseClicked((MouseEvent event) -> {
            ServiceReview ps = new ServiceReview();
            Review p = new Review();
            int stars = (int) Ratinggg.getRating();

            p.setNote(stars);
            p.setCommentaire(cmnt.getText());
            p.setId(id);


            ps.modifier_review(p);
            System.out.println(" modifier avec succé");
                    LoadCard();

                });
            }

        }

    }

    private void Error(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Attention!!!");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    void ajout(ActionEvent event) throws MessagingException {
        if (cmnt.getText().isEmpty()) {
            Error("Veuillez remplir tous les champs");
        } else {
            ServiceReview ps = new ServiceReview();
            Review p = new Review();
            int stars = (int) Ratinggg.getRating();
            p.setNote(stars);
            p.setCommentaire(cmnt.getText());
            ps.createReview(p);
            System.out.println("review ajouter avec succé");
            email.sendmail();
            afficher_Review();
            LoadCard();
        }

    }

    @FXML
    private void modifier(ActionEvent event) {
//        if (tb_review.getSelectionModel().getSelectedItem() != null) {
//            int idReview = tb_review.getSelectionModel().getSelectedItem().getId();
//            ServiceReview ps = new ServiceReview();
//            Review p = new Review();
//            int stars = (int) Ratinggg.getRating();
//
//            p.setNote(stars);
//            p.setCommentaire(cmnt.getText());
//            p.setId(idReview);
//
//            System.out.println("" + idReview);
//
//            ps.modifier_review(p);
//            System.out.println(" modifier avec succé");
//            afficher_Review();
//            LoadCard();
//        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
//        if (tb_review.getSelectionModel().getSelectedItem() != null) {
//            int idReview = tb_review.getSelectionModel().getSelectedItem().getId();
//            ServiceReview ps = new ServiceReview();
//            /* ps.supprimer_review(Integer.parseInt(nt.getValue()));
//   
//             */
//            Review x = tb_review.getSelectionModel().getSelectedItem();
//            ps.supprimer_review(idReview);
//            afficher_Review();
//        }
//        LoadCard();
    }

    private void afficher_Review() {
//        ServiceReview ps = new ServiceReview();
//        ResultSet resultset = ps.getall_review();
//        List<Review> pl = new ArrayList<Review>();
//        try {
//            while (resultset.next()) {
//                Review p1 = new Review();
//                p1.setId(resultset.getInt("id"));
//                p1.setNote(resultset.getInt("note"));
//                p1.setCommentaire(resultset.getString("commentaire"));
//
//                pl.add(p1);
//
//            }
//            ObservableList<Review> listreview = FXCollections.observableArrayList(pl);
//            //tb_id.setCellValueFactory(new PropertyValueFactory<>("id"));
//            tnot.setCellValueFactory(new PropertyValueFactory<>("note"));
//            tcmnt.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
//
//            tb_review.setItems(listreview);
//        } catch (SQLException ex) {
//            Logger.getLogger(ReviewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void GOToPortfolio(MouseEvent event) {
        AnchorPane pane = new AnchorPane();

        try {
            pane = FXMLLoader.load(getClass().getResource("Portfolio.fxml"));
            ap.getChildren().setAll(pane);
        } catch (IOException ex) {
            //Logger.getLogger(PortfolioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GOToReview(MouseEvent event) {
        AnchorPane pane = new AnchorPane();

        try {
            pane = FXMLLoader.load(getClass().getResource("review.fxml"));
            ap.getChildren().setAll(pane);
        } catch (IOException ex) {
            //Logger.getLogger(PortfolioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ExportExcel(MouseEvent event) {

        

        try {
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("Rapport");

            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell((short) 0).setCellValue("ID");
            rowhead.createCell((short) 1).setCellValue("Note");
            rowhead.createCell((short) 2).setCellValue("Commentaire");

            Statement st = MaConnexion.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery("Select * from review");
            int i = 1;
            while (rs.next()) {
                HSSFRow row = sheet.createRow((short) i);

                row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("id")));
                row.createCell((short) 1).setCellValue(rs.getString("note"));
                row.createCell((short) 2).setCellValue(rs.getString("commentaire"));

                i++;
            }
            FileOutputStream fileOut = new FileOutputStream(String.valueOf("Review" + ".xls"));
            hwb.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");

            ///Open FilePdf
            File file = new File("Review" + ".xls");
            if (file.exists()) //checks file exists or not  
            {
                desktop.open(file); //opens the specified file   
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void LogOutClicked(MouseEvent event) {

        System.exit(0);

    }
}
