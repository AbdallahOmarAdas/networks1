/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author hp
 */
public class NewJFrame1 extends javax.swing.JFrame implements Runnable{
DefaultListModel model=new DefaultListModel();
String sentence;
String modifiedSentence; 
InetAddress serverIP;
InetAddress localIP;
BufferedReader inFromUser;
Socket clientSocket;
DataOutputStream outToServer;
BufferedReader inFromServer;
Thread x1;
ArrayList <String> selected=new ArrayList();

static DatagramSocket serverSocket ;
static byte[] receiveData = new byte[1024];
static byte[] sendData = new byte[1024];
static DatagramPacket receivePacket;
static String sentenceUDP ;
static InetAddress IPAddress ;
static int port;
static String capitalizedSentence;
static DatagramPacket sendPacket;



    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
        this.jList1.addListSelectionListener(new ListSelectionListener (){
    @Override
    public void valueChanged(ListSelectionEvent e) {
         if(!jList1.isSelectionEmpty()){
                            selected=new ArrayList();
                            String s[]=jList1.getSelectedValue().split(" ");
                            jTextFieldRemotePort.setText(s[2]);
                            jTextFieldRemoteIP.setText(s[1]);
                            for(int i=0;i<jList1.getSelectedValuesList().size();i++){
                                if(!selected.contains(jList1.getSelectedValuesList().get(i).trim()))
                                    selected.add(jList1.getSelectedValuesList().get(i).trim());
                           }
                            if(selected.size()>1){
                                jTextFieldRemotePort.setText("to selected");
                                jTextFieldRemoteIP.setText("to selected");
                            }
        }
    }
});
    }
    
