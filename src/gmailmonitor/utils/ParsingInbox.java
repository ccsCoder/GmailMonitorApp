package gmailmonitor.utils;

import gmailmonitor.beans.*;
import gmailmonitor.gui.GUI;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.BodyPart;

public class ParsingInbox {
	
	
	public static PersonDetails patternMatch(Multipart mp) throws ResponseException{
            //System.out.println("Inside()");
            String[] name=new String[2];
            String nameLocation=null;
            BufferedReader br = null;
            PersonDetails personD=new PersonDetails();
            ArrayList<String> number=new ArrayList<String>();
            Pattern pattern = Pattern.compile("\\+91-?[1-9][ \\d]{9}");
            BodyPart bp = null;
                
	try{
            //System.out.println("Inside Try"+mp.getCount());
            GUI.getLoggerFrame().log("Got these number of body parts:"+mp.getCount());
		for(int i=0;i<mp.getCount()-1;i++) {
                    
			bp= mp.getBodyPart(i);
                        
			Matcher matcher = null;//pattern.matcher(bp.getContent().toString());
                        
                        br = new BufferedReader(new InputStreamReader(bp.getInputStream()));
                        String allText=bp.getContent().toString();
                        
                        int startIndex=allText.toLowerCase().indexOf("caller name");
                        int lastIndex=(allText.toLowerCase()).indexOf("caller requirement");
                        nameLocation=allText.substring(startIndex, lastIndex);
                        nameLocation=nameLocation.replace("*","");
                        nameLocation=nameLocation.replace(":","");
                        name=nameLocation.split("from");
                        name[0]=name[0]==null?"Unknown":name[0];
                        name[1]=name[1]==null?"Unknown":name[1];
                        personD.setName(name[0]);
                        personD.setLocation(name[1]);
                                                                
                       //Matcher for matching the phone numberstart with +91
                        matcher = pattern.matcher(allText);
                        String num=null;
                        while (matcher.find()) {
                             num = matcher.group();
                             GUI.getLoggerFrame().log("Got this number:"+num);
                             number.add(num);
                           }
                        personD.setNumber(number);
                        
                        //System.out.println("Total matched Number: "+number.toString()+" for Person: "+name[0]+" from : "+name[1]);
			GUI.getLoggerFrame().log("Total matched Number: "+number.toString()+" for Person: "+name[0]+" from : "+name[1]);
        
			}
		}	
		catch(MessagingException parsing)
		{
			ResponseException respEx= new ResponseException();
			respEx.setInValidNumber(parsing.getMessage());
			respEx.setHumanReadableResponseMessage("Number from JustDial is Invalid. Please verify the number.");
                        GUI.getLoggerFrame().log("ERROR: "+respEx.getHumanReadableResponseMessage()+ " --- "+parsing.getMessage());
			parsing.printStackTrace();
		}
	catch(IOException e)
	{
		ResponseException respEx= new ResponseException();
		respEx.setInValidNumber(e.getMessage());
		respEx.setHumanReadableResponseMessage("Invalid format of e-mail body. Can not read :(");
                GUI.getLoggerFrame().log("ERROR: "+respEx.getHumanReadableResponseMessage()+" --- "+e.getMessage());
		e.printStackTrace();
	}
        catch(Exception e) {
            GUI.getLoggerFrame().log("Something Really bad happened! -- - "+e.getMessage());
            e.printStackTrace();
        }
            
	return personD;

    }
//    public static void main(String[] args) {
//        String str="+91 <%2B919967056666>8805989190" ;
//    }
}


