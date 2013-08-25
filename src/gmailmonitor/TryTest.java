/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CodeBeast
 */
public class TryTest {
    public static void main(String  []args) {
        String s= "Hello 99 Hi 29";
        Pattern p = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        while(m.find())
            System.out.println(m.group());
        
    }
 
}
