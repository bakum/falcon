package view;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import oracle.adf.controller.ControllerContext;

public class ExeptionBean {
    private ControllerContext cc;
    
    public ExeptionBean() {
      cc = ControllerContext.getInstance();
    }
    
    public String getStacktrace() {
        if ( cc.getCurrentViewPort().getExceptionData()!=null ) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw); 
            cc.getCurrentViewPort().getExceptionData().printStackTrace(pw); 
            return sw.toString();            
        }
        return null;
    }
    

    public String sendMail()
    {
      Properties p = System.getProperties();
      p.put("mail.transport.protocol","smtp");
      p.put("mail.smtp.host","bmexp.com");

      Session session = Session.getInstance(p);
      MimeMessage message = new MimeMessage(session);
      try {
            message.setFrom(new InternetAddress("exception@imx.net.ua"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress("bakum@bmexp.com"));
            message.setSubject(cc.getCurrentViewPort().getExceptionData().getMessage());
            message.setContent(getStacktrace(),"text/plain");
            Transport.send(message);
        } catch (MessagingException e) {
            // TODO
           e.printStackTrace();
      }
      System.out.println(message.toString());
      return null;
    }
}