//@Override
    Thread t2 = new Thread(new Runnable(){
    public void run(){
         try{
        
while(true)
{
  if(serverSocket==null) {
       }
  else {
            StyledDocument doc =jTextAreaChat.getStyledDocument();
            Style style =jTextAreaChat.addStyle("", null);
            StyleConstants.setBold(style, true); 
            StyleConstants.setFontSize(style, 12);
            StyleConstants.setForeground(style, Color.RED); //set colorRed 
            receivePacket =new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            sentenceUDP = new String(receivePacket.getData());
            doc.insertString(doc.getLength(), "Rem:"+sentenceUDP+"\n", style);
            jTextFieldStatus.setText("received from:"+receivePacket.getAddress()+" ,port:"+receivePacket.getPort());
    
    }
}
    }
catch(java.lang.NumberFormatException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter all fields in correct format","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(java.lang.IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter remote port in range","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(java.lang.ArrayIndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter IP address in correct format","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(java.lang.NullPointerException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please start lisning before start chat","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception e)
        {
//            e.printStackTrace();
        }
    
    }});
    
    
    public void run(){//tcp for update online users
    try {
        
        while(true){
            System.out.println("while");
            inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        modifiedSentence = inFromServer.readLine();
        String Out_put[] = modifiedSentence.split("&");
        System.out.println("before");
       model.removeAllElements();
       System.out.println("after");
        for(int i=0;i<Out_put.length;i++){
            String online[]=Out_put[i].split(",");
            if(!this.jTextFieldLocalPort.getText().equals(online[1])){
                 System.out.println(online[0]+","+online[1]+","+online[2]);
                  model.addElement(online[2]+" "+online[0]+" "+online[1]+" "+"\n");
            }
           
           
        }
         this.jList1.setModel(model);
        }
    } catch (IOException ex) {
        Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaToSend = new javax.swing.JTextArea();
        jTextFieldLocalIP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldLocalPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRemoteIP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldRemotePort = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldServerlPort = new javax.swing.JTextField();
        jTextFieldServerIP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextPane();
        jButtonSend = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel1.setText("Username:");

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButtonLogin.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(0, 204, 51));
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonLogout.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jButtonLogout.setForeground(new java.awt.Color(255, 51, 0));
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jTextAreaToSend.setColumns(20);
        jTextAreaToSend.setRows(5);
        jScrollPane2.setViewportView(jTextAreaToSend);
        jTextAreaToSend.getAccessibleContext().setAccessibleParent(null);

        jTextFieldLocalIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldLocalIP.setForeground(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Local IP:");

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Local Port:");

        jTextFieldLocalPort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldLocalPort.setForeground(new java.awt.Color(0, 0, 255));
        jTextFieldLocalPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldLocalPortFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Remote IP:");

        jTextFieldRemoteIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldRemoteIP.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Remote Port:");

        jTextFieldRemotePort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldRemotePort.setForeground(new java.awt.Color(255, 0, 0));

        jButton3.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 102));
        jButton3.setText("Send");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 204, 0));
        jLabel6.setText("TCP server IP:");

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 204, 0));
        jLabel7.setText("TCP Server Port:");

        jTextFieldServerlPort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldServerlPort.setForeground(new java.awt.Color(102, 204, 0));
        jTextFieldServerlPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldServerlPortFocusLost(evt);
            }
        });

        jTextFieldServerIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldServerIP.setForeground(new java.awt.Color(102, 204, 0));

        jLabel8.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Online Users");

        jScrollPane3.setViewportView(jList1);

        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel9.setText("Status:");

        jTextFieldStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldStatus.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel10.setText("Enter Text Here:");

        jScrollPane4.setViewportView(jTextAreaChat);

        jButtonSend.setFont(new java.awt.Font("Segoe Script", 1, 16)); // NOI18N
        jButtonSend.setForeground(new java.awt.Color(0, 0, 102));
        jButtonSend.setText("Test button");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel11.setText("Available Interfaces:");

        jComboBox1.setFont(new java.awt.Font("Segoe Script", 1, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wi-Fi", "Ethernet", "Loopback Pseudo-Interface 1:127.0.0.1" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldStatus))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldServerIP)
                                            .addComponent(jTextFieldServerlPort, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldLocalIP)
                                    .addComponent(jTextFieldLocalPort)
                                    .addComponent(jTextFieldRemoteIP)
                                    .addComponent(jTextFieldRemotePort)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldServerlPort, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldLocalIP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldLocalPort, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldRemoteIP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldRemotePort, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldStatus)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLocalPortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLocalPortFocusLost
        // TODO add your handling code here:
        try{
              InetAddress ips=InetAddress.getByName(this.jTextFieldLocalIP.getText());
            if(serverSocket==null){
                serverSocket = new DatagramSocket(Integer.parseInt(this.jTextFieldLocalPort.getText()), ips);
                serverSocket.setBroadcast(true);
                t2.start();
           }
           else{
               t2.stop();
                serverSocket.close();
                serverSocket = new DatagramSocket(Integer.parseInt(this.jTextFieldLocalPort.getText()), ips);
                t2.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldLocalPortFocusLost

    private void jTextFieldServerlPortFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldServerlPortFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldServerlPortFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           try{ 
            StyledDocument doc =jTextAreaChat.getStyledDocument(); //Chat is the name of text area
            Style style =jTextAreaChat.addStyle("", null);
            StyleConstants.setBold(style, true); 
            StyleConstants.setFontSize(style, 12);
            StyleConstants.setForeground(style, Color.BLUE); //set color Blue or Red 
            
             
             DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
               String time= dtf.format(now); 
                capitalizedSentence = this.jTextAreaToSend.getText()+"    -from:"+this.jTextFieldLocalIP.getText()+" port:"+this.jTextFieldLocalPort.getText()+"      "+time;
                doc.insertString(doc.getLength(), "me:"+capitalizedSentence+"\n", style);
                sendData = capitalizedSentence.getBytes();
                if(selected.size()>1){
                for(int i=0;i<selected.size();i++){
                    String list[]=selected.get(i).split(" ");
                           sendPacket =new DatagramPacket(sendData, sendData.length, InetAddress.getByName(list[1]),Integer.parseInt(list[2]));
                           serverSocket.send(sendPacket);
                }
                                
             }
            else{
                    IPAddress = InetAddress.getByName(this.jTextFieldRemoteIP.getText());
             port = Integer.parseInt(this.jTextFieldRemotePort.getText());
                sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress,port);
                serverSocket.send(sendPacket);
            }
                this.jTextFieldStatus.setText("sent to:"+this.jTextFieldRemoteIP.getText()+" ,port:"+this.jTextFieldRemotePort.getText());
        }
        catch(Exception e){
        e.printStackTrace();
    }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed



    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
         try{
            serverIP= InetAddress.getByName(this.jTextFieldServerIP.getText());
            localIP= InetAddress.getByName(this.jTextFieldLocalIP.getText());
            //clientSocket = new Socket(serverIP, Integer.parseInt(this.jTextFieldServerlPort.getText()));
            //clientSocket = new Socket
            clientSocket = new Socket(serverIP, Integer.parseInt(this.jTextFieldServerlPort.getText()), localIP, Integer.parseInt(this.jTextFieldLocalPort.getText()));
            outToServer =  new DataOutputStream(clientSocket.getOutputStream());
            inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence ="i,"+this.jTextFieldLocalIP.getText() + "," + this.jTextFieldLocalPort.getText() + "," + this.jTextFieldUsername.getText(); 
            outToServer.writeBytes(sentence + '\n');
            x1=new Thread(this);
            x1.start();

}
  catch(java.net.ConnectException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please be sure TCP server info, connection failed","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(java.net.BindException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please choose a different address,there is address already used","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(java.lang.NullPointerException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter User Name","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch( java.lang.ArrayIndexOutOfBoundsException ee)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter Local Local address & TCP server address in correct format","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(java.lang.NumberFormatException e )
        {
            
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter Local Local address & TCP server address in correct format","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(java.lang.IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter local port in range","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception e)
        {

        }
        
        
        
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
          try{x1.stop();
                clientSocket = new Socket(serverIP, Integer.parseInt(this.jTextFieldServerlPort.getText()));
                outToServer =  new DataOutputStream(clientSocket.getOutputStream());
                sentence ="o,"+this.jTextFieldLocalIP.getText() + "," + this.jTextFieldLocalPort.getText() + "," + this.jTextFieldUsername.getText(); 
                outToServer.writeBytes(sentence + '\n');
                
                model.removeAllElements();
                this.jTextFieldLocalPort.setText("");
                this.jTextFieldLocalIP.setText("");
                this.jTextFieldUsername.setText("");
                }
                  catch(Exception e){
                            e.printStackTrace();
                        }
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try{
            StyledDocument doc =jTextAreaChat.getStyledDocument(); //Chat is the name of text area
            Style style =jTextAreaChat.addStyle("", null);
            StyleConstants.setBold(style, true); 
            StyleConstants.setFontSize(style, 12);
            StyleConstants.setForeground(style, Color.BLUE); //set color Blue or Red 
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String time= dtf.format(now);
            capitalizedSentence ="hello    -from port:"+this.jTextFieldLocalPort.getText()+"      "+time;

            sendData = capitalizedSentence.getBytes();
            if(selected.size()>1){
                for(int i=0;i<selected.size();i++){
                    String list[]=selected.get(i).split(" ");
                           sendPacket =new DatagramPacket(sendData, sendData.length, InetAddress.getByName(list[1]),Integer.parseInt(list[2]));
                           serverSocket.send(sendPacket);
                }
                                
             }
            else{
                IPAddress = InetAddress.getByName(this.jTextFieldRemoteIP.getText());
                port = Integer.parseInt(this.jTextFieldRemotePort.getText());
                sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress,port);
                serverSocket.send(sendPacket);
            }
            
            doc.insertString(doc.getLength(), "me:"+capitalizedSentence+"\n", style);
            this.jTextFieldStatus.setText("sent to:"+this.jTextFieldRemoteIP.getText()+" ,port:"+this.jTextFieldRemotePort.getText());
        }
        catch(java.lang.NumberFormatException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter local port in correct format","WARNING", JOptionPane.WARNING_MESSAGE);
            
        }
        catch(java.net.BindException e)
        {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Address already in uses, please choose diffrent port","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception e)
        {
//            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(this.jComboBox1.getSelectedIndex()==0){
            try {
                InetAddress ip=InetAddress.getLocalHost();

                String st[]=ip.toString().split("/");
                this.jTextFieldLocalIP.setText(st[1]);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        else if(this.jComboBox1.getSelectedIndex()==1){
            try {
                InetAddress ip=InetAddress.getLocalHost();
                String st[]=ip.toString().split("/");
                this.jTextFieldLocalIP.setText(st[1]);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            try {
                InetAddress ip=InetAddress.getLoopbackAddress();
                String st[]=ip.toString().split("/");
                this.jTextFieldLocalIP.setText(st[1]);
            } catch (Exception ex) {
                Logger.getLogger(part1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextAreaChat;
    private javax.swing.JTextArea jTextAreaToSend;
    private javax.swing.JTextField jTextFieldLocalIP;
    private javax.swing.JTextField jTextFieldLocalPort;
    private javax.swing.JTextField jTextFieldRemoteIP;
    private javax.swing.JTextField jTextFieldRemotePort;
    private javax.swing.JTextField jTextFieldServerIP;
    private javax.swing.JTextField jTextFieldServerlPort;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
