package gmailmonitor.agentscheduler;

import gmailmonitor.beans.NetworkException;
import gmailmonitor.beans.ResponseException;
import gmailmonitor.gui.GUI;
import gmailmonitor.utils.PropertyFileWriter;
import gmailmonitor.utils.SparkURLConnect;
import java.awt.TrayIcon;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Priyanka 
 * @version 1.0
 * This class is used to schedule the calls between Agents.
 */
public class AgentScheduler extends TimerTask {

    private String customerPhoneNumber = null;
    
    public AgentScheduler(String userNum) {
        
        GUI.getLoggerFrame().log("Spawned a new Scheduler Thread for Phone Number:"+userNum);
        this.customerPhoneNumber = userNum;
    }
    
    
    @Override
    /**
     * this method will run in a separate thread whenever .schedule is invoked.
     */
    public void run() {
        boolean callAnswered = false;
        int count = 0,sparkResponseCode;
//        AgentRouterUtil agentMessage = new AgentRouterUtil();
        int currentAgent = Integer.parseInt(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("Number_of_Agent"));
        SparkURLConnect spark = new SparkURLConnect();

        while (!callAnswered) {
            try {
                
                 GUI.getLoggerFrame().log("Started calling agent with number:" + currentAgent + ": to phone " + customerPhoneNumber);
                while (!callAnswered && currentAgent > 0) { //countdown to the agent number
//                    _sparkResponse = Integer.parseInt(spark.uRLConnectionReader(userPhone, currentAgent));
                    sparkResponseCode = Integer.parseInt(spark.uRLConnectionReader(customerPhoneNumber, currentAgent));
                    
                     GUI.getLoggerFrame().log("Response from Spark:" + sparkResponseCode);
                    //take some decisions.
                    switch(sparkResponseCode) {
                        case 0: //SUCCESS
                            callAnswered=true;
                             GUI.getTrayIcon().displayMessage("Gmail Monitor", "Call Answered Successfully to number"+customerPhoneNumber+" by agent-"+currentAgent, TrayIcon.MessageType.INFO);
                             GUI.getLoggerFrame().log("Call Answered Successfully by Agent number!-"+currentAgent);
                             break;
                        case 112: //Agent is busy, move to next agent.
                            currentAgent--;
                            count++;
                            GUI.getLoggerFrame().log("Agent-"+currentAgent+" was busy. Moving on to next agent.");
                            break;
                        case 106: //Network Congestion
                            GUI.getLoggerFrame().log("Network Congestion! Rescheduling call after some time...");
                            this.delayScheduleSameCall(this.customerPhoneNumber);
                            callAnswered=true;      //No need to keep running this thread anymore.
                            break;
                        case 107: //Customer Unreachable
                             GUI.getLoggerFrame().log("Customer Unreachable. Will not reschedule...");
                             callAnswered=true;      //No use wasting resources on a customer who's unreachable. Maybe roaming.
                             break;
                        case 108:   //Customer busy on another call.
                            GUI.getLoggerFrame().log("Customer Busy on another call. Rescheduling call after a delay...");
                            this.delayScheduleSameCall(this.customerPhoneNumber); 
                            callAnswered=true;      //No need to keep running this thread anymore.
                            break;
                        default:   //unknown error
                            GUI.getTrayIcon().displayMessage("Gmail Monitor", "Please contact to Spark guys to dial number"+customerPhoneNumber+" by agent-"+currentAgent, TrayIcon.MessageType.ERROR);
                            GUI.getLoggerFrame().log("Mayday, Mayday! He's dead Jim! And we have no Idea why. Maybe you should get hold of those Spark guys!");
                            callAnswered=true;
                            break;
                    }
                }
                 GUI.getLoggerFrame().log("Out of inner decision Schedule Loop...");
                if(count==Integer.parseInt(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("Number_of_Agent"))) {
                     this.delayScheduleSameCall(customerPhoneNumber);
                     break;
				 
                 }
            } catch (NetworkException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ResponseException e) {
                e.printStackTrace();
            }

        }
    }

    private void delayScheduleSameCall(String userPhone) {
       
        GUI.getLoggerFrame().log("Will Schedule Call for -"+userPhone+" in a while...");
        //schedule it for 2 minutes from now... and get the hell out of here...
        new Timer().schedule(new AgentScheduler(customerPhoneNumber),   120000);
    }
}
