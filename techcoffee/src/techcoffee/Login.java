/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techcoffee;

/**
 *
 * @author kobao
 */

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {

    private String usernamelogin1;
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        //        if (rmbpasswd.isSelected()) {
        //            username.setText(username.getText().toString());
        //            passwd.setText(passwd.getText().toString());
        //        }

        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        passwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-user-login .png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-lock -login.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        username.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 180, 30));

        passwd.setBackground(new java.awt.Color(255, 204, 102));
        passwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwdKeyPressed(evt);
            }
        });
        jPanel1.add(passwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 180, 30));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/log-in.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 50, -1));

        jLabel4.setBackground(new java.awt.Color(255, 153, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText(" No account? Create new account");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 350, 40));

        jComboBox1.setBackground(new java.awt.Color(255, 102, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "USER", "ADMIN" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, 30));

        jLabel5.setBackground(new java.awt.Color(255, 153, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 51));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/background_login1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String selected = jComboBox1.getSelectedItem().toString();
        if (selected.equals("ADMIN")) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qqq?useSSL=false", "root", "000001");
                PreparedStatement pSm = conn.prepareCall("SELECT * from users where username=? and passwd=? and check_admin=?");
                pSm.setString(1, username.getText().toString());
                pSm.setString(2, passwd.getText().toString());
                pSm.setString(3, "1");
                ResultSet rs = pSm.executeQuery();
              
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login is success");
                    HomeAdmin ha = new HomeAdmin();
                    ha.usernamelogin.setText(this.username.getText().toString());
                    ha.setVisible(true);
                    ha.pack();
                    ha.setLocationRelativeTo(null);
                    ha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login is not success");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Server error");
            }

        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qliquancafe?useSSL=false", "root", "000001");
                PreparedStatement pSm = conn.prepareCall("SELECT * from login where _username=? and _passwd=? and check_admin=?");
                pSm.setString(1, username.getText());
                pSm.setString(2, passwd.getText());
                pSm.setString(3, "0");
                ResultSet rs = pSm.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login is success");
                    HomeUser hu = new HomeUser();
                    hu.setVisible(true);
                    hu.pack();
                    hu.setLocationRelativeTo(null);
                    hu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login is not success");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Server error");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void passwdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwdKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String selected = jComboBox1.getSelectedItem().toString();
            if (selected.equals("ADMIN")) {
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qliquancafe?useSSL=false", "root", "000001");
                    PreparedStatement pSm = conn.prepareCall("SELECT * from login where _username=? and _passwd=? and check_admin=?");
                    pSm.setString(1, username.getText().toString());
                    pSm.setString(2, passwd.getText().toString());
                    pSm.setString(3, "1");
                    ResultSet rs = pSm.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login is success");
                        HomeAdmin ha = new HomeAdmin();
                        ha.setVisible(true);
                        ha.pack();
                        ha.setLocationRelativeTo(null);
                        ha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login is not success");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Server error");
                }

            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/qliquancafe?useSSL=false", "root", "000001");
                    PreparedStatement pSm = conn.prepareCall("SELECT * from login where _username=? and _passwd=? and check_admin=?");
                    pSm.setString(1, username.getText());
                    pSm.setString(2, passwd.getText());
                    pSm.setString(3, "0");
                    ResultSet rs = pSm.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login is success");
                        HomeUser hu = new HomeUser();
                        hu.setVisible(true);
                        hu.pack();
                        hu.setLocationRelativeTo(null);
                        hu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login is not success");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Server error");
                }
            }
        }
    }//GEN-LAST:event_passwdKeyPressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        HomeUser hu = new HomeUser();
        hu.setVisible(true);
        hu.pack();
        hu.setLocationRelativeTo(null);
        hu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwd;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
