/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.utils;

import gmailmonitor.agentscheduler.AgentScheduler;
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

    public static void readMultipartMessage(Message msg) throws IOException, MessagingException, NetworkException, ResponseException {        
        Object mailContent = msg.getContent();
        Timer agentThreadTimer = new Timer("AgentThread");
        //ArrayList<String> num = new ArrayList<String>();
        PersonDetails personDetailed;
        
        
        if (mailContent instanceof Multipart) {
            
            Multipart mp = (Multipart) mailContent;
            personDetailed = ParsingInbox.patternMatch(mp);
            

            for (int j = 0; j < personDetailed.getNumber().size(); j++) { 
                AgentScheduler agent = new AgentScheduler((personDetailed.getNumber().get(j)).substring(3, 13),personDetailed.getName(),personDetailed.getLocation());
                agentThreadTimer.schedule(agent, 5000);
            }

        }
    }
}
