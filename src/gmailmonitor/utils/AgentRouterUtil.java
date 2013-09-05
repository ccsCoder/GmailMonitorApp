package gmailmonitor.utils;

import gmailmonitor.beans.NetworkException;
import gmailmonitor.beans.ResponseException;
import gmailmonitor.gui.GUI;

import java.io.IOException;

public class AgentRouterUtil {
	
	public String getMessage(String responseCode) throws NetworkException, IOException, ResponseException{
		
		//String  Responsestr=spark.uRLConnectionReader("8880509273");
		String UserMsg=PropertyMessageReader.MESSAGE_PROPERTIES.getProperty(responseCode);
		GUI.getLoggerFrame().log("UserMessage :"+ UserMsg);
		return UserMsg;
		}
		

}
