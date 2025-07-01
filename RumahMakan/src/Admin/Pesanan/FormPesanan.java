/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin.Pesanan;
import Admin.DashboardAdmin;
import Admin.Transaksi.Transaksi;
import DatabaseConnection.*;
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
public class FormPesanan extends javax.swing.JFrame {
    public String meja="";
    private int idPegawaiLogin;
    private String roleLogin;
    private String usernamePegawaiLogin;
    
    public FormPesanan() {
        initComponents();
        tampilkanDataStok();
    setLoggedInUsername(); 
    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
    }
       
     public FormPesanan(String username) {
        this(); 
        this.usernamePegawaiLogin = username;
        this.roleLogin = "Admin";
        this.idPegawaiLogin = 0;

        jTextField2.setText(this.usernamePegawaiLogin);
        jTextField2.setEditable(false);
    }

    public FormPesanan(String username, String role) {
        this();         
        this.usernamePegawaiLogin = username;
        this.roleLogin = role;

        jTextField2.setText(this.usernamePegawaiLogin);
        jTextField2.setEditable(false);

        if ("Pegawai".equalsIgnoreCase(role)) {
            ambilIdPegawaiDariUsername(username);
        } else if ("Admin".equalsIgnoreCase(role)) {
            this.idPegawaiLogin = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Peran tidak dikenal: " + role);
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
    
   
    private void setLoggedInUsername() {
        String username = UserSession.getLoggedInUsername();
        if (username != null && !username.isEmpty()) {
            jTextField2.setText(username);
            jTextField2.setEditable(false);
        } else {
            jTextField2.setText("Username Not Found");
            jTextField2.setEditable(false);
        }
    }
        
    private boolean cekStok(String menu, int jumlah) {
    try (Connection conn = DatabaseConnection.connect()) {
        String sql = "SELECT jumlah_stok FROM stok_menu WHERE nama_menu=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, menu);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int stok = rs.getInt("jumlah_stok");
            return stok >= jumlah;
        } else {
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    private void kurangiStok(String menu, int jumlah) {
    try (Connection conn = DatabaseConnection.connect()) {
        String sql = "UPDATE stok_menu SET jumlah_stok = jumlah_stok - ? WHERE nama_menu=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, jumlah);
        stmt.setString(2, menu);
        stmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void tampilkanDataStok(){
        try {
        Connection conn = DatabaseConnection.connect(); 
        String sql = "SELECT id_stokmenu, nama_menu, harga_jual, jumlah_stok FROM stok_menu";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Stok Menu");
        model.addColumn("Nama Menu");
        model.addColumn("Harga Jual");
        model.addColumn("Jumlah Stok");
        
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_stokmenu"),
                rs.getString("nama_menu"),
                rs.getBigDecimal("harga_jual"),
                rs.getInt("jumlah_stok")
            });
        }
        jTable1.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("FORM PESANAN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("NAMA KARYAWAN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("NOMER MEJA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("NAMA PELANGGAN");

        jLabel6.setText("Tanggal Pesanan");

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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Meja 1", "Meja 2", "Meja 3", "Meja 4", "Meja 5", "Meja 6", "Meja 7", "Meja 8", "Meja 9", "Meja 10" }));
        jComboBox2.setSelectedIndex(-1);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Search");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("NASI");

        jCheckBox1.setText("Nasi Biasa");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Nasi Pulen");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Ayam Bakar");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("Rendang");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Air Putih");

        jCheckBox6.setText("Es Teh Manis");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("LAUK");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("MINUMAN");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("JUMLAH NASI");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("JUMLAH LAUK");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButton4.setText("KEMBALI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Jumlah Minuman");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("LANJUT TRANSAKSI");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel8))
                                        .addGap(59, 59, 59)
                                        .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79)
                                        .addComponent(jCheckBox5))
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(211, 211, 211)
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(82, 82, 82)
                                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField2)
                                                .addComponent(jTextField3)
                                                .addComponent(jComboBox2, 0, 551, Short.MAX_VALUE)
                                                .addComponent(jTextField4))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                                .addComponent(jTextField6)))))
                                .addGap(0, 17, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(292, 302, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)
                        .addGap(15, 15, 15)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(241, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String keyword = jTextField7.getText().trim(); 
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan keyword yang ingin dicari.");
            return;
        }

        DefaultTableModel model = new DefaultTableModel(new Object[]{
            "ID Stok Menu", "Nama Menu", "Harga Jual", "Jumlah Stok"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try (Connection conn =DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM stok_menu WHERE " +
                "CAST(id_stokmenu AS CHAR) LIKE ? OR " +
                "nama_menu LIKE ? OR " +
                "harga_jual LIKE ? OR " +
                "jumlah_stok LIKE ? " 
            )) {

                String likeKeyword = "%" + keyword + "%";
                for (int i = 1; i <= 4; i++) {
                    stmt.setString(i, likeKeyword);
                }

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("id_stokmenu"),
                        rs.getString("nama_menu"),
                        rs.getString("harga_jual"),
                        rs.getString("jumlah_stok")
                    });
                }

                jTable1.setModel(model);

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Menu tidak ditemukan.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mencari: " + e.getMessage());
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         String namaPelanggan = jTextField3.getText().trim();
            String nomorMeja = (String) jComboBox2.getSelectedItem();
            java.util.Date tanggalPesanan = jCalendar1.getDate();

            try (Connection conn = DatabaseConnection.connect()) {
                String sqlCekMeja = "SELECT COUNT(*) FROM pesanan1 WHERE nomer_meja = ? AND status_pesanan <> 'Selesai'";
                PreparedStatement psCek = conn.prepareStatement(sqlCekMeja);
                psCek.setString(1, nomorMeja);
                ResultSet rsCek = psCek.executeQuery();
                if (rsCek.next() && rsCek.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Nomor meja " + nomorMeja + " sedang digunakan. Silakan pilih meja lain.");
                    return;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal memeriksa ketersediaan meja: " + e.getMessage());
                return;
            }
           
            String jenisNasi = jCheckBox1.isSelected() ? "Nasi Biasa" : (jCheckBox2.isSelected() ? "Nasi Pulen" : "");
            String jenisLauk = "";
            if (jCheckBox3.isSelected()) jenisLauk += "Ayam Bakar, ";
            if (jCheckBox4.isSelected()) jenisLauk += "Rendang, ";
            if (jenisLauk.endsWith(", ")) jenisLauk = jenisLauk.substring(0, jenisLauk.length() - 2);

            String jenisMinuman = "";
            if (jCheckBox5.isSelected()) jenisMinuman += "Air Putih, ";
            if (jCheckBox6.isSelected()) jenisMinuman += "Es Teh Manis, ";
            if (jenisMinuman.endsWith(", ")) jenisMinuman = jenisMinuman.substring(0, jenisMinuman.length() - 2);
            String jumlahNasiStr = jTextField4.getText().trim();
            String jumlahLaukStr = jTextField5.getText().trim();
            String jumlahMinumanStr = jTextField6.getText().trim();
            if (namaPelanggan.isEmpty() || nomorMeja.isEmpty() || tanggalPesanan == null) {
                JOptionPane.showMessageDialog(this, "Semua field wajib diisi!");
                return;
            }

            int jumlahNasi = 0, jumlahLauk = 0, jumlahMinuman = 0;
            try {
                jumlahNasi = jumlahNasiStr.isEmpty() ? 0 : Integer.parseInt(jumlahNasiStr);
                jumlahLauk = jumlahLaukStr.isEmpty() ? 0 : Integer.parseInt(jumlahLaukStr);
                jumlahMinuman = jumlahMinumanStr.isEmpty() ? 0 : Integer.parseInt(jumlahMinumanStr);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Jumlah harus berupa angka.");
                return;
            }
            
            if (jCheckBox1.isSelected() && !cekStok("Nasi Biasa", jumlahNasi)) {
                JOptionPane.showMessageDialog(this, "Stok Nasi Biasa tidak mencukupi."); return;
            }
            if (jCheckBox2.isSelected() && !cekStok("Nasi Pulen", jumlahNasi)) {
                JOptionPane.showMessageDialog(this, "Stok Nasi Pulen tidak mencukupi."); return;
            }
            if (jCheckBox3.isSelected() && !cekStok("Ayam Bakar", jumlahLauk)) {
                JOptionPane.showMessageDialog(this, "Stok Ayam Bakar tidak mencukupi."); return;
            }
            if (jCheckBox4.isSelected() && !cekStok("Rendang", jumlahLauk)) {
                JOptionPane.showMessageDialog(this, "Stok Rendang tidak mencukupi."); return;
            }
            if (jCheckBox5.isSelected() && !cekStok("Air Putih", jumlahMinuman)) {
                JOptionPane.showMessageDialog(this, "Stok Air Putih tidak mencukupi."); return;
            }
            if (jCheckBox6.isSelected() && !cekStok("Es Teh Manis", jumlahMinuman)) {
                JOptionPane.showMessageDialog(this, "Stok Es Teh Manis tidak mencukupi."); return;
            }

            double total = (jumlahNasi * 5000) + (jumlahLauk * 10000) + (jumlahMinuman * 5000);
            try (Connection conn = DatabaseConnection.connect()) {
                String sql = "INSERT INTO pesanan1 (id_karyawan, username, nama_pelanggan, nomer_meja, jenis_nasi, jumlah_nasi, "
                           + "jenis_lauk, jumlah_lauk, jenis_minuman, jumlah_minuman, jumlah_total, tanggal_pesanan) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, this.idPegawaiLogin);                   
                stmt.setString(2, this.usernamePegawaiLogin);           
                stmt.setString(3, namaPelanggan);
                stmt.setString(4, nomorMeja);
                stmt.setString(5, jenisNasi);
                stmt.setInt(6, jumlahNasi);
                stmt.setString(7, jenisLauk);
                stmt.setInt(8, jumlahLauk);
                stmt.setString(9, jenisMinuman);
                stmt.setInt(10, jumlahMinuman);
                stmt.setDouble(11, total);
                stmt.setTimestamp(12, new java.sql.Timestamp(tanggalPesanan.getTime()));

                stmt.executeUpdate();

                // Kurangi stok
                if (jCheckBox1.isSelected()) kurangiStok("Nasi Biasa", jumlahNasi);
                if (jCheckBox2.isSelected()) kurangiStok("Nasi Pulen", jumlahNasi);
                if (jCheckBox3.isSelected()) kurangiStok("Ayam Bakar", jumlahLauk);
                if (jCheckBox4.isSelected()) kurangiStok("Rendang", jumlahLauk);
                if (jCheckBox5.isSelected()) kurangiStok("Air Putih", jumlahMinuman);
                if (jCheckBox6.isSelected()) kurangiStok("Es Teh Manis", jumlahMinuman);

                JOptionPane.showMessageDialog(this, "Pesanan berhasil disimpan.");
                jTextField3.setText("");
                jComboBox2.setSelectedIndex(-1);
                jCalendar1.setDate(new java.util.Date());
                jCheckBox1.setSelected(false);
                jCheckBox2.setSelected(false);
                jCheckBox3.setSelected(false);
                jCheckBox4.setSelected(false);
                jCheckBox5.setSelected(false);
                jCheckBox6.setSelected(false);
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage());
            }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new DashboardAdmin().setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedIndex()==1){
            meja ="meja 1";
        }
        if(jComboBox2.getSelectedIndex()==2){
            meja ="meja 2";
        }
        if(jComboBox2.getSelectedIndex()==3){
            meja ="meja 3";
        }
        if(jComboBox2.getSelectedIndex()==4){
            meja ="meja 4";
        }
        if(jComboBox2.getSelectedIndex()==5){
            meja ="meja 5";
        }
        if(jComboBox2.getSelectedIndex()==6){
            meja ="meja 6";
        }
        if(jComboBox2.getSelectedIndex()==7){
            meja ="meja 7";
        }
        if(jComboBox2.getSelectedIndex()==8){
            meja ="meja 8";
        }
        if(jComboBox2.getSelectedIndex()==9){
            meja ="meja 9";
        }
        if(jComboBox2.getSelectedIndex()==10){
            meja ="meja 10";
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       new Transaksi(UserSession.getLoggedInUsername()).setVisible(true);
      dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tampilkanDataStok();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
