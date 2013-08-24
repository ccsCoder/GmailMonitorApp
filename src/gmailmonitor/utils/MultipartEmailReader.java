/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.utils;

import java.io.IOException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;

/**
 *
 * @author CodeBeast
 */
public class MultipartEmailReader {
    public static String readMultipartMessage(Message msg) throws IOException, MessagingException {
        String mailText=null;
        Object mailContent = msg.getContent();
        if ( mailContent instanceof Multipart) {
            System.out.println("Multipart Message. Gotcha!");
            Multipart mp = (Multipart) mailContent;
            BodyPart bp = null;
            for(int i=0;i<mp.getCount();i++) {
                bp= mp.getBodyPart(i);
                System.out.println(bp.getContent().toString());
            }
        }
        return mailText;
        
    }
}
