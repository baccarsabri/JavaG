/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.SendSms;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ServiceUser;
import utils.SendSms;
import static utils.SessionManager.getUser;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class PaymentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String type;
    private Text typefield;
    @FXML
    private TextField cardnumber;
    @FXML
    private TextField nomc;
    @FXML
    private DatePicker datec;
    @FXML
    private TextField cap;
    @FXML
    private Button numc;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    ServiceUser u = new ServiceUser();
    SendSms sms= new SendSms();
    
   
    
    
    public static boolean isValidVisaCardNo(String str)
    {
        // Regex to check valid.
        // Visa Card number
        String regex = "^4[0-9]{12}(?:[0-9]{3})?$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }
 
        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
 
        Matcher m = p.matcher(str);
 
        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public void settype(String type){
        this.type=type;
    
    }

    @FXML
    private void submitpayment(ActionEvent event) throws IOException {
       
      
 
 
 
   //4155279860457 true
   //6155279860457 false
   
   System.out.print(isValidVisaCardNo(cardnumber.getText()));
      System.out.print("card number is : "+cardnumber.getText());
         if (isValidVisaCardNo(cardnumber.getText()) == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuiller verifier votre numero de carte");
            alert.show();

      }
         else {
         if (nomc.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Nom du prioritaire important");
            alert.show();

      }
         else{
          if (cap.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("CAP doit contenir 3 chiffres");
            alert.show();

      }
          else{
              if (u.UserDetails(getUser().getId()).getPhone()!= 0) {
                     int leftLimit = 48; // letter 'a'
    int rightLimit = 57; // letter 'z'
    int targetStringLength = 4;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
        int randomLimitedInt = leftLimit + (int) 
          (random.nextFloat() * (rightLimit - leftLimit + 1));
        buffer.append((char) randomLimitedInt);
    }
    String generatedString = buffer.toString();
              System.out.println(generatedString);
             u.setcode(getUser(),generatedString );
             
             sms.send(u.UserDetails(getUser().getId()).getPhone(), generatedString);
            
       
             
             
         FXMLLoader loader = new FXMLLoader(getClass().getResource("code.fxml"));
         root= loader.load();
         CodeController pc=loader.getController();
         pc.settype(type);
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
              }
              else{
              
         FXMLLoader loader = new FXMLLoader(getClass().getResource("addPhone.fxml"));
         root= loader.load();
         AddPhoneController pc=loader.getController();
         pc.settype(type);
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
              }
      
          
          }
         
         }
         
         }
    }
    
}
