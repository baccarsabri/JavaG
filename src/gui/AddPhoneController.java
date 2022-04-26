/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceUser;
import utils.SendSms;
import static utils.SessionManager.getUser;

/**
 * FXML Controller class
 *
 * @author bacca
 */
public class AddPhoneController implements Initializable {

    @FXML
    private TextField phone;
    private String type;
   
    ServiceUser u = new ServiceUser();
    SendSms sms= new SendSms();
    private Stage stage;
    private Scene scene;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
      public void settype(String type){
        this.type=type;
    
    }

    @FXML
    private void submit(ActionEvent event) throws IOException {
        u.addPhoneNumber(getUser(),Integer.parseInt((phone.getText().toString())));
        
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
    
}
