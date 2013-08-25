/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor;

import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CodeBeast
 */
public class GmailMonitorDriver {
    public static void main(String[] args) {
        Timer monitoringTimer = new Timer("GmailMonitorTimer");
        String host="imap.gmail.com";
        String userName="ccsCoder";
        String password="gfgzfwonzexruvkh";
        String folder="Inbox";
        //Create the task
        Monitor gmailTimerTask = new Monitor(host,userName,password,folder);
        if(gmailTimerTask.startMonitor()==false) {
            //This means that an Error has occured.
            System.out.println("Houston! We have a problem !");
            System.out.println(gmailTimerTask.getError().getHumanReadableErrorMessage());
            System.exit(1); //bail out
        }
        System.out.println("Gmail Monitoring Task will start in 1 second...");
        monitoringTimer.schedule(gmailTimerTask, 1000);
        
       
    }
}
