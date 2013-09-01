package gmailmonitor.utils;

import gmailmonitor.beans.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.BodyPart;

public class ParsingInbox {
	
	
	public static ArrayList<String> patternMatch(Multipart mp) throws ResponseException{
		
		ArrayList<String> number=new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\+91-?[1-9][ \\d]{9}");
		BodyPart bp = null;
	try{
		for(int i=0;i<mp.getCount()-1;i++) {
			bp= mp.getBodyPart(i);
			Matcher matcher = pattern.matcher(bp.getContent().toString());
			//System.out.println("Full string for match: "+bp.getContent().toString());
		    
			while(matcher.find()) 
			{
				number.add(matcher.group());
			}
			
			System.out.println("Total matched Number: "+number.toString());
        
			}
		}	
		catch(MessagingException parsing)
		{
			ResponseException respEx= new ResponseException();
			respEx.setInValidNumber(parsing.getMessage());
			respEx.setHumanReadableResponseMessage("Number from JustDial is Invalid. Please verify the number.");
			
		}
	catch(IOException e)
	{
		ResponseException respEx= new ResponseException();
		respEx.setInValidNumber(e.getMessage());
		respEx.setHumanReadableResponseMessage("Invalid format of e-mail body. Can not read :(");
		
	}
		return number;

	}
}
