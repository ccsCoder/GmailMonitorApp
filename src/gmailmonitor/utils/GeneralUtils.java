/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.utils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author NISHANTG
 */
public class GeneralUtils {
    
    public static final int SUCCESS_MESSAGE=1;
    public static final int FAILURE_MESSAGE=2;
    public static final int WARNING_MESSAGE=3;
    public static final String NEWLINE = System.getProperty("line.separator");
    static String CONFIG_FILE_TEXT="password=gfgzfwonzexruvkh" +NEWLINE+
        "folder=Inbox" + NEWLINE+
        "host=imap.gmail.com" +NEWLINE+
        "username=" +NEWLINE+
        "SPARK_AGENT1_PART1=http://182.71.34.253/SparkCloudServices/controller?requestType=MAKE_CALL&auth=1a79d65a1176adab1ef583ede8a1494744924e9cc12457c683467776d6e36f2b20fbcab9129fdd728f3e5dd412a3a89d5514e5cc0e498aa2b648cc87d5e48ab1d987215cb250ed1f554eb12817d5175de8f65a935a8297c4067b5ff44cdb53f4d4b6eb73849bdc05308fae32a442f0fb0a2ed180c6ddacd969ecd53cfd4ba4c5&userIPAddress=192.168.1.12&responseFormat=XML&numbersToCall=" +NEWLINE+
        "SPARK_AGENT1_PART2=&agentNumber=4060601010&recording=false&agentDialFirst=false&numbersToCallCountryCode=91" +NEWLINE+
        "SPARK_AGENT2_PART1=http://182.71.34.253/SparkCloudServices/controller?requestType=MAKE_CALL&auth=3e18df72c97737d62e13e65c9ede3e903fb21f7f175997127549b61204578750f7bcb30418b4ac8401c85e3bf56d065c59d78f8f2f37b88eecccb51b627e8621ede506107ab8d944178fc84c57f16fc936d5ed1fcc8733b7de725e1a7089f2df5abf8e209294493ddfedcddbbbba18c4d621a4d2970c227ea49c60c125165f22&userIPAddress=192.168.1.12&responseFormat=XML&numbersToCall=" +NEWLINE+
        "SPARK_AGENT2_PART2=&agentNumber=4060123400&recording=false&agentDialFirst=false&numbersToCallCountryCode=91" +NEWLINE+
        "SPARK_AGENT3_PART1=http://182.71.34.253/SparkCloudServices/controller?requestType=MAKE_CALL&auth=0d149f227f1a3cf229679676af212551e6234595ef6e26e507ba2968f243b1125b3800ecc68f77f45c5d06ac539ba7cc32e0a7a95cf5632807292139f2a8dc005ba84c12b8f024445abd85eab878e69d772dbc299361c4429e6564e7aee3f954186e09e1ca4f1bfe4a06be6e8ce557f3cfda1bed461d38ff925f5109803a9831&userIPAddress=192.168.1.12&responseFormat=XML&numbersToCall=" +NEWLINE+
        "SPARK_AGENT3_PART2=&agentNumber=4060608080&recording=false&agentDialFirst=false&numbersToCallCountryCode=91" +NEWLINE+
        "Number_of_Agent=3";
    
    
    public static void displayMessage(String msg, int type, JLabel label, JPanel labelContainer) {
        switch(type) {
            case SUCCESS_MESSAGE:         //success
                labelContainer.setBackground(new Color(204, 255, 204));
                break;
            case FAILURE_MESSAGE:         //error
                labelContainer.setBackground(new Color(255,204,204));
                break;
            case WARNING_MESSAGE:         //Warning
                labelContainer.setBackground(new Color(255,204,102));
                break;
            
        }
        label.setText(msg);
    }
    
}
