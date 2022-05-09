package utils;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


/**
 *
 * @author Kalai
 */
public class SendSms implements Initializable {
    
     public static final String ACCOUNT_SID =
             "AC8ba4f9fd43db3b2f9d8ee21015a97b33";
    public static final String AUTH_TOKEN =
            "9e530769022106286e0cdee546116928";

        @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    
    public void send(int numTel,String messageContent){
       
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

     
        try {

        Message message = Message 
                .creator(new PhoneNumber("+216"+Integer.toString(numTel)), // to
                        new PhoneNumber("+13808883563"), // from
                       messageContent)
                .create();
        System.out.println(message.getSid());
        }catch(final ApiException ex){
            System.out.println(ex.getMessage());
            
        }
    
  
    }

}
