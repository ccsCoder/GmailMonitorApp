package gmailmonitor.utils;

import gmailmonitor.gui.GUI;
import java.io.IOException;
import java.util.Properties;

public class PropertyMessageReader {
	
	    private final static String PROPERTY_FILE_NAME="message.properties";
	    public final static Properties MESSAGE_PROPERTIES = new Properties();
	    //private static File propFile;
	    
	    static {
	        try {
	            loadProperties();
	        } catch (IOException ex) {
	            GUI.getLoggerFrame().log("ERROR!"+ex.getMessage());
	        }
	    }
	    public static void loadProperties() throws IOException {
	    	MESSAGE_PROPERTIES.load(PropertyFileWriter.class.getResourceAsStream("/resources/message.properties"));
	         GUI.getLoggerFrame().log("Loaded Properties...");
	    }
	}


