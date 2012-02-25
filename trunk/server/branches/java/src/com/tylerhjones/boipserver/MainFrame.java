/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Feb 25, 2012, 10:40:16 AM
 */

package com.tylerhjones.boipserver;

import java.util.Hashtable;
import javax.swing.JOptionPane;
/**
 *
 * @author tyler
 */
public class MainFrame extends javax.swing.JFrame {

    private String TAG = "MainFrame";

    private ServerCore CORE;

    private Hashtable OrigSets = new Hashtable(4);
    private Settings SET = new Settings();


    public void setCore(ServerCore c) {
        CORE = c;
    }

    /** Creates new form MainFrame */
    public MainFrame(ServerCore c) {
        CORE = c;
        initComponents();
         //Save the current settings to a dictionary so we can compare them later
        OrigSets.put("host", new String(SET.getHost()));
        OrigSets.put("port", new Integer(SET.getPort()));
        OrigSets.put("pass", new String(SET.getPass()));
        OrigSets.put("newl", new Boolean(SET.getAppendNL()));

        txtHost.setText(OrigSets.get("host").toString());
        txtPassword.setText(OrigSets.get("pass").toString());
        txtPort.setText(OrigSets.get("port").toString());
        chkAppendNL.setSelected(Boolean.valueOf(OrigSets.get("newl").toString()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnApply = new javax.swing.JButton();
        btnToggleServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnAbout = new javax.swing.JButton();
        chkAppendNL = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BarcodeOverIP-Server 0.3.1 Beta - Settings");
        setAlwaysOnTop(true);
        setName("MainWindow"); // NOI18N

        btnExit.setText("Exit");
        btnExit.setToolTipText("Exit the server application and close all connections.");
        btnExit.setMaximumSize(new java.awt.Dimension(85, 29));
        btnExit.setMinimumSize(new java.awt.Dimension(65, 29));
        btnExit.setPreferredSize(new java.awt.Dimension(85, 29));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnOk.setText("OK");
        btnOk.setMaximumSize(new java.awt.Dimension(85, 29));
        btnOk.setMinimumSize(new java.awt.Dimension(65, 29));
        btnOk.setPreferredSize(new java.awt.Dimension(85, 29));

        btnApply.setText("Apply");
        btnApply.setToolTipText("Save changes to server configuraton");
        btnApply.setMaximumSize(new java.awt.Dimension(85, 29));
        btnApply.setMinimumSize(new java.awt.Dimension(65, 29));
        btnApply.setPreferredSize(new java.awt.Dimension(85, 29));
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnToggleServer.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        btnToggleServer.setText("Activate");
        btnToggleServer.setMaximumSize(new java.awt.Dimension(138, 29));
        btnToggleServer.setMinimumSize(new java.awt.Dimension(108, 29));
        btnToggleServer.setPreferredSize(new java.awt.Dimension(138, 29));
        btnToggleServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleServerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel1.setText("BarcodeOverIP-Server Settings");

        txtHost.setText("0.0.0.0");
        txtHost.setToolTipText("Default = 0.0.0.0 (All interfaces)");

        txtPort.setText("41788");
        txtPort.setToolTipText("Default = 41788");

        jLabel2.setText("Listen to Host/IP:");

        jLabel3.setText("On Port:");

        jLabel4.setText("Paasoword (Optional):");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        jLabel5.setText("Log Output:");

        btnAbout.setText("About");
        btnAbout.setMaximumSize(new java.awt.Dimension(85, 29));
        btnAbout.setMinimumSize(new java.awt.Dimension(65, 29));
        btnAbout.setPreferredSize(new java.awt.Dimension(85, 29));

        chkAppendNL.setSelected(true);
        chkAppendNL.setText("Append a carrage return (enter key) to end of barcode");
        chkAppendNL.setToolTipText("Adds a simulated press of the enter key after the barcode is typed. Defualt is TRUE.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnToggleServer, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addComponent(chkAppendNL))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToggleServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAppendNL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        // This methods allows classes to register for MyEvents
    //public void addStatusChangedListener(ServerStatusEventListener listener) {
    //    listenerList.add(ServerStatusEventListener.class, listener);
    //}

    // This methods allows classes to unregister for MyEvents
    //public void removeStatusChangedListener(ServerStatusEventListener listener) {
    //    listenerList.remove(ServerStatusEventListener.class, listener);
    //}

    private void btnToggleServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleServerActionPerformed
        if(btnToggleServer.getText() == "Activate") {
            setServerState(true);
            btnToggleServer.setText("Deactivate");
            LogI(TAG, "Activated the server.");
        } else {
            setServerState(false);
            btnToggleServer.setText("Activate");
            LogI(TAG, "Deactivated the server.");
        }
    }//GEN-LAST:event_btnToggleServerActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm quit", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnApplyActionPerformed

/*
    void fireServerStatusChanged(ServerStatusEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==ServerStatusEventListener.class) {
                ((ServerStatusEventListener)listeners[i+1]).ServerStatusChanged(evt);
            }
        }
    }
*/
    //*********************************************
    // Check if any settings are different and then save them if the user wishes to

    private boolean checkForChanges() {
        boolean changed = false;
        if(txtHost.getText().trim() != OrigSets.get("host").toString().trim()) {
            changed = true;
        }
        if(txtPort.getText().trim() != OrigSets.get("port").toString().trim()) {
            changed = true;

        }
        if(txtPassword.getText().trim() != OrigSets.get("pass").toString().trim()) {
            changed = true;

        }
        if(chkAppendNL.isSelected() != Boolean.valueOf(OrigSets.get("newl").toString().trim())) {
            changed = true;
        }
        return changed;
    }

    private String validateValues() {
        if(txtHost.getText().trim().length() < 1 || txtHost.getText().trim() == "" || txtHost.getText().trim() == null) {
            return "Invalid or empty Host/IP Address!";
        }
        if(txtPort.getText().trim().length() < 1 || txtPort.getText().trim() == "" || txtPort.getText().trim() == null) {
            txtPort.setText("41788");
        } else {
            boolean validport = false;
            try {
                int i = Integer.parseInt(txtPort.getText());
                if(i < 65535 && i > 1023) {
                    validport = true;
                } else {
                    return "Given port is out of range. Must be: <65535 and >1023!";
                }
            } catch(NumberFormatException nme) {
                validport = false;
            }
            if(!validport) { return "Given port value is not a valid number!"; }
        }
        if(txtPassword.getText().trim().length() > 32) { return "Given password is too long! Must be <32 characters long!"; }
        return "OK"; //All is ok
    }

    private boolean saveChanges() {
        if(!checkForChanges()) { return true; }
        String validres = validateValues();
        if(validres != "OK") {
            int n = JOptionPane.showConfirmDialog(this, validres, "Invalid Value!", JOptionPane.OK_OPTION);
            return false;
        }
        SET.setAppendNL(chkAppendNL.isSelected());
        SET.setHost(txtHost.getText().trim());
        SET.setPort(Integer.valueOf(txtPort.getText().trim()));
        SET.setPass(txtPassword.getText().trim());
        LogI(TAG, "Changes successfully saved!");
        return true;
    }

    private boolean setServerState(boolean val) {  // TRUE = Active
        if(val) {
            CORE.ActivateServer();
        } else {
            CORE.DeactivateServer();
        }
        return val;
    }

    public void LogD(String tag, String info) { Log(tag, info, 0); }
    public void LogI(String tag, String info) { Log(tag, info, 1); }
    public void LogW(String tag, String info) { Log(tag, info, 2); }
    public void LogE(String tag, String info) { Log(tag, info, 3); }
    public void LogF(String tag, String info) { Log(tag, info, 4); }

    public void Log(String tag, String info, int level) { //Levels: 0 = debug, 1 = info, 2 = warning, 3 = error, 4 = fatal
        String a = "";
        if(level == 2) { a = "WARN: "; }
        if(level == 3) { a = "*ERR*: "; }
        if(level == 4) { a = "**FATAL**: "; }
        txtLog.setText(txtLog.getText() + "\n" + a + tag + " -- " + info);
    }

    /**
    * @param args the command line arguments
    */
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
     * */
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnToggleServer;
    private javax.swing.JCheckBox chkAppendNL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

}