/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks1;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author hp
 */
public class TCPserver extends javax.swing.JFrame implements Runnable{
     String clientSentence;
    String capitalizedSentence;
    ServerSocket welcomeSocket;    
    Socket connectionSocket;
    BufferedReader inFromClient;
    DataOutputStream outToClient ;
    ArrayList <Socket> arrSocket=new ArrayList();
    ArrayList <String> arr=new ArrayList <String>();
    String serverIP="127.0.0.1";
    public void run(){
        try{
            String client;
            DefaultListModel model=new DefaultListModel();
                          
                while(true) {
                            
                            arrSocket.add(connectionSocket = welcomeSocket.accept());
                           inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                           outToClient =new DataOutputStream(connectionSocket.getOutputStream());
                           clientSentence = inFromClient.readLine();  
                           client=clientSentence.substring(2);
                           String Out_put[] = client.split(",");
                           if(clientSentence.startsWith("i,")){
                               if(arr.contains(client)){
//                                 String toClients="";
//                                for(int i=0;i<arr.size();i++){
//                                      System.out.println("outToClient");
//                                       toClients=toClients+arr.get(i)+"&";
//                                  }
                                                                 }
                                else{
                                        arr.add(client);
                                        this.jTextAreaInfo.append("login by:"+client+"\n");
                                        model.addElement(Out_put[0]+", "+Out_put[1]+", "+Out_put[2]+"\n");
                                        this.jListOnline.setModel(model);
                                        String toClients="";
                                        for(int i=0;i<arr.size();i++){
                                              System.out.println("outToClient");
                                               toClients=toClients+arr.get(i)+"&";
                                                                       }
                                         for(int i=0;i<arrSocket.size();i++){
                                             System.out.println(arrSocket.get(i).getInetAddress().toString().replace("/","")+":"+arrSocket.get(i).getPort());
                                                                               // System.out.println(arrSocket.get(i).toString());
                                                                                System.out.println("*");
                                                                                
                                                                                
                                                                                     outToClient =new DataOutputStream(arrSocket.get(i).getOutputStream());
                                                                                     outToClient.writeBytes(toClients+"\n");
                                                                                
                                                                               
                                                                            }
                                    }
                                                               }
                           else if(clientSentence.startsWith("o,")){
                                arr.remove(client);
                                this.jTextAreaInfo.append("logOut by:"+client+"\n");
                                model.removeElement(Out_put[0]+", "+Out_put[1]+", "+Out_put[2]+"\n");  
                                String toClients="";
                                //arrSocket.remove(connectionSocket);
                                for(int i=0;i<arr.size();i++){
                                     // System.out.println("outToClient");
                                       toClients=toClients+arr.get(i)+"&";
                                  }
                                for(int i=0;i<arrSocket.size();i++){
                                                                    System.out.println(arrSocket.get(i).getInetAddress().toString().replace("/","")+":"+arrSocket.get(i).getPort());
                                                                    System.out.println("*");
                                                                    outToClient =new DataOutputStream(arrSocket.get(i).getOutputStream());
                                                                   
                                                                                     outToClient =new DataOutputStream(arrSocket.get(i).getOutputStream());
                                                                                     outToClient.writeBytes(toClients+"\n");
                                                                                
                                                                            }
                                                                  }
                            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Creates new form TCPserver
     */
    public TCPserver() {
        initComponents();
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
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInfo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListOnline = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jTextFieldPort = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel7.setText("Available Interfaces:");

        jComboBox1.setFont(new java.awt.Font("Segoe Script", 1, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wi-Fi", "Ethernet", "Loopback Pseudo-Interface 1:127.0.0.1" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setRows(5);
        jScrollPane1.setViewportView(jTextAreaInfo);

        jListOnline.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jListOnline);

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel8.setText("Port:");

        jButtonStart.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jButtonStart.setText("Start Listening");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jTextFieldPort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel5.setText("Status:");

        jTextFieldStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldStatus.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(131, 131, 131))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldStatus)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(this.jComboBox1.getSelectedIndex()==0){
            try {
                InetAddress ip=InetAddress.getLocalHost();
                String st[]=ip.toString().split("/");
                serverIP=st[1];
            } catch (UnknownHostException ex) {
                
            }

        }
        else if(this.jComboBox1.getSelectedIndex()==1){
            try {
                InetAddress ip=InetAddress.getLocalHost();
                String st[]=ip.toString().split("/");
                serverIP=st[1];
            } catch (UnknownHostException ex) {
             
            }
        }
        else{
            try {
                InetAddress ip=InetAddress.getLoopbackAddress();
                String st[]=ip.toString().split("/");
                serverIP=st[1];
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        // TODO add your handling code here:
        try{
            InetAddress ipser=InetAddress.getByName(serverIP);
            Thread tr=new Thread(this);
                  if(welcomeSocket==null){
                    
                   welcomeSocket = new ServerSocket(Integer.parseInt(this.jTextFieldPort.getText()), 20,ipser );
                   
                   tr.start();
                   this.jTextFieldStatus.setText("Start Listening at port:"+this.jTextFieldPort.getText()+", Address: "+serverIP);
                   
                    }     
                  else{
                      tr.stop();
                      for(int i=0;i<arrSocket.size();i++){
                          outToClient =new DataOutputStream(arrSocket.get(i).getOutputStream());
                          outToClient.writeBytes(""+"\n");
                          arrSocket.remove(i);
                          
                      }
                      
                      welcomeSocket = new ServerSocket(Integer.parseInt(this.jTextFieldPort.getText()), 20,ipser );
                        this.jTextFieldStatus.setText("Start Listening at port:"+this.jTextFieldPort.getText()+", Address: "+serverIP);
                        this.jTextAreaInfo.setText("");
                        this.jListOnline.setModel(new DefaultListModel());
                      tr=new Thread(this);
                      tr.start();
                  }
        }
        catch(java.lang.NumberFormatException e)
        {
           
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "please enter port number for server in correct format","WARNING", JOptionPane.WARNING_MESSAGE);
            
        }
        catch(java.lang.NullPointerException e)
        {
            
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "please enter port number for server in correct format","WARNING", JOptionPane.WARNING_MESSAGE);
            
        }
        catch(java.net.BindException e)
        {
            
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Address already in uses, please choose diffrent port","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonStartActionPerformed

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
            java.util.logging.Logger.getLogger(TCPserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TCPserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TCPserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TCPserver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TCPserver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStart;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListOnline;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaInfo;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
