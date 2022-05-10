/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author FK Info
 */
public class email {
    
    public static void sendmail() throws MessagingException
    {
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myacountemail="syrine.benslim@esprit.tn";
        String mdp="syrine1998";
        String recepient="syrine.benslim@esprit.tn";
        Session session=Session.getInstance(properties,new Authenticator(){
          @Override
           protected PasswordAuthentication getPasswordAuthentication()
           {
               return new PasswordAuthentication(myacountemail,mdp);
           }
        });
        session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Message message=prepareMessage(session,myacountemail,recepient);
        Transport.send(message);
        System.out.println("message envoyer");
    }

    private static Message prepareMessage(Session session, String myacountemail, String recepient) {
        try {
            Message message=new MimeMessage(session) ;
            message.setFrom(new InternetAddress(myacountemail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient) );
            message.setSubject("notifiaction!");
            message.setText("review effectué!");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    };
}
