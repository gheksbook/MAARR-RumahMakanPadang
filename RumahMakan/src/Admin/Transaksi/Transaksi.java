
package Admin.Transaksi;
import Admin.DashboardAdmin;
import DatabaseConnection.*;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author faisal
 */
public class Transaksi extends javax.swing.JFrame {
private String usernamePegawaiLogin;
private int idPegawaiLogin;
private String roleLogin;


    public Transaksi() {
        initComponents();
        tampilkanDataPesanan();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
        
    }
    private void clearForm() {
    jTextField1.setText("");         
    jTextField11.setText("");        
    jTextArea3.setText("");         
    jComboBox1.setSelectedIndex(-1);  
    jTextField1.requestFocus();
    jTextArea2.setText("");
}
        public Transaksi(String username) {
        this();
        this.usernamePegawaiLogin = username;
        this.roleLogin = "Admin";
        this.idPegawaiLogin = 0;

        jTextField9.setText(this.usernamePegawaiLogin);
        jTextField9.setEditable(false);
    }

    public Transaksi(String username, String role) {
        this();
        this.usernamePegawaiLogin = username;
        this.roleLogin = role;

        jTextField9.setText(this.usernamePegawaiLogin);
        jTextField9.setEditable(false);

        if ("Pegawai".equalsIgnoreCase(role)) {
            ambilIdPegawaiDariUsername(username);
        } else if ("Admin".equalsIgnoreCase(role)) {
            this.idPegawaiLogin = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Peran pengguna tidak dikenal: " + role, "Error", JOptionPane.ERROR_MESSAGE);
            new Login.Login().setVisible(true);
            this.dispose();
        }
    }

