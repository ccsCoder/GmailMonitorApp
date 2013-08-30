/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.utils;

import gmailmonitor.agentschedular.AgentSchedular;
import gmailmonitor.beans.*;

import java.io.IOException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import java.util.ArrayList;
import java.util.Timer;


/**
 *
 * @author CodeBeast
 */
public class MultipartEmailReader {
	
    public static String readMultipartMessage(Message msg) throws IOException, MessagingException,NetworkException, ResponseException {
        String mailTextResponse=null;
        Object mailContent = msg.getContent();
        SparkURLConnect sparkCon= new SparkURLConnect();
        Timer agentThreadTimer = new Timer("AgentThread");
        
        ArrayList<String> num= new ArrayList<String>();
       
        if ( mailContent instanceof Multipart) {
        	
            System.out.println("Multipart Message. Gotcha!");
            Multipart mp = (Multipart) mailContent;
            num=ParsingInbox.patternMatch(mp);
            
            for(int j=0;j<num.size();j++)
               	{
            		//mailTextResponse=sparkCon.uRLConnectionReader((num.get(j)).substring(3, 13));
            	AgentSchedular agent = new AgentSchedular((num.get(j)).substring(3, 13));
            	agentThreadTimer.schedule(agent,110000);
            	 }
             
            }
        
       
        
      return mailTextResponse;
        
    }
}
