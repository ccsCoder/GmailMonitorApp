package gmailmonitor.utils;

import gmailmonitor.beans.NetworkException;
import gmailmonitor.beans.ResponseException;

import java.io.IOException;

public class AgentRouterUtil {
	
	public String getMessage(String responseCode) throws NetworkException, IOException, ResponseException{
		
		//String  Responsestr=spark.uRLConnectionReader("8880509273");
		String UserMsg=PropertyMessageReader.getProperty(responseCode);
		System.out.println("UserMessage :"+ UserMsg);
		return UserMsg;
		}
		

}
