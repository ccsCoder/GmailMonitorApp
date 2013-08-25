/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author CodeBeast
 */
public class PropertyFileWriter {
    private final static String PROPERTY_FILE_NAME="connections.properties";
    public final static Properties CONNECTION_PROPERTIES = new Properties();
    //private static File propFile;
    
    static {
        try {
            //System.out.println();
            //propFile= new File(System.getProperty("user.dir")+File.separator+PROPERTY_FILE_NAME);
            
            //System.out.println("File read from:"+propFile.getAbsolutePath().toString());
            CONNECTION_PROPERTIES.load(PropertyFileWriter.class.getResourceAsStream("/resources/connections.properties"));
        } catch (IOException ex) {
            System.out.println("OOPS!"+ex.getMessage());
        }
    }
    
    public static void writeToPropertyFile(final String propertyName,final String propertyValue) {
        try {
            CONNECTION_PROPERTIES.setProperty(propertyName, propertyValue);
            //PropertyFileWriter.class.getResource("/resources/connections.properties").
            CONNECTION_PROPERTIES.store(new FileOutputStream(PropertyFileWriter.class.getResource("/resources/connections.properties").getFile()), null);
            System.out.println("Successfully Saved to property file:"+propertyName+" - "+propertyValue);
        } catch (Exception ex) {
            System.out.println("OOPS!"+ex.getMessage());
        }
    }
}
