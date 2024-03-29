/*
 *
 *  BarcodeOverIP-Server (Java) Version 1.0.x
 *  Copyright (C) 2013, Tyler H. Jones (me@tylerjones.me)
 *  http://boip.tylerjones.me
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Filename: MainFrame.java
 *  Package Name: com.tylerhjones.boip.server
 *  Created By: Tyler H. Jones on Feb 25, 2012, 10:40:16 AM
 *
 *  Description: This is the settings window GUI class. The GUI is configured
 *  and run from this class.
 *
 */

package com.tylerhjones.boip.server;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.jar.JarFile;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


// MainFrame class
public class MainFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 2473321176543596860L;

    private String TAG = "MainFrame";

    private static final int DEFAULT_PORT = 41788;
    private static final String DEFAULT_IP = "0.0.0.0";
    private static final String OK = "OK";
    public static JarFile jar;
    public static String basePath = "";

    private ServerCore Server = new ServerCore();
    private Settings SET = new Settings();
    private TrayIcon SysTrayIcon;
    private Toolkit toolkit;
    private Thread serverThread = new Thread(Server);
    private MulticastSocketThread discoverable;


    /** Creates new form MainFrame */
    public MainFrame() {
    	setResizable(false);
        initComponents();
    }
  
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnOk.addActionListener(new ActionListener() {
            @Override
        	public void actionPerformed(ActionEvent e) {
        	    btnHideActionPerformed(e);
        	}
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnAbout = new javax.swing.JButton();
        chkAppendNL = new javax.swing.JCheckBox();
        chkAutoSet = new javax.swing.JCheckBox();
        lblHost = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtHost = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        btnApplyIPPort = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel5.setText("http://boip.tylerjones.me/");

        setTitle("BarcodeOverIP-Server");
        setName("MainWindow");

        btnExit.setText("Exit");
        btnExit.setToolTipText("Exit the server application and close all connections.");
        btnExit.setMaximumSize(new java.awt.Dimension(94, 25));
        btnExit.setMinimumSize(new java.awt.Dimension(94, 25));
        btnExit.setPreferredSize(new java.awt.Dimension(94, 25));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnOk.setText("Hide");
        btnOk.setToolTipText("Hide this window and let the server run in the system tray.");
        btnOk.setMaximumSize(new java.awt.Dimension(94, 25));
        btnOk.setMinimumSize(new java.awt.Dimension(94, 25));
        btnOk.setPreferredSize(new java.awt.Dimension(94, 25));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel1.setText("<html>Enter the IP and Port given below into your BarcodeOverIP Client app to scan and send barcodes to this computer. It's that easy!</html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setFocusable(false);
        jLabel1.setMaximumSize(new java.awt.Dimension(402, 45));
        jLabel1.setMinimumSize(new java.awt.Dimension(402, 45));
        jLabel1.setPreferredSize(new java.awt.Dimension(402, 45));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setLabelFor(txtPassword);
        jLabel4.setText("Password:");
        jLabel4.setToolTipText("Set a password to limit access to the server. Default is blank (no password), set blank to remove password.");
        jLabel4.setFocusable(false);

        txtPassword.setToolTipText("Set a password to limit access to the server. Default is blank (no password), set blank to remove password.");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnAbout.setText("About");
        btnAbout.setToolTipText("Click for info about BarcodeOverIP-Server");
        btnAbout.setMaximumSize(new java.awt.Dimension(94, 25));
        btnAbout.setMinimumSize(new java.awt.Dimension(94, 25));
        btnAbout.setPreferredSize(new java.awt.Dimension(94, 25));
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        chkAppendNL.setSelected(true);
        chkAppendNL.setText("Add 'Enter' key after barcode.");
        chkAppendNL.setToolTipText("Adds a simulated press of the enter key after the barcode is received and typed by the system. Defualt is TRUE.");
        chkAppendNL.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkAppendNLStateChanged(evt);
            }
        });

        chkAutoSet.setSelected(true);
        chkAutoSet.setText("Detect and set server IP/port");
        chkAutoSet.setToolTipText("BoIP will look at you system's nerwork configuration and assign a port and an IP to listen for connections on.");
        chkAutoSet.setActionCommand("Automatically detect and set the IP and port");
        chkAutoSet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chkAutoSet.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAutoSetActionPerformed(evt);
            }
        });

        lblHost.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        lblHost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHost.setText("IP:");
        lblHost.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblPort.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        lblPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPort.setText("Port:");
        lblPort.setFocusable(false);
        lblPort.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtHost.setEditable(false);
        txtHost.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        txtHost.setText("0.0.0.0");
        txtHost.setToolTipText("Default = 0.0.0.0 (All interfaces)");

        txtPort.setEditable(false);
        txtPort.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        txtPort.setText("41788");
        txtPort.setToolTipText("Default = 41788");

        btnApplyIPPort.setText("Save IP/Port");
        btnApplyIPPort.setToolTipText("Apply manually set server IP/port. NOTE: This requires the app to be reload");
        btnApplyIPPort.setActionCommand("Apply (Needs App Reload)");
        btnApplyIPPort.setEnabled(false);
        btnApplyIPPort.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyIPPortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(lblHost, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkAutoSet)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(btnApplyIPPort))
                                    .addComponent(chkAppendNL))))
                        .addGap(18, 18, 18))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHost, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkAutoSet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkAppendNL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApplyIPPort)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }                  

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {  }                                           

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        Server.stopListener();
        dispose();
        System.exit(0);
    }                                                                           

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) { 
        JOptionPane.showMessageDialog(this, "<html><center><b><big>BarcodeOverIP-Server " + SET.VERSION + "</big></b><br><strong>Written by Tyler H. Jones</strong> -- <b>eMail:</b> tylerhuntjones@gmail.com<br><b>Blog:</b> https://tylerjones.me | <b>Twitter:</b> twitter.com/tylerhuntjones<br><hr><b>BarcodeOverIP Project Site:</b> http://boip.tylerjones.me</a><br><b>Application Usage Notes</b></center><br><div style=\"text-align: left;\"><b>a.</b> This application works best when run in OpenJDK-6 or OracleJava-6, v7 works but it may be buggy depending on your platform and exact JRE version. <br><b>b.</b> I have tested this application on Linux, MacOS X and Windows XP/7/8and can confirm that it works.<br>Windows users might have to disable Windows firewall for XP/7/8 to cooperate.<br><b>c.</b> I have not tested (or even thought about testing it) for use of the Internet, because... why?<br><b>d.</b> I have made a lot of effort in enabling BoIP to be able to scan any kind of barcode in existence.<br>If certain ones aren't working, please file a bug report (see below)<br><b>e.</b> Please report any bugs, typos, crash reports, and comments/tweaks/suggestions by filing a bug report<br>on the BoIP Google Code Project Issues: http://boip.tylerjones.me/bugs</div></html>", "About BarcodeOverIP-Server " + SET.VERSION, JOptionPane.INFORMATION_MESSAGE);
    }                                        

    private void chkAutoSetActionPerformed(java.awt.event.ActionEvent evt) {    
    	if(chkAutoSet.isSelected()) {
            String ip = this.FindSystemIP();
            if(ip.equals(DEFAULT_IP) || ip.startsWith("127") || ip.equals("")) {
                JOptionPane.showMessageDialog(this.getParent(), "The IP address of your system could not be auto-discovered. Check the network connection and try again or set the IP and port manually.", "Cannot Auto-discover Local IP Address", JOptionPane.WARNING_MESSAGE);
                chkAutoSet.setSelected(false);
                SET.setAutoSet(false);
                txtHost.setEditable(true);
                txtPort.setEditable(true);
                txtHost.setFocusable(true);
                txtHost.requestFocusInWindow();
                txtHost.selectAll();
                txtHost.requestFocusInWindow();
                btnApplyIPPort.setEnabled(true);
            } else {
                chkAutoSet.setSelected(true);
                SET.setAutoSet(true);
                txtHost.setEditable(false);
                txtPort.setEditable(false);
                btnApplyIPPort.setEnabled(false);
                SET.setHost(ip);
                SET.setPort(DEFAULT_PORT);
                txtHost.setText(ip);
                txtPort.setText(String.valueOf(DEFAULT_PORT));
                this.ApplyIPPort();
            }
    	} else {
            txtHost.setEditable(true);
            txtPort.setEditable(true);
            txtHost.setFocusable(true);
            txtHost.requestFocusInWindow();
            txtHost.selectAll();
            btnApplyIPPort.setEnabled(true);
        }
    }                                          

    private void btnApplyIPPortActionPerformed(java.awt.event.ActionEvent evt) {   
        this.ApplyIPPort();
    }                                              

    private void chkAppendNLStateChanged(javax.swing.event.ChangeEvent evt) {                                         
        SET.setAppendNL(chkAppendNL.isSelected());
    }         
    
    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {
	this.setVisible(false);
    }


    public void init() {
        serverThread.start();

        discoverable = new MulticastSocketThread(SET.getPort());
        discoverable.start();
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);

        txtPassword.setText(SET.getPass());
        chkAppendNL.setSelected(Boolean.valueOf(SET.getAppendNL()));
        chkAutoSet.setSelected(Boolean.valueOf(SET.getAutoSet()));

        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override 
            
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

             public void warn() {
                SET.setPass(txtPassword.getText());
            }
        });

        if(SET.getAutoSet()) {
            String ip = this.FindSystemIP();
            if(ip.equals(DEFAULT_IP) || ip.startsWith("127") || ip.equals("")) {
                JOptionPane.showMessageDialog(this.getParent(), "The IP address of your system could not be auto-discovered. Check the network connection and try again or set the IP and port manually.", "Cannot Auto-discover Local IP Address", JOptionPane.WARNING_MESSAGE);
                chkAutoSet.setSelected(false);
                SET.setAutoSet(false);
                txtHost.setEditable(true);
                txtPort.setEditable(true);
                txtHost.setFocusable(true);
                txtHost.requestFocusInWindow();
                txtHost.selectAll();
                btnApplyIPPort.setEnabled(true);
            } else {
                chkAutoSet.setSelected(true);
                SET.setAutoSet(true);
                txtHost.setEditable(false);
                txtPort.setEditable(false);
                btnApplyIPPort.setEnabled(false);
                SET.setHost(ip);
                SET.setPort(DEFAULT_PORT);
                txtHost.setText(ip);
                txtPort.setText(String.valueOf(DEFAULT_PORT));
            }
        } else {
            txtHost.setText(SET.getHost());
            txtPort.setText(String.valueOf(SET.getPort()));
            txtHost.setEditable(true);
            txtPort.setEditable(true);
            txtHost.setFocusable(true);
            txtHost.requestFocusInWindow();
            txtHost.selectAll();
            btnApplyIPPort.setEnabled(true);
        }
        Server.activate();
    }

    public void setTrayIcon(TrayIcon ico) {
        this.SysTrayIcon = ico;
        this.SysTrayIcon.setToolTip("BarcodeOverIP " + SET.VERSION + " - Active\n(Right or Left click to show settings window)\nHost:Port - " + SET.getHost() + ":" + String.valueOf(SET.getPort()));
    }
    
    
    
    // Auto-discover IP for Java 6
    /*
     
    public static InetAddress getLocalHost_nix() throws UnknownHostException {
            InetAddress localHost = InetAddress.getLocalHost();
            if(!localHost.isLoopbackAddress()) return localHost;
            InetAddress[] addrs = getAllLocalUsingNetworkInterface_nix();
            for(int i=0; i<addrs.length; i++) {
                    //Check for "." to ensure IPv4
                    if(!addrs[i].isLoopbackAddress() && addrs[i].getHostAddress().contains(".")) return addrs[i];
            }
            return localHost;
    }

    public static InetAddress[] getAllLocal_nix() throws UnknownHostException {
            InetAddress[] iAddresses = InetAddress.getAllByName("127.0.0.1");
            if(iAddresses.length != 1) return iAddresses;
            if(!iAddresses[0].isLoopbackAddress()) return iAddresses;
            return getAllLocalUsingNetworkInterface_nix();
    }

    private static InetAddress[] getAllLocalUsingNetworkInterface_nix() throws UnknownHostException {
            ArrayList addresses = new ArrayList();
            Enumeration e = null;
            try {
                    e = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException ex) {
                    throw new UnknownHostException("127.0.0.1");
            }
            while(e.hasMoreElements()) {
                    NetworkInterface ni = (NetworkInterface)e.nextElement();
                    for(Enumeration e2 = ni.getInetAddresses(); e2.hasMoreElements();) {
                            addresses.add(e2.nextElement());
                    }
            }
            InetAddress[] iAddresses = new InetAddress[addresses.size()];
            for(int i=0; i<iAddresses.length; i++) {
                    iAddresses[i] = (InetAddress)addresses.get(i);
            }
            return iAddresses;
    }
     */
    
    
    private String FindSystemIP() {
	String ip = DEFAULT_IP;
	try {
	    ip = getIPv4InetAddress().getHostAddress();
	} catch (SocketException se) {
	    System.out.println("SocketException when looking up local system IP address! -- MESSAGE: " + se.toString());
	} catch (UnknownHostException unk) {
	    System.out.println("UnknownHostException when looking up local system IP address! -- MESSAGE: " + unk.toString());
	}
	
	/*
	 * For Java 6
	 * 
	try {
            localAddr = InetAddress.getLocalHost();
            if (localAddr.isLoopbackAddress()) {
                localAddr = getLocalHost_nix();
            }
            ip = localAddr.getHostAddress();
        } catch (UnknownHostException ex) {
            Server.pln("Error finding local IP.");
            return NO;
        }
	 
	 */
	return ip;
    }

    private InetAddress getIPv4InetAddress() throws SocketException, UnknownHostException {
	    String os = System.getProperty("os.name").toLowerCase();
	    try {
	    if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {   
	        NetworkInterface ni = NetworkInterface.getByName("eth0");
	        Enumeration<InetAddress> ias = ni.getInetAddresses();
	        InetAddress iaddress;
	        do {
	            iaddress = ias.nextElement();
	        } while(!(iaddress instanceof Inet4Address));
	        return iaddress;
	    }
	    } catch (NullPointerException e) {
	    	return InetAddress.getLocalHost(); 
	    }
	    return InetAddress.getLocalHost();  
    }
 
    
    
    
    
    private String validateValues() {
        if(!chkAutoSet.isSelected()) {
            if(txtHost.getText().trim().length() < 1 || txtHost.getText().trim().equals("") || txtHost.getText().trim() == null) {
                return "Invalid or empty Host/IP Address!";
            }
            if(txtPort.getText().trim().length() < 1 || txtPort.getText().trim().equals("") || txtPort.getText().trim() == null) {
                txtPort.setText("41788");
            } else {
                boolean validport;
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
        }
        if(txtPassword.getText().trim().toUpperCase().equals("CHECK") || txtPassword.getText().trim().toUpperCase().equals("VERSION")) { 
            return "Given password conflicts with the syntax of the client-server comm protocol. Please pick another password!"; }
        if(txtPassword.getText().trim().length() < 4 && !txtPassword.getText().trim().equals("")) { return "Given password is too short! Must be > 4 characters long!"; }
        if(txtPassword.getText().trim().length() > 32) { return "Given password is too long! Must be < 32 characters long!"; }
        return OK; //All is ok
    }

    private boolean ApplyIPPort() {
        String validres = validateValues();
        if(!validres.equals(OK)) {
            JOptionPane.showMessageDialog(this, validres, "Invalid Value!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!chkAutoSet.isSelected()) {
            SET.setHost(txtHost.getText().trim());
            SET.setPort(Integer.valueOf(txtPort.getText().trim()));
        } else {
            txtPort.setText(String.valueOf(DEFAULT_PORT));
            txtHost.setText(this.FindSystemIP());
            SET.setHost(txtHost.getText().trim());
            SET.setPort(Integer.valueOf(txtPort.getText().trim()));
        }
        LogI(TAG, "Changes successfully saved!");

        txtHost.setText(SET.getHost());
        txtPort.setText(String.valueOf(SET.getPort()));

        int n = JOptionPane.showConfirmDialog(this, "The changes to the IP and/or Port settings will not take effect until BoIP-Server is restarted. Would you like to EXIT now?", "App Restart Required", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            Server.stopListener();
            dispose();
            System.exit(0);
        }
        
        return true;
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
        System.out.println(TAG + a + "" + info);
    }

    public Image getImage(String sImage) {
        Image imgReturn = this.toolkit.createImage(this.getClass().getClassLoader().getResource(sImage));
        return imgReturn;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnApplyIPPort;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOk;
    private javax.swing.JCheckBox chkAppendNL;
    private javax.swing.JCheckBox chkAutoSet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblPort;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    // End of variables declaration                   

}