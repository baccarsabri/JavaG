/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancitounsifx;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static lancitounsifx.AfficherReclamationController.numeroPDF;
import models.Reclamation;
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author Oussama Fdhila
 */
public class AfficherReclamationBackController implements Initializable {

    ServiceReclamation sr = new ServiceReclamation();

    private TableView<Reclamation> TableReclamation;
    @FXML
    private Pane col_desc;
    @FXML
    private Pane col_date;
    @FXML
    private Pane col_stat;
    int id;
    @FXML
    private Button btnRec;
    @FXML
    private Button btnFich;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField sear;
    @FXML
    private Label tt_pr;
    @FXML
    private HBox attr;
    @FXML
    private VBox pnItems;
    @FXML
    private Button sea;
    @FXML
    private Button pdf;
    @FXML
    private Label date;
    java.util.Date dat = new java.util.Date(0, 0, 0);
    Document doc = new Document();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
show();
    }

    public void show()
    {
        pnItems.getChildren().clear();
        dat = sr.afficher_date();
        date.setText("La date enregistrant le grand nombre des réclamations est:" + dat);
        List<Reclamation> r = sr.readReclamation();
        tt_pr.setText(String.valueOf(r.size()));
        Node[] nodes = new Node[r.size()];
        for (int i = 0; i < nodes.length; i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(LanciTounsiFX.class.getResource("ItemB.fxml"));
            try {
                Pane pane = fxmlLoader.load();
                ItemBController ItemController = fxmlLoader.getController();

                ItemController.setData(r.get(i));
                ItemController.setController(new Runnable() {
                   @Override
                   public void run() {
                       show();
                   }
                    });
                pnItems.getChildren().add(pane);

            } catch (IOException ex) {
                Logger.getLogger(AfficherReclamationBackController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    private void supprimer(ActionEvent event) {
        ServiceReclamation st = new ServiceReclamation();
        Reclamation t = new Reclamation();
        t = TableReclamation.getSelectionModel().getSelectedItems().get(0);
        id = t.getId();
        st.deleteReclamation(id);
        System.out.println(t);
        initialize(null, null);
    }

    @FXML
    private void aff_rec(ActionEvent event) throws IOException {
        btnRec.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void aff_fich(ActionEvent event) throws IOException {
        btnFich.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AfficherFichier.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void convertirPDF(ActionEvent event) throws FileNotFoundException, IOException {
        numeroPDF = numeroPDF + 1;
        String nom = "Reclamation" + numeroPDF + ".pdf";
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat Heure = new SimpleDateFormat("hh:mm:ss");
            Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);

            WritableImage wimg = pnlOverview.snapshot(new SnapshotParameters(), null);
            File file = new File("Reclamation.png");
            ImageIO.write(SwingFXUtils.fromFXImage(wimg, null), "png", file);

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(nom));
            doc.open();
            Image img = Image.getInstance("Reclamation.png");
            doc.add(img);

            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\Oussama Fdhila\\Desktop\\" + nom));
            writer.close();

        } catch (Exception e) {
            System.out.println("Error PDF");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());

        }

    }

    @FXML
    private void handleClicks(ActionEvent event) {
        if (event.getSource() == btnCustomers) {

        }
        if (event.getSource() == btnMenus) {

        }

    }

    @FXML
    private void search(ActionEvent event) {
        Reclamation r = new Reclamation();
        List<Reclamation> l = sr.RechercheByDescription(r.getDescription());
    }

}
