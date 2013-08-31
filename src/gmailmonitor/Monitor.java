package gmailmonitor;

import gmailmonitor.utils.MultipartEmailReader;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.event.*;

import com.sun.mail.imap.*;
import gmailmonitor.beans.Error;
import java.net.UnknownHostException;
import gmailmonitor.beans.*;
import gmailmonitor.utils.PropertyFileWriter;

/* Monitors given mailbox for new mail */
/**
 * Class that Monitors a folder
 *
 * @author Neo
 */
public class Monitor extends TimerTask {

    private String[] params = new String[4];
    private boolean keepMonitoring, successful;
    private Folder inbox;
    private gmailmonitor.beans.Error error;

    public Monitor(String host, String username, String password, String monitorFolderName) {
        params[0] = host;
        params[1] = username;
        params[2] = password;
        params[3] = monitorFolderName;
        //this.keepMonitoring = true;
        this.successful = true;
        
    }

    public Error getError() {
        return error;
    }

    public boolean isKeepMonitoring() {
        return keepMonitoring;
    }

    public void setKeepMonitoring(boolean keepMonitoring) {
        this.keepMonitoring = keepMonitoring;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public final boolean startMonitor() {
        this.keepMonitoring = true;
        return this.monitorMailbox(this.params);
    }

    public void stopMonitor() {
        this.keepMonitoring = false;
    }

    /**
     * Method that monitors the mailbox.
     *
     * @param params
     * @return boolean ( true / false )
     */
    private boolean monitorMailbox(String[] params) {
        try {
            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imaps");
            // Get a Session object
            Session session = Session.getDefaultInstance(props, null);

            // session.setDebug(true);
            System.out.println("Gmail Session created...");
            // Get a Store object
            Store store = session.getStore("imaps");

            // Connect
            store.connect(params[0], params[1], params[2]);

            System.out.println("Connected to Gmail...");

            // Open a Folder
            inbox = store.getFolder(params[3]);

            inbox.open(Folder.READ_ONLY);

            // Add messageCountListener to listen for new messages
            inbox.addMessageCountListener(new MessageCountAdapter() {
                @Override
                public void messagesAdded(MessageCountEvent ev) {
                    Message[] msgs = ev.getMessages();
                    System.out.println("Got " + msgs.length + " new messages");

                    // Dump out the new messages
                    for (int i = 0; i < msgs.length; i++) {
                        try {
                            if(msgs[i].getSubject().toLowerCase().contains(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("subject")) && 
                            	(msgs[i].getFrom()[0].toString().contains(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("sender"))))
                             {
                            	MultipartEmailReader.readMultipartMessage(msgs[i]);
                            
                            }

                        } catch (UnknownHostException uhe) {
                            System.out.println("OOPS! Something went wrong...");
                            Monitor.this.successful = false;
                            Monitor.this.error = new gmailmonitor.beans.Error("Connection Problem! Verify that-\n1.You are connected to the Internet.\n2.Account Details are correct in the Configuration Screen", uhe.getClass());
                        } catch (IOException ioex) {
                            System.out.println("OOPS! Something went wrong...");
                            Monitor.this.successful = false;
                            Monitor.this.error = new gmailmonitor.beans.Error("Problem Reading gMail Info! Verify that-\n1.You are connected to the Internet.", ioex.getClass());
                        } catch (MessagingException mex) {
                            System.out.println("OOPS! Something went wrong...");
                            Monitor.this.successful = false;
                            Monitor.this.error = new gmailmonitor.beans.Error("gMail is Acting up! :(", mex.getClass());
                        } catch (ResponseException respEx) {
                            System.out.println("OOPS! Something went wrong...");
                            Monitor.this.successful = false;
                            Monitor.this.error = new gmailmonitor.beans.Error(respEx.getMessage(), respEx.getClass());
                        } catch (NetworkException netEx) {
                            System.out.println("OOPS! Something went wrong...");
                            Monitor.this.successful = false;
                            Monitor.this.error = new gmailmonitor.beans.Error(netEx.getMessage(), netEx.getClass());
                        }

                    }
                }
            });

        } catch (MessagingException mse) {
            System.out.println("OOPS! Something went wrong...");
            Monitor.this.successful = false;
            Monitor.this.error = new gmailmonitor.beans.Error("OOPS!! There was a problem. Verify that-\n1.You are connected to the Internet.\n2.Account Details are correct in the Configuration Screen", mse.getClass());
            mse.printStackTrace();
        } 
        
        catch (Exception e) {
            System.out.println("OOPS! Something Went Wrong...");
            Monitor.this.successful = false;
            Monitor.this.error = new gmailmonitor.beans.Error("Keep Calm! Such things happen sometimes. Please restart the application.", e.getClass());
        } finally {
            return Monitor.this.successful;
        }

    }

    @Override
    public void run() {
        System.out.println("Listening to Messages...");

        try {

            while (this.keepMonitoring) {
                IMAPFolder f = (IMAPFolder) inbox;
                f.idle();
                System.out.println("IDLE done");
            }

            System.out.println("Flag was falsified. Quitting listening.");
            this.inbox.close(false);
        } catch (FolderClosedException fex) {
            fex.printStackTrace();
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
