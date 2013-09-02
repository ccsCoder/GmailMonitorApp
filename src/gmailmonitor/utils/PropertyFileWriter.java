/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.utils;

import gmailmonitor.gui.GUI;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author CodeBeast
 */
public class PropertyFileWriter {
    private final static String PROPERTY_FILE_NAME="configuration.properties";
    public final static Properties CONNECTION_PROPERTIES = new Properties();
    //private static File propFile;
    
    static {
        try {
            loadProperties();
        } catch (IOException ex) {
            GUI.getLoggerFrame().log("ERROR!"+ex.getMessage());
        }
    }
    
    public static void writeToPropertyFile(final String propertyName,final String propertyValue) {
        try {
            CONNECTION_PROPERTIES.setProperty(propertyName, propertyValue);
            //PropertyFileWriter.class.getResource("/resources/connections.properties").
            CONNECTION_PROPERTIES.store(new FileOutputStream(PropertyFileWriter.class.getResource("/resources/configuration.properties").getFile()), null);
            GUI.getLoggerFrame().log("Wrote to property file:"+propertyName+" - "+propertyValue);
        } catch (Exception ex) {
            GUI.getLoggerFrame().log("ERROR!"+ex.getMessage());
        }
    }

    public static void loadProperties() throws IOException {
        CONNECTION_PROPERTIES.load(PropertyFileWriter.class.getResourceAsStream("/resources/configuration.properties"));
        GUI.getLoggerFrame().log("Loaded the Properties file...");
    }
}
