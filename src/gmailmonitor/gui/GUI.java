/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.gui;

import gmailmonitor.Monitor;
import gmailmonitor.utils.GeneralUtils;
import gmailmonitor.utils.PropertyFileWriter;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author CodeBeast
 */
public class GUI extends javax.swing.JFrame {

    private boolean isValid = true;
    private SystemTray tray;
    private static TrayIcon trayIcon;
    private static LoggerFrame loggerFrame;
    private Monitor gmailTimerTask;
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        this.loggerFrame = new LoggerFrame();
        initComponents();
        //Also create the Logger Frame but keep it invisible.
        
        
    }
    
    /**
     * to return controlled instances of LoggerFrame
     * @return LoggerFrame
     */
    public static LoggerFrame getLoggerFrame() {
        return loggerFrame;
    }
    
    public static TrayIcon getTrayIcon() {
        return trayIcon;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSaveButton = new javax.swing.JButton();
        jCancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPassword2 = new javax.swing.JPasswordField();
        jTextUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jHostCombo = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jTextInboxName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextSubject = new javax.swing.JTextField();
        jTextSender = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanelNotificationPanel = new javax.swing.JPanel();
        jLabelNotification = new javax.swing.JLabel();

        setTitle("Configuration Screen");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jSaveButton.setText("Save >>");
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        jCancelButton.setText("<< Cancel");
        jCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Call Bot Configuration");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(23, 23, 23))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Connectivity Settings", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jPassword2.setText(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("password"));
        jPassword2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPassword2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassword2FocusLost(evt);
            }
        });

        jTextUsername.setText(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("username"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Password:");

        jPassword1.setText(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("password"));
        jPassword1.setToolTipText("<html>\n\t<strong>Enter your App specific password </strong>\n</html>");
        jPassword1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPassword1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassword1FocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Host:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Username:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Confirm Password:");

        jHostCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "gMail", "Yahoo!" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(97, 97, 97)
                        .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jHostCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHostCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(22, 22, 22))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Settings", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTextInboxName.setText(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("folder"));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Search this in Mail Subjects:");

        jTextSubject.setText("Call from");

        jTextSender.setText(PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("sender"));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Folder to Monitor:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Look for mails from this Sender:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextSender, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(102, 102, 102)
                        .addComponent(jTextInboxName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextInboxName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSender, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanelNotificationPanel.setBackground(new java.awt.Color(204, 255, 204));

        jLabelNotification.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNotification.setText("We only need a few details to get started !");

        javax.swing.GroupLayout jPanelNotificationPanelLayout = new javax.swing.GroupLayout(jPanelNotificationPanel);
        jPanelNotificationPanel.setLayout(jPanelNotificationPanelLayout);
        jPanelNotificationPanelLayout.setHorizontalGroup(
            jPanelNotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNotificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNotificationPanelLayout.setVerticalGroup(
            jPanelNotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNotificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelNotificationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelNotificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        try {
            
            if (this.jTextUsername.getText().trim().length() == 0) {
                //JOptionPane.showMessageDialog(null, "Please Provide a User Name", "OOPS!", JOptionPane.ERROR_MESSAGE);
                GeneralUtils.displayMessage("Please Provide a User Name", GeneralUtils.FAILURE_MESSAGE, this.jLabelNotification, jPanelNotificationPanel);
                this.jTextUsername.requestFocus();
                return;
            }
            if (this.jPassword1.getPassword().length == 0) {
                //JOptionPane.showMessageDialog(null, "Cannot leave Password field Empty!", "OOPS!", JOptionPane.ERROR_MESSAGE);
                GeneralUtils.displayMessage("Cannot leave Password field Empty!", GeneralUtils.FAILURE_MESSAGE, this.jLabelNotification, jPanelNotificationPanel);
                this.jPassword1.requestFocus();
                return;
            }

            if (!Arrays.equals(this.jPassword1.getPassword(), this.jPassword2.getPassword())) {
                //JOptionPane.showMessageDialog(null, "Both Passwords Do Not Match!", "OOPS!", JOptionPane.ERROR_MESSAGE);
                GeneralUtils.displayMessage("Both Passwords Do Not Match!", GeneralUtils.FAILURE_MESSAGE, this.jLabelNotification, jPanelNotificationPanel);
                this.jPassword2.requestFocus();
                return;
            }

            if (this.jTextInboxName.getText().trim().length() == 0) {
                //JOptionPane.showMessageDialog(null, "Please Provide a Folder to Monitor", "OOPS!", JOptionPane.ERROR_MESSAGE);
                GeneralUtils.displayMessage("Please Provide a Folder to Monitor!", GeneralUtils.FAILURE_MESSAGE, this.jLabelNotification, jPanelNotificationPanel);
                this.jTextInboxName.requestFocus();
                return;
            }
            
            if(this.jTextSubject.getText().trim().length()==0 && this.jTextSender.getText().trim().length()==0) {
                //JOptionPane.showMessageDialog(null, "You MUST provide either a Sender or a Subject !", "OOPS!", JOptionPane.ERROR_MESSAGE);
                GeneralUtils.displayMessage("You MUST provide either a Sender or a Subject !", GeneralUtils.FAILURE_MESSAGE, this.jLabelNotification, jPanelNotificationPanel);
                this.jTextSubject.requestFocus();
                return;
            }


            //Now persist the things in properties file.
            Map <String,String> propValues = new HashMap<String,String>();
            propValues.put("host", this.jHostCombo.getSelectedItem().toString().equals("gMail") ? "imap.gmail.com" : "imap.yahoo.com");
            propValues.put("username",this.jTextUsername.getText());
            propValues.put("password",new String(this.jPassword1.getPassword()));
            propValues.put("folder",this.jTextInboxName.getText());
            propValues.put("sender",this.jTextSender.getText());
            propValues.put("subject",this.jTextSubject.getText());
            PropertyFileWriter.writeToPropertyFile(propValues);
            
//            PropertyFileWriter.writeToPropertyFile("host", this.jHostCombo.getSelectedItem().toString().equals("gMail") ? "imap.gmail.com" : "imap.yahoo.com");
//            PropertyFileWriter.writeToPropertyFile("username", this.jTextUsername.getText());
//            PropertyFileWriter.writeToPropertyFile("password", new String(this.jPassword1.getPassword()));
//            PropertyFileWriter.writeToPropertyFile("folder", this.jTextInboxName.getText());
//            PropertyFileWriter.writeToPropertyFile("sender", this.jTextSender.getText());
//            PropertyFileWriter.writeToPropertyFile("subject", this.jTextSubject.getText());

            this.initSystemTray();
            
            //Stop previously running monitor
            this.stopGmailMonitor();
            
            //Now Initialize the Gmail Monitor.
            this.initGmailMonitor();
            
        } catch (AWTException ex) {
            System.out.println("OOPS! There was a problem in initializing the Tray!");
            GUI.getLoggerFrame().log("ERROR! There was a problem in initializing the Tray!");
            //ex.printStackTrace();
        }
    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void jCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButtonActionPerformed
        try {
            this.initSystemTray();
        } catch (AWTException ex) {
            System.out.println("OOPS! There was a problem in initializing the Tray!");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jCancelButtonActionPerformed

    private void jPassword1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword1FocusGained
        GeneralUtils.displayMessage("<html><p style='font-size:10pt'>Enter Application Specific Password if you have enabled 2 STEP VERIFICATION for your Account.</p>"
                + "<p style='font-size:10pt'> "
                + "For more Info: https://support.google.com/accounts/answer/185833?hl=en </p></html>", GeneralUtils.WARNING_MESSAGE, this.jLabelNotification, this.jPanelNotificationPanel);
    }//GEN-LAST:event_jPassword1FocusGained

    private void jPassword1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword1FocusLost
        GeneralUtils.displayMessage("We just need a few details to get Started!", GeneralUtils.SUCCESS_MESSAGE, this.jLabelNotification, this.jPanelNotificationPanel);
    }//GEN-LAST:event_jPassword1FocusLost

    private void jPassword2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword2FocusGained
        this.jPassword1FocusGained(evt);
    }//GEN-LAST:event_jPassword2FocusGained

    private void jPassword2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword2FocusLost
        this.jPassword1FocusLost(evt);
    }//GEN-LAST:event_jPassword2FocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            this.initSystemTray();
        } catch (AWTException ex) {
            GUI.getLoggerFrame().log("Exception while minimizing to system tray...!"+ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing
    
    private void centerWindow() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
 
        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            //swallow this
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
                gui.centerWindow();
                if (PropertyFileWriter.wasErroredInPreviousRun()) {
                    GeneralUtils.displayMessage("Something wasn't quite right in the previous run. Please recheck config!", GeneralUtils.FAILURE_MESSAGE, gui.jLabelNotification, gui.jPanelNotificationPanel);
                }
                else if (!gui.checkFirstTimeHit()) {
                    try {
                        //if returning to the app, go to SysTray Directly.
                        gui.initSystemTray();
                        //Now Initialize the Gmail Monitor.
                        gui.initGmailMonitor();
                    } catch (AWTException ex) {
                        System.out.println("OOPS! Cannot init System Tray");
                        GUI.getLoggerFrame().log("ERROR! Cannot Initialize System Tray");
                    }
                } 
//                else {
//                    JOptionPane.showMessageDialog(null, "Please take a moment to configure the app.", "First Launch", JOptionPane.INFORMATION_MESSAGE);
//                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancelButton;
    private javax.swing.JComboBox jHostCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNotification;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelNotificationPanel;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JTextField jTextInboxName;
    private javax.swing.JTextField jTextSender;
    private javax.swing.JTextField jTextSubject;
    private javax.swing.JTextField jTextUsername;
    // End of variables declaration//GEN-END:variables

    private void initSystemTray() throws AWTException {

        if (SystemTray.isSupported() == true) {
            tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/resources/icon.png"));
            trayIcon = new TrayIcon(image, "gMail Monitor", this.createPopupMenuForTray());
            trayIcon.setImageAutoSize(true);
            //add to tray
            tray.add(trayIcon);
            //make that form invisible
            this.setVisible(false);

        } else {
            System.out.println("\nSystemTray not supported!!!");
            GUI.getLoggerFrame().log("ERROR! SystemTray not supported!!!");
            this.setVisible(true);
            //failover if there is no system tray.
            GeneralUtils.displayMessage("Your Desktop Environment does not support minimizing to tray!", GeneralUtils.FAILURE_MESSAGE, this.jLabelNotification, this.jPanelNotificationPanel);
            
        }
    }

    private PopupMenu createPopupMenuForTray() {
        PopupMenu popup = new PopupMenu();
        MenuItem item1 = new MenuItem("Configuration");
        MenuItem item2 = new MenuItem("Exit! (Stop Monitoring and Calling)");
        MenuItem item3 = new MenuItem("View Activity Log");
        
        popup.add(item3);
        popup.add(item1);
        popup.add(item2);
        
        item1.addActionListener(new ActionListener() {
            //trayIcon.setPopupMenu(popup);
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.this.setVisible(true);
                tray.remove(trayIcon);
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "Whoa!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    tray.remove(trayIcon);
                    System.exit(0);
                }
            }
        });
        item3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.getLoggerFrame().setVisible(true);
            }
        });
        return popup;

    }

    private boolean checkFirstTimeHit() {
        String username = PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("username");
        if (username == null || username.trim().length() == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Method to stop the Monitor class...
     */
    private void stopGmailMonitor() {
        if (this.gmailTimerTask!=null)
            this.gmailTimerTask.setKeepMonitoring(false);
        this.gmailTimerTask = null;
    }
    
    /**
     * Method to initialize the Monitor Class...
     */
    private void initGmailMonitor() {
        Timer monitoringTimer = new Timer("GmailMonitorTimer");
        String host=PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("host");
        String userName=PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("username");
        String password=PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("password");
        String folder=PropertyFileWriter.CONNECTION_PROPERTIES.getProperty("folder");
        //Create the task
        gmailTimerTask = new Monitor(host,userName,password,folder);
        if(gmailTimerTask.startMonitor()==false) {
            //This means that an Error has occured.
            System.out.println("Houston! We have a problem !");
            System.out.println(gmailTimerTask.getError().getHumanReadableErrorMessage());
            JOptionPane.showMessageDialog(null, gmailTimerTask.getError().getHumanReadableErrorMessage(), "Something Went Wrong!", JOptionPane.ERROR_MESSAGE);
            GUI.getLoggerFrame().log(gmailTimerTask.getError().getHumanReadableErrorMessage());
            //Set the error flag.
            PropertyFileWriter.setErrorFlagFile();
            System.exit(1); //bail out
        }
        //Remove the property flag file if present.
        PropertyFileWriter.removeErrorFlagFile();
        System.out.println("Gmail Monitoring Task will start in 1 second...");
        GUI.getLoggerFrame().log("Gmail Monitoring Task will start in 1 second...");
        monitoringTimer.schedule(gmailTimerTask, 1000);
        this.trayIcon.displayMessage("Gmail Monitor", "Hi There! We're down here, monitoring your mails. Right Click for Additional Actions", TrayIcon.MessageType.INFO);
        
    }
}
