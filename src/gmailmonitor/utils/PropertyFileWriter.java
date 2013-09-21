/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.utils;

import gmailmonitor.gui.GUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author CodeBeast
 */
public class PropertyFileWriter {
    private final static String PROPERTY_FILE_NAME="configuration.properties";
    private final static String ERROR_FILE_NAME="errored";
    public final static Properties CONNECTION_PROPERTIES = new Properties();
    //private static File propFile;
    private static File f;
    private static ResourceBundle rb;
    
    static {
        try {
            System.out.println("In Static");
            loadProperties();
        } catch (IOException ex) {
            GUI.getLoggerFrame().log("ERROR!"+ex.getMessage());
        }
    }
    
    /**
     * MEthod to delete the error flag file from USER_HOME
     */
    public static void removeErrorFlagFile() {
        File temp = new File(System.getProperty("user.home")+File.separatorChar+ERROR_FILE_NAME);
        if (temp.exists())
            temp.delete();
    }
    
    /**
     * Method to create the error flag file in USER_HOME
     */
    public static void setErrorFlagFile() {
        try {
            FileUtils.touch(new File(System.getProperty("user.home")+File.separatorChar+ERROR_FILE_NAME));
        } catch (IOException ex) {
            GUI.getLoggerFrame().log("ERROR! While setting error flag file...: "+ex.getMessage());
        }
    }
    
    /**
     * Method to find if the error file existed.
     * @return 
     */
    public static boolean wasErroredInPreviousRun() {
        return new File(System.getProperty("user.home")+File.separatorChar+ERROR_FILE_NAME).exists();
    }
    
    public static void writeToPropertyFile(final String propertyName,final String propertyValue) {
        try {
            CONNECTION_PROPERTIES.setProperty(propertyName, propertyValue);
            //PropertyFileWriter.class.getResource("/resources/connections.properties").
            CONNECTION_PROPERTIES.store(new OutputStreamWriter(new FileOutputStream(f),"UTF-8"), null);
            
            //System.out.println("Successfully Saved to property file:"+propertyName+" - "+propertyValue);
            GUI.getLoggerFrame().log("Wrote to property file:"+propertyName+" - "+propertyValue);
        } catch (Exception ex) {
            GUI.getLoggerFrame().log("ERROR!"+ex.getMessage());
        }
    }
    
    private static void createPropertyFileIfAbsent() {
        
//        FileWriter fw=null;
        try {
            f = new File(System.getProperty("user.home")+File.separatorChar+PROPERTY_FILE_NAME);
            if (f.exists()) {
                GUI.getLoggerFrame().log(f.getAbsolutePath()+" is present at USER HOME");
                System.out.println(f.getAbsolutePath()+" is present at USER HOME");
                return;
            }
            //create the stuff.
            rb = ResourceBundle.getBundle("resources/init", Locale.US);
            List<String> allStrings = new ArrayList<String>();
            for(String s: rb.keySet()) {
                allStrings.add(new String((s+"="+rb.getString(s)).getBytes("UTF-8")));
            }
            GUI.getLoggerFrame().log("Warning! Config does not exist. Creating at:"+System.getProperty("user.home")+File.separatorChar+PROPERTY_FILE_NAME);
            System.out.println("Warning! Config does not exist. Creating at:"+System.getProperty("user.home")+File.separatorChar+PROPERTY_FILE_NAME);
            f.createNewFile();
            
//            System.out.println(Charset.defaultCharset());
            
            FileUtils.writeLines(f,"UTF-8",allStrings);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "We cannot create working file in location:"+System.getProperty("user.home")+"\n Exiting!", "OOPS!", JOptionPane.ERROR_MESSAGE);
            GUI.getLoggerFrame().log("ERROR!!"+ex.getMessage());
//            ex.printStackTrace();
//            try {
////                fw.close();
//            } catch (Exception ex1) {
//                //swallow
//            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }

    public static void loadProperties() throws IOException {
        createPropertyFileIfAbsent();
        InputStream inputStream = new FileInputStream(f);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        CONNECTION_PROPERTIES.load(reader);
        System.out.println("Loaded Properties...");
        //JOptionPane.showMessageDialog(null,);
        GUI.getLoggerFrame().log("Loaded the Properties file...");
        inputStream.close();
    }
    
    public static void main(String[] args) {
        System.out.println(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("password"));
        
    }

    public static void writeToPropertyFile(Map<String, String> propValues) {
        try {
            List<String> allStrings = new ArrayList<String>();
            for(String key:propValues.keySet()) {
                allStrings.add(new String((key+"="+propValues.get(key)).getBytes("UTF-8")));
                System.out.println(key+":"+propValues.get(key));
                
            }
            if(rb==null)
                rb = ResourceBundle.getBundle("resources/init", Locale.US);
            allStrings.add(new String( ("Number_of_Agent="+rb.getString("Number_of_Agent")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT2_PART2="+rb.getString("SPARK_AGENT2_PART2")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT2_PART1="+rb.getString("SPARK_AGENT2_PART1")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT1_PART2="+rb.getString("SPARK_AGENT1_PART2")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT1_PART1="+rb.getString("SPARK_AGENT1_PART1")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT3_PART2="+rb.getString("SPARK_AGENT3_PART2")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT3_PART1="+rb.getString("SPARK_AGENT3_PART1")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT4_PART2="+rb.getString("SPARK_AGENT4_PART2")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT4_PART1="+rb.getString("SPARK_AGENT4_PART1")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT5_PART2="+rb.getString("SPARK_AGENT5_PART2")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT5_PART1="+rb.getString("SPARK_AGENT5_PART1")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT6_PART2="+rb.getString("SPARK_AGENT6_PART2")).getBytes("UTF-8")));
            allStrings.add(new String( ("SPARK_AGENT6_PART1="+rb.getString("SPARK_AGENT6_PART1")).getBytes("UTF-8")));
            
            FileUtils.writeLines(f, "UTF-8", allStrings);
            loadProperties();
            
        }
        catch(Exception e) {
            e.printStackTrace();
            GUI.getLoggerFrame().log("ERROR! Cannot write to Property File..."+e.getMessage());
        }
    }
}
