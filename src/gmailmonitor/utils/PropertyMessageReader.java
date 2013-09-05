package gmailmonitor.utils;

import gmailmonitor.gui.GUI;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyMessageReader {
    private final static String PROPERTY_FILE_NAME="message.properties";
    private static ResourceBundle bundle;
    static {
        bundle = ResourceBundle.getBundle("resources/message");
        GUI.getLoggerFrame().log("Read Resource Bundle:"+PROPERTY_FILE_NAME);
    }
    
    public static String getProperty(String key) {
        return bundle.getString(key);
    }
	    
}