    private void ambilIdPegawaiDariUsername(String username) {
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "SELECT id_karyawan FROM karyawan WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.idPegawaiLogin = rs.getInt("id_karyawan");
            } else {
                JOptionPane.showMessageDialog(this, "ID Karyawan tidak ditemukan untuk username: " + username, "Error", JOptionPane.ERROR_MESSAGE);
                new Login.Login().setVisible(true);
                this.dispose();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mengambil ID Karyawan: " + e.getMessage(), "Error Database", JOptionPane.ERROR_MESSAGE);
            new Login.Login().setVisible(true);
            this.dispose();
        }
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
        
        
        jTable2.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.toString());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jTextArea2 = new javax.swing.JTextArea();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(30000, 30000));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("PESANAN         :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("MENU PESANAN :");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("CEK PESANAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("KARYAWAN          :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("UANG BAYAR        :");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("SIMPAN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("METODE PEMBAYARAN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM TRANSAKSI ADMIN");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tunai", "Qris", "Debit" }));
        jComboBox1.setSelectedIndex(-1);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextArea2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                            .addComponent(jTextField11)
                            .addComponent(jTextField9)
                            .addComponent(jTextField1)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextArea3, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1092, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1056, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextArea3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new DashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try (Connection conn = DatabaseConnection.connect()) {
            String idPesananStr = jTextField1.getText().trim();
            int idPesanan = Integer.parseInt(idPesananStr);
            double uangMasuk = Double.parseDouble(jTextField11.getText());

            String sql = "SELECT * FROM pesanan1 WHERE id_pesanan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPesanan);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // ✅ CEK STATUS
                String status = rs.getString("status_pesanan");
                if ("Selesai".equalsIgnoreCase(status)) {
                    JOptionPane.showMessageDialog(this, "Pesanan ini sudah diselesaikan. Tidak bisa diproses kembali.");
                    return;
                }

                String namaPelanggan = rs.getString("nama_pelanggan");
                String nomerMeja = rs.getString("nomer_meja");
                String jenisNasi = rs.getString("jenis_nasi");
                int jumlahNasi = rs.getInt("jumlah_nasi");
                String jenisLauk = rs.getString("jenis_lauk");
                int jumlahLauk = rs.getInt("jumlah_lauk");
                String jenisMinuman = rs.getString("jenis_minuman");
                int jumlahMinuman = rs.getInt("jumlah_minuman");
                double total = rs.getDouble("jumlah_total");

                if (uangMasuk < total) {
                    JOptionPane.showMessageDialog(this, "Uang tidak cukup untuk membayar pesanan.");
                    return;
                }

                double kembalian = uangMasuk - total;

                String metode_pembayaran = (String) jComboBox1.getSelectedItem();
                if (metode_pembayaran == null || metode_pembayaran.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Silakan pilih metode pembayaran.");
                    return;
                }

                String kategori = "";
                boolean adaNasi = (jenisNasi != null && !jenisNasi.trim().isEmpty() && jumlahNasi > 0);
                boolean adaLauk = (jenisLauk != null && !jenisLauk.trim().isEmpty() && jumlahLauk > 0);
                boolean adaMinuman = (jenisMinuman != null && !jenisMinuman.trim().isEmpty() && jumlahMinuman > 0);

                if (adaNasi && adaLauk && adaMinuman) {
                    kategori = "Makanan dan Minuman";
                } else if ((adaNasi || adaLauk) && adaMinuman) {
                    kategori = "Makanan dan Minuman";
                } else if (adaNasi || adaLauk) {
                    kategori = "Makanan";
                } else if (adaMinuman) {
                    kategori = "Minuman";
                } else {
                    kategori = "Tidak diketahui";
                }

                jTextArea3.setText("");
                jTextArea3.append("======== STRUK PESANAN ========\n");
                jTextArea3.append("ID Pesanan    : " + idPesanan + "\n");
                jTextArea3.append("Username : " + this.usernamePegawaiLogin + "\n");
                jTextArea3.append("Nama Pelanggan: " + namaPelanggan + "\n");
                jTextArea3.append("Nomor Meja    : " + nomerMeja + "\n");
                jTextArea3.append("Jenis Nasi    : " + jenisNasi + "\n");
                jTextArea3.append("Jumlah Nasi   : " + jumlahNasi + "\n");
                jTextArea3.append("Jenis Lauk    : " + jenisLauk + "\n");
                jTextArea3.append("Jumlah Lauk   : " + jumlahLauk + "\n");
                jTextArea3.append("Jenis Minuman : " + jenisMinuman + "\n");
                jTextArea3.append("Jumlah Minuman: " + jumlahMinuman + "\n");
                jTextArea3.append("Total Pesanan : Rp " + total + "\n");
                jTextArea3.append("Uang Bayar    : Rp " + uangMasuk + "\n");
                jTextArea3.append("Kembalian     : Rp " + kembalian + "\n");
                jTextArea3.append("==============================\n");
                jTextArea3.append("Terima kasih atas pesanannya\n");

                String updateStok = "UPDATE stok_menu SET jumlah_stok = jumlah_stok - ? WHERE nama_menu = ?";
                if (jumlahNasi > 0 && jenisNasi != null && !jenisNasi.isEmpty()) {
                    PreparedStatement psNasi = conn.prepareStatement(updateStok);
                    psNasi.setInt(1, jumlahNasi);
                    psNasi.setString(2, jenisNasi);
                    psNasi.executeUpdate();
                }

                if (jumlahLauk > 0 && jenisLauk != null && !jenisLauk.isEmpty()) {
                    PreparedStatement psLauk = conn.prepareStatement(updateStok);
                    psLauk.setInt(1, jumlahLauk);
                    psLauk.setString(2, jenisLauk);
                    psLauk.executeUpdate();
                }

                if (jumlahMinuman > 0 && jenisMinuman != null && !jenisMinuman.isEmpty()) {
                    PreparedStatement psMinuman = conn.prepareStatement(updateStok);
                    psMinuman.setInt(1, jumlahMinuman);
                    psMinuman.setString(2, jenisMinuman);
                    psMinuman.executeUpdate();
                }

                String insertTransaksi = "INSERT INTO transaksi (id_pesanan, id_karyawan, username, nama_menu, nomer_meja, nama_pelanggan, "
                + "tanggal_transaksi, total_harga, jumlah_nasi, jumlah_lauk, jumlah_minuman, metode_pembayaran, kategori) "
                + "VALUES (?, ?, ?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?)";

                PreparedStatement psTransaksi = conn.prepareStatement(insertTransaksi);
                psTransaksi.setInt(1, idPesanan);
                psTransaksi.setInt(2, this.idPegawaiLogin);
                psTransaksi.setString(3, this.usernamePegawaiLogin);
                psTransaksi.setString(4, jenisNasi + ", " + jenisLauk + ", " + jenisMinuman);
                int nomorMejaInt = Integer.parseInt(nomerMeja.replaceAll("[^0-9]", ""));
                psTransaksi.setInt(5, nomorMejaInt);
                psTransaksi.setString(6, namaPelanggan);
                psTransaksi.setDouble(7, total);
                psTransaksi.setInt(8, jumlahNasi);
                psTransaksi.setInt(9, jumlahLauk);
                psTransaksi.setInt(10, jumlahMinuman);
                psTransaksi.setString(11, metode_pembayaran);
                psTransaksi.setString(12, kategori);
                psTransaksi.executeUpdate();

                String updateStatus = "UPDATE pesanan1 SET status_pesanan = 'Selesai' WHERE id_pesanan = ?";
                PreparedStatement psStatus = conn.prepareStatement(updateStatus);
                psStatus.setInt(1, idPesanan);
                int rowsUpdated = psStatus.executeUpdate();
                System.out.println("Rows updated in pesanan1: " + rowsUpdated);

                JOptionPane.showMessageDialog(this, "Pembayaran sukses dan transaksi berhasil disimpan.");
                tampilkanDataPesanan();
            } else {
                JOptionPane.showMessageDialog(this, "Data pesanan tidak ditemukan.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "SELECT * FROM pesanan1 WHERE id_pesanan = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, jTextField1.getText().trim());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String status = rs.getString("status_pesanan");
                if ("Selesai".equalsIgnoreCase(status)) {
                    JOptionPane.showMessageDialog(this, "Pesanan ini sudah diselesaikan dan tidak dapat dicek lagi.");
                    jTextArea2.setText("");
                    return;
                }

                StringBuilder sb = new StringBuilder();
                sb.append("Nama Pelanggan: ").append(rs.getString("nama_pelanggan")).append("\n");
                sb.append("Nomor Meja: ").append(rs.getString("nomer_meja")).append("\n");
                sb.append("Jenis Nasi: ").append(rs.getString("jenis_nasi")).append("\n");
                sb.append("Jumlah Nasi: ").append(rs.getInt("jumlah_nasi")).append("\n");
                sb.append("Jenis Lauk: ").append(rs.getString("jenis_lauk")).append("\n");
                sb.append("Jumlah Lauk: ").append(rs.getInt("jumlah_lauk")).append("\n");
                sb.append("Jenis Minuman: ").append(rs.getString("jenis_minuman")).append("\n");
                sb.append("Jumlah Minuman: ").append(rs.getInt("jumlah_minuman")).append("\n");
                sb.append("Jumlah Total: ").append(rs.getBigDecimal("jumlah_total")).append("\n");
                sb.append("Tanggal Pesanan: ").append(rs.getTimestamp("tanggal_pesanan")).append("\n");

                jTextArea2.setText(sb.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Pesanan tidak ditemukan.");
                jTextArea2.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
