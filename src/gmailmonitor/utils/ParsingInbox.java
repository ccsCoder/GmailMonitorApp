package gmailmonitor.utils;

import gmailmonitor.beans.*;
import gmailmonitor.gui.GUI;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;

public class ParsingInbox {
	
	
	public static PersonDetails patternMatch(Multipart mp) throws ResponseException{
		String[] name=new String[2];
		String nameLocation=null;
                BufferedReader br = null;
                PersonDetails personD=null;
		ArrayList<String> number=new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\+91-?[1-9][ \\d]{9}");
		BodyPart bp = null;
	try{
		for(int i=0;i<mp.getCount()-1;i++) {
			bp= mp.getBodyPart(i);
			Matcher matcher = pattern.matcher(bp.getContent().toString());
                        
                        br = new BufferedReader(new InputStreamReader(bp.getInputStream()));
                        String allText=bp.getContent().toString();
                        String[] matchName = allText.split("\\r?\\n");
                        
			while(matcher.find()) 
			{
				number.add(matcher.group());
			}
			 
                        for(String m: matchName) {
                            if( (m.toLowerCase()).contains("caller name"))
                            {
                              int startIndex=m.indexOf(":");
                              int lastIndex=(m.toLowerCase()).indexOf("caller requirement");
                              nameLocation=m.substring(startIndex, lastIndex);
                              nameLocation=nameLocation.replace("*","");
                              name=nameLocation.split("from");
                              personD=new PersonDetails(name[0],name[1],number);
                              break;
                            }
                         }
                        System.out.println("Total matched Number: "+number.toString()+" for Person: "+name[0]+" from : "+name[1]);
			GUI.getLoggerFrame().log("Total matched Number: "+number.toString()+" for Person: "+name[0]+" from : "+name[1]);
        
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
		return personD;

	}
        
       
        
       
}


