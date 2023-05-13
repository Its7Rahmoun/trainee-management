/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class sendEmail {
    public static void  send(String to,String from,String fromemailpass,String subject,String msg){



      //provide Mailtrap's host address
      String host = "localhost";
      //configure Mailtrap's SMTP server details
      Properties props = System.getProperties();

      
      

        props.put("mail.smtp.user","username"); 
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "25"); 
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable","true"); 
        props.put("mail.smtp.EnableSSL.enable","true");

props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
props.setProperty("mail.smtp.socketFactory.fallback", "false");   
props.setProperty("mail.smtp.port", "465");   
props.setProperty("mail.smtp.socketFactory.port", "465");

      //create the Session object
      //fromemailpass=gtgvjzxtnddajiav
      Session session = Session.getInstance(props,new javax.mail.Authenticator(){
      
          protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(from,fromemailpass);
    }
      
      });  
      try {
    //create a MimeMessage object
    Message message = new MimeMessage(session);
    //set From email field
    message.setFrom(new InternetAddress(from));
   //set To email field
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    //set email subject field
    message.setSubject(subject);
    //set the content of the email message
    message.setText(msg);
    //send the email message
    Transport.send(message);
    

    JOptionPane.showMessageDialog(null,"Email Message Sent Successfully");
      } catch (MessagingException e) {
JOptionPane.showMessageDialog(null,e);
      }
    
        
    }
    
}
