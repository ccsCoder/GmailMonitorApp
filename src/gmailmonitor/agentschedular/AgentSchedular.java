package gmailmonitor.agentschedular;

import gmailmonitor.beans.NetworkException;
import gmailmonitor.beans.ResponseException;
import gmailmonitor.utils.AgentRouterUtil;
import gmailmonitor.utils.PropertyFileWriter;
import gmailmonitor.utils.SparkURLConnect;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AgentSchedular extends TimerTask {

String userPhone=null;
String _sparkResponse=null;
int currentAgent =0;
SparkURLConnect spark=null;
	
public AgentSchedular(String userNum){

	currentAgent= Integer.parseInt(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("Number_of_Agent"));	
	spark= new SparkURLConnect();
	userPhone=userNum;
}



public void run()
{
	boolean callHandle=false;
	int count=0;
        AgentRouterUtil agentMessage=new AgentRouterUtil();
	
	while(!callHandle){
		try {
			System.out.println("Started calling agent with number:"+currentAgent+": "+userPhone);
			
			while(!(currentAgent==0)){
			
			_sparkResponse=spark.uRLConnectionReader(userPhone,currentAgent);
			
			 String str=agentMessage.getMessage(_sparkResponse);
			 System.out.println("Response from Spark:"+ _sparkResponse);
			//Agent
			if(_sparkResponse.equalsIgnoreCase("0"))
			{
				callHandle=true;
				break;
				
			}
			else if(_sparkResponse.equalsIgnoreCase("112")) {
				currentAgent=currentAgent-1;
				count++;
			}
                        else{
                            currentAgent=currentAgent-1;
                        }
			}
                       callHandle=true; 
			/*if(count=='3')	
			{
					Timer newSchedule= new Timer();
					AgentSchedular newSchedular= new AgentSchedular(userPhone);
					newSchedule.schedule(newSchedular,110000);
                                        System.out.println("all 3 agent busy:"+userPhone);
				 break;
				 
			}*/
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


}
