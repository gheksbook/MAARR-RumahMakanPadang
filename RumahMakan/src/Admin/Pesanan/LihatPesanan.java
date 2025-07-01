

package Admin.Pesanan;

import Admin.*;
import Admin.Karyawan.formTambahKaryawan;
import DatabaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author faisal
 */
public class LihatPesanan extends javax.swing.JFrame {

    /**
     * Creates new form LihatPesanan
     */
    public LihatPesanan() {
        initComponents();
        tampilkanDataPesanan();
         this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
    }

   private void tampilkanDataPesanan() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID PESANAN");
    model.addColumn("Id Karyawan");
    model.addColumn("Nama Pelanggan");
    model.addColumn("Nomor Meja");
    model.addColumn("Jenis Nasi");
    model.addColumn("Jumlah Nasi");
    model.addColumn("Jenis Lauk");
    model.addColumn("Jumlah Lauk");
    model.addColumn("Jenis Minuman");
    model.addColumn("Jumlah Minuman");
    model.addColumn("Total");
    model.addColumn("Tanggal Pesanan");
    model.addColumn("Statu Pesanan");

    try (Connection conn = DatabaseConnection.connect()) {
        String sql = "SELECT * FROM pesanan1";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[] {
                rs.getInt("id_pesanan"),
                rs.getString("id_karyawan"),
                rs.getString("nama_pelanggan"),
                rs.getString("nomer_meja"),
                rs.getString("jenis_nasi"),
                rs.getInt("jumlah_nasi"),
                rs.getString("jenis_lauk"),
                rs.getInt("jumlah_lauk"),
                rs.getString("jenis_minuman"),
                rs.getString("jumlah_minuman"),
                rs.getDouble("jumlah_total"),
                rs.getTimestamp("tanggal_pesanan"),
                rs.getString("status_pesanan")
            });
        }
        
        
        jTable1.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.toString());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM SEARCH PESANAN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("SEARCH");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CARI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("REFRESH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("KEMBALI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(363, 363, 363))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String keyword = jTextField1.getText().trim(); 
    if (keyword.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Masukkan keyword yang ingin dicari.");
        return;
    }

    DefaultTableModel model = new DefaultTableModel(new Object[]{
        "ID PESANAN", "Id Karyawan", "Nama Pelanggan", "Nomor Meja", "Jenis Nasi", 
        "Jumlah Nasi", "Jenis Lauk", "Jumlah Lauk", "Jenis Minuman", "Jumlah Minuman", 
        "Total", "Tanggal Pesanan", "Status Pesanan"
    }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement stmt = conn.prepareStatement(
            "SELECT * FROM pesanan1 WHERE " +
            "CAST(id_pesanan AS CHAR) LIKE ? OR " +
            "CAST(id_karyawan AS CHAR) LIKE ? OR " +
            "nama_pelanggan LIKE ? OR " +
            "nomer_meja LIKE ? OR " +
            "jenis_nasi LIKE ? OR " +
            "CAST(jumlah_nasi AS CHAR) LIKE ? OR " +
            "jenis_lauk LIKE ? OR " +
            "CAST(jumlah_lauk AS CHAR) LIKE ? OR " +
            "jenis_minuman LIKE ? OR " +
            "CAST(jumlah_minuman AS CHAR) LIKE ? OR " +
            "CAST(jumlah_total AS CHAR) LIKE ? OR " +
            "CAST(tanggal_pesanan AS CHAR) LIKE ? OR " +
            "status_pesanan LIKE ?"
        )) {

        String likeKeyword = "%" + keyword + "%";
        for (int i = 1; i <= 13; i++) {
            stmt.setString(i, likeKeyword);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_pesanan"),
                rs.getString("id_karyawan"),
                rs.getString("nama_pelanggan"),
                rs.getString("nomer_meja"),
                rs.getString("jenis_nasi"),
                rs.getInt("jumlah_nasi"),
                rs.getString("jenis_lauk"),
                rs.getInt("jumlah_lauk"),
                rs.getString("jenis_minuman"),
                rs.getInt("jumlah_minuman"),
                rs.getDouble("jumlah_total"),
                rs.getTimestamp("tanggal_pesanan"),
                rs.getString("status_pesanan")
            });
        }

        jTable1.setModel(model);

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Data pesanan tidak ditemukan.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mencari: " + e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tampilkanDataPesanan();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         new DashboardAdmin().setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(LihatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LihatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LihatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LihatPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LihatPesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
