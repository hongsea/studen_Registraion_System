
package Login;

import connection.connectsql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import MainFrom.Main;
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    Connection con = connectsql.getConnection();
    public LoginForm() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtlogin_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnlogin_signin = new javax.swing.JButton();
        btnlogin_cancel = new javax.swing.JButton();
        passwordlable = new javax.swing.JLabel();
        usernamelable = new javax.swing.JLabel();
        txtlogin_password = new javax.swing.JPasswordField();
        faillable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(204, 0, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        txtlogin_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtlogin_usernameKeyReleased(evt);
            }
        });
        jPanel2.add(txtlogin_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 240, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Username ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 70, 30));

        btnlogin_signin.setText("Sign In");
        btnlogin_signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogin_signinMouseClicked(evt);
            }
        });
        jPanel2.add(btnlogin_signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 90, 30));

        btnlogin_cancel.setText("Cancel");
        jPanel2.add(btnlogin_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 90, 30));
        jPanel2.add(passwordlable, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 240, 10));
        jPanel2.add(usernamelable, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 240, 10));

        txtlogin_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtlogin_passwordKeyReleased(evt);
            }
        });
        jPanel2.add(txtlogin_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 240, 30));
        jPanel2.add(faillable, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 190, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogin_signinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogin_signinMouseClicked
        try{
            String sql = "Select * from tbstaff where usernamelogin=? and password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txtlogin_username.getText().trim());
            String user = txtlogin_username.getText().trim().toString();
            //pst.setString(2, password.getText().trim());
            pst.setString(2,String.valueOf(txtlogin_password.getPassword()));
            
            if(txtlogin_username.getText().trim().isEmpty() && String.valueOf(txtlogin_password.getPassword()).trim().isEmpty()){
                usernamelable.setText("Username is required.");
                passwordlable.setText("Password is required.");
                txtlogin_username.requestFocus();
            }
            else if (txtlogin_username.getText().trim().isEmpty()){
                usernamelable.setText("Username is required.");
                txtlogin_username.requestFocus();
            }
            else if (String.valueOf(txtlogin_password.getPassword()).trim().isEmpty()){
                passwordlable.setText("Password is required.");
                txtlogin_password.requestFocus();
            }
            else{
                ResultSet rs = pst.executeQuery();
                if(rs.next()){      
                    
                    Main ma = new Main();
                    ma.setVisible(true);
                    this.setVisible(false);
                    
                    //sucessfullylable.setText("Sign in sucessfully.");
                    
                }
                else{
                    faillable.setText("Sign in failed.");
                    txtlogin_username.setText("");
                    txtlogin_password.setText("");
                    txtlogin_username.requestFocus();
                }
            }
//            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnlogin_signinMouseClicked

    private void txtlogin_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlogin_usernameKeyReleased
        usernamelable.setText("");
    }//GEN-LAST:event_txtlogin_usernameKeyReleased

    private void txtlogin_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlogin_passwordKeyReleased
        passwordlable.setText("");
    }//GEN-LAST:event_txtlogin_passwordKeyReleased

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin_cancel;
    private javax.swing.JButton btnlogin_signin;
    private javax.swing.JLabel faillable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel passwordlable;
    private javax.swing.JPasswordField txtlogin_password;
    private javax.swing.JTextField txtlogin_username;
    private javax.swing.JLabel usernamelable;
    // End of variables declaration//GEN-END:variables
}
