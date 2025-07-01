

package Karyawan;
import DatabaseConnection.*;
import DatabaseConnection.DatabaseConnection;
import Karyawan.Diagram.DiagramTransaksiKaryawan;
import Karyawan.Pegawai.LihatDataKaryawan;
import Karyawan.Pesanan.FormPesanan;
import Karyawan.Pesanan.LihatPesanan;
import Karyawan.StokMenu.LihatStokKaryawan;
import Karyawan.Transaksi.LihatTransaksiKaryawan;
import Karyawan.Transaksi.TambahTransaksiKaryawan;
import Login.Login;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DashboardKaryawan extends javax.swing.JFrame {
    private String loggedInUsername;
    private int loggedInKaryawanId;

    // Simpan posisi awal JLabel untuk animasi slide out
    private int jLabel7OriginalX;
 

    public DashboardKaryawan() {
        initComponents();
            jPanel1.setVisible(false);
            this.loggedInUsername = null;
            this.loggedInKaryawanId = -1;

            jLabel7OriginalX = jLabel7.getX(); // simpan posisi awal label background

            tampilkanDataKaryawan();
            tampilkanBackground("src/images/asaq.png"); // Gambar background

            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setLocationRelativeTo(null);

            // Supaya gambar resize otomatis saat window di-resize
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    tampilkanBackground("src/images/asaq.png");
                }
            });
    }
    
     private void tampilkanBackground(String path) {
    ImageIcon icon = new ImageIcon(path);
    Image img = icon.getImage();
    Image scaled = img.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
    jLabel7.setIcon(new ImageIcon(scaled));
}
    
    private void tampilkanDataKaryawan() {
    String username =  UserSession.getLoggedInUsername(); 
    
    if (username != null && !username.isEmpty()) {
        try {
            Connection conn = DatabaseConnection.connect(); 
            String sql = "SELECT nama_karyawan, jabatan, nik FROM karyawan WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                jTextField1.setText(rs.getString("nama_karyawan"));
                jTextField2.setText(rs.getString("jabatan"));
                jTextField3.setText(rs.getString("nik"));

                // Optional: Biar tidak bisa diedit
                jTextField1.setEditable(false);
                jTextField2.setEditable(false);
                jTextField3.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk username: " + username);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "User belum login.");
    }
}

        public DashboardKaryawan(String usernameLogin) {
            initComponents(); 
            this.loggedInUsername = usernameLogin;
    jPanel1.setVisible(false);

    // Gantikan jLabel1 dan jLabel2 dengan jLabel7
    jLabel7OriginalX = jLabel7.getX(); // simpan posisi awal background

    loadKaryawanData(); 
    tampilkanBackground("src/images/background_karyawan.png"); // background full screen

    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setLocationRelativeTo(null);

    // Gambar background otomatis menyesuaikan saat window resize
    this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            tampilkanBackground("src/images/background_karyawan.png");
        }
    });

    // Pastikan background tetap di bawah
    this.setComponentZOrder(jLabel7, this.getComponentCount() - 1);


        }

    private void loadKaryawanData() {
        if (loggedInUsername != null) {
            try (Connection conn = DatabaseConnection.connect()) {
                if (conn == null) {
                    JOptionPane.showMessageDialog(this, "Koneksi database gagal!");
                    return;
                }

                String sql = "SELECT id_karyawan, nama_karyawan, nik, jabatan FROM karyawan WHERE username = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, loggedInUsername);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int idKaryawan = rs.getInt("id_karyawan");
                    String namaKaryawan = rs.getString("nama_karyawan");
                    String nik = rs.getString("nik");
                    String jabatan = rs.getString("jabatan");

                    this.loggedInKaryawanId = idKaryawan;
                    jTextField1.setText(namaKaryawan); 
                    jTextField2.setText(jabatan);      
                    jTextField3.setText(nik);         
                    jTextField1.setEditable(false);
                    jTextField2.setEditable(false);
                    jTextField3.setEditable(false);

                    System.out.println("ID Karyawan: " + idKaryawan);
                    System.out.println("Nama Karyawan: " + namaKaryawan);
                    System.out.println("NIK: " + nik);
                    System.out.println("Jabatan: " + jabatan);

                } else {
                    JOptionPane.showMessageDialog(this, "Data karyawan tidak ditemukan untuk username: " + loggedInUsername);
                    System.out.println("Data karyawan tidak ditemukan untuk username: " + loggedInUsername);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error database saat memuat data karyawan: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan tak terduga: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("loggedInUsername kosong. Tidak dapat memuat data karyawan.");
        }
    }

    private void slideInPanel(JPanel panel, JLabel labelBg) {
    int frameWidth = getWidth();
    int panelTargetX = frameWidth - panel.getWidth(); 
    int panelStartX = frameWidth; 

    final int initialLabelX = labelBg.getX();
    int targetLabelX = initialLabelX - panel.getWidth(); 

    panel.setVisible(true);
    panel.setBounds(panelStartX, panel.getY(), panel.getWidth(), panel.getHeight());

    Timer timer = new Timer(5, null);
    timer.addActionListener(new ActionListener() {
        int panelX = panelStartX;
        int labelX = initialLabelX;

        public void actionPerformed(ActionEvent e) {
            boolean moved = false;

            if (panelX > panelTargetX) {
                panelX -= 5;
                panel.setLocation(Math.max(panelX, panelTargetX), panel.getY());
                moved = true;
            }

            if (labelX > targetLabelX) {
                labelX -= 5;
                labelBg.setLocation(Math.max(labelX, targetLabelX), labelBg.getY());
                moved = true;
            }

            if (!moved) {
                timer.stop();
            }
        }
    });
    timer.start();
}
private void slideOutPanel(JPanel panel, JLabel labelBg, int labelStartX) {
    int panelStartX = panel.getX(); 
    int panelEndX = getWidth();      

    Timer timer = new Timer(5, null);
    timer.addActionListener(new ActionListener() {
        int panelX = panelStartX;
        int labelX = labelBg.getX();

        public void actionPerformed(ActionEvent e) {
            boolean moved = false;

            if (panelX < panelEndX) {
                panelX += 5;
                panel.setLocation(Math.min(panelX, panelEndX), panel.getY());
                moved = true;
            }

            if (labelX < labelStartX) {
                labelX += 5;
                labelBg.setLocation(Math.min(labelX, labelStartX), labelBg.getY());
                moved = true;
            }

            if (!moved) {
                panel.setVisible(false); 
                timer.stop();
            }
        }
    });
    timer.start();
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Lihat Data Diri");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Selengkapnya");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Batalkan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nama Anda");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ROLE ANDA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("NIK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(120, 120, 120))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(153, 153, 153))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(1010, 0, 394, 750);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1360, 820);

        jMenu1.setText("LOGOUT");

        jMenuItem6.setText("Yes");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("No");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Karyawan");

        jMenuItem2.setText("Lihat");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Stok Menu");

        jMenuItem5.setText("Lihat");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem8.setText("Cari");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Pesanan");

        jMenuItem3.setText("Tambah");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuItem9.setText("Lihat");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem9);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Transaksi");

        jMenuItem4.setText("Tambah");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem10.setText("Lihat");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Diagram");

        jMenuItem1.setText("Lihat");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      new DiagramTransaksiKaryawan().setVisible(true);
      dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       slideInPanel(jPanel1, jLabel7);
    tampilkanDataKaryawan();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        slideOutPanel(jPanel1, jLabel7, jLabel7OriginalX);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new FormPesanan().setVisible(true);
      dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new LihatDataKaryawan().setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      new TambahTransaksiKaryawan(UserSession.getLoggedInUsername()).setVisible(true);
      dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      new LihatStokKaryawan().setVisible(true);
      dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      new Login().setVisible(true);
      dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      new DashboardKaryawan().setVisible(true);
      dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       new LihatStokKaryawan().setVisible(true);
      dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        new LihatPesanan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        new LihatTransaksiKaryawan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
