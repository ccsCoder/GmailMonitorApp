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
        System.out.println("Spawned a new Scheduler Thread for Phone Number:"+userNum);
        
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
                System.out.println("Started calling agent with number:" + currentAgent + ": to phone " + customerPhoneNumber);

                while (!callAnswered && currentAgent > 0) { //countdown to the agent number
//                    _sparkResponse = Integer.parseInt(spark.uRLConnectionReader(userPhone, currentAgent));
                    sparkResponseCode = Integer.parseInt(spark.uRLConnectionReader(customerPhoneNumber, currentAgent));
                    System.out.println("Response from Spark:" + sparkResponseCode);
                    //take some decisions.
                    switch(sparkResponseCode) {
                        case 0: //SUCCESS
                            callAnswered=true;
                             GUI.getTrayIcon().displayMessage("Gmail Monitor", "Call Answered Successfully to number"+customerPhoneNumber+" by agent-"+currentAgent, TrayIcon.MessageType.INFO);
                            System.out.println("Call Answered Successfully by Agent number!-"+currentAgent);
                            break;
                        case 112: //Agent is busy, move to next agent.
                            currentAgent--;
                            System.out.println("Agent-"+currentAgent+" was busy. Moving on to next agent.");
                            count++;
                            break;
                        case 106: //Network Congestion
                            System.out.println("Network Congestion! Rescheduling call after some time...");
                            this.delayScheduleSameCall(this.customerPhoneNumber);
                            callAnswered=true;      //No need to keep running this thread anymore.
                            break;
                        case 107: //Customer Unreachable
                            System.out.println("Customer Unreachable. Will not reschedule...");
                            callAnswered=true;      //No use wasting resources on a customer who's unreachable. Maybe roaming.
                            break;
                        case 108:   //Customer busy on another call.
                            System.out.println("Customer Busy on another call. Rescheduling call after a delay...");
                            this.delayScheduleSameCall(this.customerPhoneNumber); 
                            callAnswered=true;      //No need to keep running this thread anymore.
                            break;
                        default:   //unknown error
                            GUI.getTrayIcon().displayMessage("Gmail Monitor", "Please contact to Spark guys to dial number"+customerPhoneNumber+" by agent-"+currentAgent, TrayIcon.MessageType.ERROR);
                            System.out.println("Mayday, Mayday! He's dead Jim! And we have no Idea why. Maybe you should get hold of those Spark guys!");
                            callAnswered=true;
                            break;
                    }
                }
                System.out.println("Out of inner decision Schedule Loop...");
                if(count==Integer.parseInt(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("Number_of_Agent"))) {
                     this.delayScheduleSameCall(customerPhoneNumber);
                     break;
				 
                 }
            } catch (NetworkException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ResponseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    private void delayScheduleSameCall(String userPhone) {
        System.out.println("Will Schedule Call for -"+userPhone+" in a while...");
        //schedule it for 2 minutes from now... and get the hell out of here...
        new Timer().schedule(new AgentScheduler(customerPhoneNumber),   120000);
    }
}
