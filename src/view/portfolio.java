/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jfoenix.controls.JFXMasonryPane;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import models.Portfolio;
import services.ServicePortfolio;

/**
 * FXML Controller class
 *
 * @author yassin
 */
public class portfolio implements Initializable {

    @FXML
    private TableView<Portfolio> tportfolio;
    @FXML
    private TableColumn<Portfolio, Integer> ttitle;
    @FXML
    private TableColumn<Portfolio, ImageView> timage;
    @FXML
    private TableColumn<Portfolio, Button> taction;

    @FXML
    private ImageView imgg;
    @FXML
    private TextField title;
    @FXML
    private AnchorPane ap;
    List<String> type;
    Button review = new Button("review");
    String img = "";
    String immg = "";
    String immmg = "";
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlDetailP;
    @FXML
    private Button upload;
    @FXML
    private Button ajouterp;
    @FXML
    private Button supprimerp;
    @FXML
    private Button modifierp;
    @FXML
    private ImageView imgQRCodeGen;
    private Image genQRCodeImg; // Generated QR Code image
    @FXML
    private ScrollPane scrollPane;
    private final JFXMasonryPane mansoryPane = new JFXMasonryPane();
    ////
    Portfolio rec = new Portfolio();
    ServicePortfolio work = new ServicePortfolio();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher_Portfolio();
        review.setOnAction(this::handleButtonAction);
        // TODO

//        getselected();
        initMansoryCard();
        LoadCard();

    }

    private void LoadCard() {

        mansoryPane.getChildren().clear();
        List<Portfolio> listeProduits = new ArrayList<>();
        listeProduits = work.AfficherAll(rec);

        if (!listeProduits.isEmpty()) {
            for (int i = 0; i < listeProduits.size(); i++) {
                VBox root = new VBox();
                ImageView PreviewImageProduit = new ImageView();
                PreviewImageProduit.setFitWidth(120);
                PreviewImageProduit.setFitHeight(120);
                PreviewImageProduit.setPreserveRatio(false);
                PreviewImageProduit.setSmooth(true);
                PreviewImageProduit.setCache(true);

                String nom = listeProduits.get(i).getTitle();
                int id = listeProduits.get(i).getId();
                //
                File dest = new File("C:/Users/YOGA/OneDrive/Images/");
                File f = new File(dest, listeProduits.get(i).getImage());
                //
                if (listeProduits.get(i).getImage() != null) {
                    if (!f.exists()) {
                        try {
                            Image img = new Image(new FileInputStream("C:/Users/YOGA/OneDrive/Images/" + "nophoto.jpg"));
                            PreviewImageProduit.setImage(img);
                        } catch (FileNotFoundException ex) {
                            //Logger.getLogger(FrontProduitController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            // Image img = new Image(new FileInputStream(listeUser.get(i).getCarteidentity()));
                            Image img = new Image(new FileInputStream("C:/Users/YOGA/OneDrive/Images/" + listeProduits.get(i).getImage()));
                            PreviewImageProduit.setImage(img);
                        } catch (FileNotFoundException ex) {
                            //   Logger.getLogger(FrontProduitController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else if (listeProduits.get(i).getImage() == null) {

                    //identityView.setImage(new Image(getClass().getResource("/resources/image/empty-image.jpg").toString()));
                    File file = new File("C:/Users/YOGA/OneDrive/Images/" + "nophoto.jpg");
                    Image imagee = new Image(file.toURI().toString());
                    PreviewImageProduit.setImage(imagee);
                }
                root.setPadding(new Insets(12, 17, 17, 17));
                root.setSpacing(13);

                ///
                root.setStyle("-fx-background-color: #fff; -fx-background-radius: 15px;-fx-effect:dropshadow(three-pass-box, gray, 10, 0, 0, 0);");
                //labels[i].setTextFill(Color.color(1, 0, 0));

                Label LabelNom = new Label("" + nom);
                LabelNom.setTextFill(javafx.scene.paint.Color.web("#202B36", 0.8));
                LabelNom.setStyle("-fx-font-weight: bold");

                ////
                ImageView btndelete, btnedit;

                ////////////////////////////////////////////////////////////////
                btndelete = new ImageView(new Image("/images/delete.png"));
                btndelete.setFitHeight(30);
                btndelete.setFitWidth(30);
                ////////////////////////////////////////////////////////////////
                btnedit = new ImageView(new Image("/images/edit.png"));
                btnedit.setFitHeight(30);
                btnedit.setFitWidth(30);
                HBox managebtn = new HBox( btndelete, btnedit);

                root.getChildren().addAll(LabelNom, PreviewImageProduit, managebtn);
                root.setAlignment(Pos.CENTER);
                mansoryPane.getChildren().add(root);


                btndelete.setOnMouseClicked((MouseEvent event) -> {

                    ServicePortfolio ps = new ServicePortfolio();

                    /* ps.supprimer_review(Integer.parseInt(nt.getValue()));
   
                     */
                    Portfolio x = tportfolio.getSelectionModel().getSelectedItem();
                    ps.supprimer_portfolio(id);
                    afficher_Portfolio();
//supprimerp();
                    LoadCard();
                });

                btnedit.setOnMouseClicked((MouseEvent event) -> {
                    if (title.getText().isEmpty() || immmg.isEmpty()) {
                        Error("Veuillez remplir tous les champs");

                    } else {
                        try {
                            FileInputStream fis = new FileInputStream(new File(immg));
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(portfolio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        ServicePortfolio ps = new ServicePortfolio();
                        Portfolio p = new Portfolio();
                        p.setImage(immmg.toString());

                        System.out.println("" + immg);
                        p.setTitle(title.getText());

                        ps.modifier_portfolio(p, immg, id);
                        System.out.println(" modifier avec succé");
                        afficher_Portfolio();
                    }
                    LoadCard();

                });

                root.setOnMouseClicked((MouseEvent event) -> {
                    String foregroundColor = "#2E3437"; //Black
                    String backgroundColor = "#FFFFFF"; // Whit
                    String AllInfo = "\n Portfolio : " + nom + "\n ";

                    genQRCodeImg = encode(AllInfo, Integer.parseInt("300"), Integer.parseInt("300"), foregroundColor, backgroundColor); // Function Encode
                    if (genQRCodeImg != null) {
                        imgQRCodeGen.setImage(genQRCodeImg);
                    }

                });
            }

        }

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

//    private void getselected() {
//
//        tportfolio.setOnMouseClicked(ev -> {
//            if (ev.getButton().equals(MouseButton.PRIMARY) && ev.getClickCount() == 1) {
//                if (tportfolio.getSelectionModel().getSelectedItem() != null) {
//
//                    System.out.println("clicked");
//                    String title = String.valueOf(tportfolio.getSelectionModel().getSelectedItem().getTitle());
//
//                    String AllInfo = "\n Portfolio : " + title + "\n ";
//                    ////////////////////////:
//                    if (!AllInfo.isEmpty()) {
//                        String foregroundColor = "#2E3437"; //Black
//                        String backgroundColor = "#FFFFFF"; // White
//                        genQRCodeImg = encode(AllInfo, Integer.parseInt("300"), Integer.parseInt("300"), foregroundColor, backgroundColor); // Function Encode
//                        if (genQRCodeImg != null) {
//                            imgQRCodeGen.setImage(genQRCodeImg);
//                        }
//                    }
//
//                }
//            }
//        });
//
//    }
///// Generate CodeQr
    public static Image encode(String data, int width, int height, String foregroundColor, String backgroundColor) {
        try {
            BitMatrix byteMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.decode(backgroundColor));
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.decode(foregroundColor));
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            return SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (WriterException ex) {
            ex.printStackTrace();
            return null;
        }
    }

   private void handleButtonAction(ActionEvent event) {
//        AnchorPane pane = new AnchorPane();
//
//        try {
//            pane = FXMLLoader.load(getClass().getResource("review.fxml"));
//            ap.getChildren().setAll(pane);
//        } catch (IOException ex) {
//            //Logger.getLogger(PortfolioController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
  }

    @FXML
    private void upload(ActionEvent event) {
        FileChooser f = new FileChooser();

        // f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg,png", type));
        File fc = f.showOpenDialog(null);
        if (f != null) {
            System.out.println(fc.getName());
            img = fc.getAbsoluteFile().toURI().toString();
            immg = fc.getPath();
            immmg = fc.getName();
            System.out.println(img);
            Image i = new Image(img);
            //imgg.setImage(i);
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
    private void ajouterp(ActionEvent event) throws FileNotFoundException {
        if (title.getText().isEmpty() || immmg.isEmpty()) {
            Error("Veuillez remplir tous les champs");

        } else {
            ServicePortfolio ps = new ServicePortfolio();
            //p.setId(Integer.parseInt(id.getText()) );
            FileInputStream fis = new FileInputStream(new File(immg));
            Portfolio p = new Portfolio(title.getText(), immmg, immmg, review);
            ps.createPortfolio(p);
            System.out.println("portfolio ajouter avec succé");
            afficher_Portfolio();
        }
    }

    @FXML
    private void modifierp(ActionEvent event) throws FileNotFoundException {
        /*if (tportfolio.getSelectionModel().getSelectedItem() != null) {
            int idPortf = tportfolio.getSelectionModel().getSelectedItem().getId();
            if (title.getText().isEmpty() || immmg.isEmpty()) {
                Error("Veuillez remplir tous les champs");

            } else {
                FileInputStream fis = new FileInputStream(new File(immg));
                ServicePortfolio ps = new ServicePortfolio();
                Portfolio p = new Portfolio();
                p.setImage(immmg.toString());
                p.setTitle(title.getText());

                ps.modifier_portfolio(p, immg, idPortf);
                System.out.println(" modifier avec succé");
                afficher_Portfolio();
            }
        }*/
    }

    private void afficher_Portfolio() {
//        ServicePortfolio ps = new ServicePortfolio();
//        ResultSet resultset = ps.getall_p();
//        List<Portfolio> pl = new ArrayList<Portfolio>();
//        try {
//            while (resultset.next()) {
//                Portfolio p1 = new Portfolio(review);
//
//                p1.setTitle(resultset.getString("title"));
//                p1.setImage(resultset.getString("image"));//
//
//                ImageView v = new ImageView();
//                v.setImage(new Image("file:C:/Users/YOGA/OneDrive/Images/" + resultset.getString("image")));
//                v.setFitHeight(100);
//                v.setFitWidth(100);
//                p1.setPhoto(v);
//                //imgg.setImage(new Image("file:C:/Users/YOGA/OneDrive/Images/"+p1.getImage()));
//                pl.add(p1);

//            }
//            ObservableList<Portfolio> listp = FXCollections.observableArrayList(pl);
//            //tb_id.setCellValueFactory(new PropertyValueFactory<>("id"));
//            ttitle.setCellValueFactory(new PropertyValueFactory<>("title"));
//            timage.setCellValueFactory(new PropertyValueFactory<>("photo"));
//            taction.setCellValueFactory(new PropertyValueFactory<>("review"));
//
//            tportfolio.setItems(listp);
//        } catch (SQLException ex) {
//            // Logger.getLogger(ReviewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void supprimerp(ActionEvent event) {
//        if (tportfolio.getSelectionModel().getSelectedItem() != null) {
//            int idPortf = tportfolio.getSelectionModel().getSelectedItem().getId();
//            ServicePortfolio ps = new ServicePortfolio();
//
//            /* ps.supprimer_review(Integer.parseInt(nt.getValue()));
//   
//             */
//            Portfolio x = tportfolio.getSelectionModel().getSelectedItem();
//            ps.supprimer_portfolio(idPortf);
//            afficher_Portfolio();
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
    private void LogOutClicked(MouseEvent event) {

        System.exit(0);
    }

}
