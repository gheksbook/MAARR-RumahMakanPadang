/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Karyawan.Transaksi;

import DatabaseConnection.DatabaseConnection;
import Karyawan.DashboardKaryawan;
import Admin.DashboardAdmin;
import DatabaseConnection.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author faisal
 */
public class TambahTransaksiKaryawan extends javax.swing.JFrame {

    private String usernamePegawaiLogin;
    private int idPegawaiLogin;

    public TambahTransaksiKaryawan() {
        initComponents();
        tampilkanDataPesanan();
        jComboBox1.addItem("Tunai");
        jComboBox1.addItem("QRIS");
        jComboBox1.addItem("Kartu Debit");
        setLoggedInUsername();
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
    
    
    private void setLoggedInUsername() {
        String username = UserSession.getLoggedInUsername();
        if (username != null && !username.isEmpty()) {
            jTextField9.setText(username);
            jTextField9.setEditable(false);
        } else {
            
            jTextField9.setText("Username Not Found");
            jTextField9.setEditable(false);
        }
    }
    public TambahTransaksiKaryawan(String username) {
        this(); 
        this.usernamePegawaiLogin = username;
        jTextField9.setText(this.usernamePegawaiLogin);
        jTextField9.setEditable(false); 

        ambilIdPegawaiDariUsername(username);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField9 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("KARYAWAN          :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("UANG BAYAR        :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("PESANAN         :");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("SIMPAN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("MENU PESANAN :");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM TRANSAKSI KARYAWAN");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("CEK PESANAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TUNAI", "QRIS", "DEBIT" }));
        jComboBox1.setSelectedIndex(-1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("METODE PEMBAYARAN :");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("KEMBALI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jScrollPane1.setViewportView(jScrollPane4);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel2))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField9)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(98, 98, 98))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 258, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
               try (Connection conn = DatabaseConnection.connect()) {
    String idPesananStr = jTextField1.getText().trim();
    String uangMasukStr = jTextField11.getText().trim();

    if (idPesananStr.isEmpty() || uangMasukStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID Pesanan dan Uang Masuk tidak boleh kosong!");
        return;
    }

    int idPesanan = Integer.parseInt(idPesananStr);
    double uangMasuk = Double.parseDouble(uangMasukStr);

    String sql = "SELECT * FROM pesanan1 WHERE id_pesanan = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, idPesanan);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
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

        String kategori;
        boolean adaNasi = jenisNasi != null && !jenisNasi.isEmpty() && jumlahNasi > 0;
        boolean adaLauk = jenisLauk != null && !jenisLauk.isEmpty() && jumlahLauk > 0;
        boolean adaMinuman = jenisMinuman != null && !jenisMinuman.isEmpty() && jumlahMinuman > 0;

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

        // Cetak struk
        jTextArea3.setText("");
        jTextArea3.append("======== STRUK PESANAN ========\n");
        jTextArea3.append("ID Pesanan    : " + idPesanan + "\n");
        jTextArea3.append("Username Karyawan: " + UserSession.getLoggedInUsername() + "\n");
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

        // Kurangi stok
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

        // Simpan transaksi
        String insertTransaksi = "INSERT INTO transaksi (id_pesanan, id_karyawan, username, nama_menu, nomer_meja, nama_pelanggan, "
                + "tanggal_transaksi, total_harga, jumlah_nasi, jumlah_lauk, jumlah_minuman, metode_pembayaran, kategori) "
                + "VALUES (?, ?, ?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?)";

        PreparedStatement psTransaksi = conn.prepareStatement(insertTransaksi);
        psTransaksi.setInt(1, idPesanan);
        psTransaksi.setString(2, UserSession.getLoggedInUserId()); // pastikan ini bukan null
        psTransaksi.setString(3, UserSession.getLoggedInUsername());
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

        // Update status pesanan
        String updateStatus = "UPDATE pesanan1 SET status_pesanan = 'Selesai' WHERE id_pesanan = ?";
        PreparedStatement psStatus = conn.prepareStatement(updateStatus);
        psStatus.setInt(1, idPesanan);
        psStatus.executeUpdate();

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
                        jTextArea2.setText(""); // Kosongkan text area agar tidak tampilkan datanya
                        return;
                    }

                    // Jika belum selesai, tampilkan data
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       new DashboardKaryawan().setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clearForm();
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
            java.util.logging.Logger.getLogger(TambahTransaksiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahTransaksiKaryawan().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
