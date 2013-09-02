package gmailmonitor.utils;

import gmailmonitor.beans.NetworkException;
import gmailmonitor.beans.ResponseException;
import gmailmonitor.gui.GUI;
import java.awt.TrayIcon;

import java.io.*;
import java.net.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SparkURLConnect {
    
    /**
     * @author Priyanka
     * @param number
     * @return String having response.
     * @throws NetworkException
     * @throws IOException
     * @throws ResponseException 
     */
    public String uRLConnectionReader(String number) throws NetworkException, IOException, ResponseException {

        String response = null;
        BufferedReader in = null;
        URI sparkURL = null;

        try {
            sparkURL = new URI(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("SPARK_AGENT1_PART1")+number+PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("SPARK_AGENT1_PART2"));
            URLConnection yc = sparkURL.toURL().openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                    GUI.getLoggerFrame().log("Response from Spark:"+inputLine);

                if (null != inputLine && inputLine.contains("<ResponseDescription>")) {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder parsing = factory.newDocumentBuilder();
                    Document document = parsing.parse(new InputSource(new StringReader(inputLine)));

                    NodeList nodeList = document.getElementsByTagName("ResponseDescription");
                    Node nValue = (Node) nodeList.item(0);
                    response = nValue.getTextContent();
                    GUI.getLoggerFrame().log("Response:" + response);

                }
            }
        } catch (MalformedURLException me) {
            NetworkException newEx = new NetworkException();
            newEx.setExceptionMessage(me.getMessage());
            newEx.setHumanReadableExceptionMessage("SPark URL is not a valid URL. Please verify from Configuration.Properties file");
            throw newEx;
        } catch (URISyntaxException urie) {
            NetworkException newEx = new NetworkException();
            newEx.setExceptionMessage(urie.getMessage());
            newEx.setHumanReadableExceptionMessage("SPark URL is not a valid URL. Please verify from Configuration.Properties file");
            throw newEx;
        } catch (ParserConfigurationException pce) {
            ResponseException respEx = new ResponseException();
            respEx.setResponseMessage(pce.getMessage());
            respEx.setHumanReadableResponseMessage("We were unable to read the response from Spark. :(");
            throw respEx;
            
        } catch (SAXException saxe) {
            ResponseException respEx = new ResponseException();
            respEx.setResponseMessage(saxe.getMessage());
            respEx.setHumanReadableResponseMessage("Response is not a valid Response xml.. :(");
            throw respEx;
        } finally {

            if (in != null) {
                try {
                    in.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
        return response;

    }

    public String uRLConnectionReader(String number, int agentIndex) throws NetworkException, IOException, ResponseException {
        GUI.getLoggerFrame().log("Invoked uRLConnectionReader() for phone number:"+number+" for agent="+agentIndex);
        String response = null;
        BufferedReader in = null;
        URI sparkURL = null;

        try {
            sparkURL = new URI(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("SPARK_AGENT" + agentIndex + "_PART1") + number + PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("SPARK_AGENT" + agentIndex + "_PART2"));
            GUI.getTrayIcon().displayMessage("Gmail Monitor", "Dialling no.-"+number+" through agent-"+agentIndex, TrayIcon.MessageType.INFO);
            URLConnection yc = sparkURL.toURL().openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
               

                if (null != inputLine && inputLine.contains("<ResponseCode>")) {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder parsing = factory.newDocumentBuilder();
                    Document document = parsing.parse(new InputSource(new StringReader(inputLine)));

                    NodeList nodeList = document.getElementsByTagName("ResponseCode");
                    Node nValue = (Node) nodeList.item(0);
                    response = nValue.getTextContent();
                    GUI.getLoggerFrame().log("Response:" + response);

                }
            }
        } catch (MalformedURLException me) {
            NetworkException newEx = new NetworkException();
            newEx.setExceptionMessage(me.getMessage());
            newEx.setHumanReadableExceptionMessage("SPark URL is not a valid URL. Please verify from Configuration.Properties file");
            throw newEx;
        } catch (URISyntaxException urie) {
            NetworkException newEx = new NetworkException();
            newEx.setExceptionMessage(urie.getMessage());
            newEx.setHumanReadableExceptionMessage("SPark URL is not a valid URL. Please verify from Configuration.Properties file");
            throw newEx;
        } catch (ParserConfigurationException pce) {
            ResponseException respEx = new ResponseException();
            respEx.setResponseMessage(pce.getMessage());
            respEx.setHumanReadableResponseMessage("We were unable to read the response from Spark. :(");
            throw respEx;
        } catch (SAXException saxe) {
            ResponseException respEx = new ResponseException();
            respEx.setResponseMessage(saxe.getMessage());
            respEx.setHumanReadableResponseMessage("Response is not a valid Response xml.. :(");
            throw respEx;
        } finally {

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
        return response;

    }
}
