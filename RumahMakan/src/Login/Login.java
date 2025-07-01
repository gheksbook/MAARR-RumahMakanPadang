

package Login;
import DatabaseConnection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Admin.DashboardAdmin;
import Karyawan.DashboardKaryawan;
import Admin.Pesanan.FormPesanan; 
import javax.swing.JFrame;


/**
 *
 * @author faisal
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("LOGIN");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aas.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(288, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(220, 220, 220)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1217, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
       String username = jTextField1.getText().trim();
        String inputPassword = new String(jPasswordField1.getPassword()).trim();

        if (username.isEmpty() || inputPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password harus diisi.");
            return;
        }

        if (inputPassword.length() < 6) {
            JOptionPane.showMessageDialog(this, "Password minimal 6 karakter.");
            return;
        }

        try {
            Connection conn = DatabaseConnection.connect();
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Koneksi database gagal!");
                return;
            }

            String sqlUsers = "SELECT password, akses FROM users WHERE username = ?";
            PreparedStatement stmtUsers = conn.prepareStatement(sqlUsers);
            stmtUsers.setString(1, username);
            ResultSet rsUsers = stmtUsers.executeQuery();

            if (rsUsers.next()) {
                String dbHashedPassword = rsUsers.getString("password");
                String inputHashed = HashUtil.hashPassword(inputPassword); // Pastikan HashUtil ada
                String role = rsUsers.getString("akses");

                if (dbHashedPassword.equals(inputHashed)) {
                    if ("Admin".equalsIgnoreCase(role)) {
                    UserSession.setLoggedInUser(username, ""); // 0 sebagai ID dummy admin
                    JOptionPane.showMessageDialog(this, "Login berhasil sebagai Admin");
                    new DashboardAdmin().setVisible(true);
                    this.dispose();
                    return; }
                    String idKaryawan = null;
                    String sqlKaryawan = "SELECT id_karyawan FROM karyawan WHERE username = ?"; // Mengambil id_karyawan
                    PreparedStatement stmtKaryawan = conn.prepareStatement(sqlKaryawan);
                    stmtKaryawan.setString(1, username);
                    ResultSet rsKaryawan = stmtKaryawan.executeQuery();

                    if (rsKaryawan.next()) {
                        idKaryawan = String.valueOf(rsKaryawan.getInt("id_karyawan")); // Ambil ID sebagai String
                    } else {
                      
                        JOptionPane.showMessageDialog(this, "Data karyawan tidak ditemukan untuk username ini.", "Login Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    UserSession.setLoggedInUser(username, idKaryawan); 

                    JOptionPane.showMessageDialog(this, "Login berhasil sebagai " + role);

                    if ("Admin".equalsIgnoreCase(role)) {
   
                    UserSession.setLoggedInUser(username, ""); 
                    JOptionPane.showMessageDialog(this, "Login berhasil sebagai Admin");
                    new DashboardAdmin().setVisible(true);
                    this.dispose();
                    return;
                } else if ("Pegawai".equalsIgnoreCase(role)) {
                        // Teruskan username ke DashboardKaryawan
                        new DashboardKaryawan(username).setVisible(true); // username diperlukan di DashboardKaryawan
                    } else {
                        JOptionPane.showMessageDialog(this, "Peran tidak dikenali: " + role);
                    }

                    this.dispose(); // tutup form login

                } else {
                    JOptionPane.showMessageDialog(this, "Password salah!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username tidak ditemukan!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
