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
