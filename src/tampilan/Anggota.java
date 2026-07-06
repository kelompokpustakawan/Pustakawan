package tampilan;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi; 
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;

public class Anggota extends javax.swing.JFrame {
    private Connection conn = koneksi.getKoneksi();
    private DefaultTableModel tabmode;
    
    public Anggota() {
        initComponents();
        aktif();
        datatable(); 
        this.setLocationRelativeTo(null);
    }
    
    
    protected void aktif() {
        txtid.setText("");
        txtkode.setText("");
        txtnama.setText("");
        buttonGroup1.clearSelection();
        tgllahir.setText("");
        notlp.setText("");
        tglregis.setText("");
        txtstatus.setSelectedIndex(0);
        txtid.requestFocus();
    }

    
    protected void datatable() {
        Object[] Baris = {"ID Anggota", "Kode", "Nama Lengkap", "Jenis Kelamin", "Tanggal Lahir", "No. Telp", "Tgl Registrasi", "Status"};
        tabmode = new DefaultTableModel(null, Baris);
        txttable.setModel(tabmode);
        
        String sql = "SELECT * FROM anggota";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String a = hasil.getString("id_anggota");
                String b = hasil.getString("kode_anggota");
                String c = hasil.getString("nama_lengkap");
                String d = hasil.getString("jenis_kelamin");
                String e = hasil.getString("tanggal_lahir");
                String f = hasil.getString("no_telp");
                String g = hasil.getString("tgl_registrasi");
                String h = hasil.getString("status_aktif");
                
                String[] data = {a, b, c, d, e, f, g, h};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txttable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rlaki = new javax.swing.JRadioButton();
        rperempuan = new javax.swing.JRadioButton();
        tgllahir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        notlp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tglregis = new javax.swing.JTextField();
        txtstatus = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Anggota");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Data Anggota");

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });

        btncari.setText("Carri");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        txttable.setModel(new javax.swing.table.DefaultTableModel(
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
        txttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txttable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncari)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id Anggota");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kode Anggota");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama Lengkap");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jenis Kelamin");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tanggal Lahir");

        rlaki.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(rlaki);
        rlaki.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rlaki.setForeground(new java.awt.Color(255, 255, 255));
        rlaki.setText("Laki - Laki");

        rperempuan.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup1.add(rperempuan);
        rperempuan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rperempuan.setForeground(new java.awt.Color(255, 255, 255));
        rperempuan.setText("Perempuan");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No Telepon");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanggal Registrasi");

        txtstatus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Non-Aktif" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Status");

        btnsimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnubah.setBackground(new java.awt.Color(255, 255, 255));
        btnubah.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btnhapus.setBackground(new java.awt.Color(255, 255, 255));
        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnbatal.setBackground(new java.awt.Color(255, 255, 255));
        btnbatal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnkeluar.setBackground(new java.awt.Color(255, 255, 255));
        btnkeluar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tgllahir)
                                    .addComponent(tglregis)
                                    .addComponent(notlp)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rlaki)
                                                .addGap(26, 26, 26)
                                                .addComponent(rperempuan)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtnama)
                                    .addComponent(txtid)
                                    .addComponent(txtkode))
                                .addGap(261, 261, 261))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnsimpan)
                        .addGap(47, 47, 47)
                        .addComponent(btnubah)
                        .addGap(51, 51, 51)
                        .addComponent(btnhapus)
                        .addGap(48, 48, 48)
                        .addComponent(btnbatal)
                        .addGap(55, 55, 55)
                        .addComponent(btnkeluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rlaki)
                    .addComponent(rperempuan)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(notlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tglregis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnubah)
                    .addComponent(btnhapus)
                    .addComponent(btnbatal)
                    .addComponent(btnkeluar))
                .addGap(143, 143, 143))
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

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
    btncariActionPerformed(evt);
    }//GEN-LAST:event_txtcariActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
    String sql = "INSERT INTO anggota (id_anggota, kode_anggota, nama_lengkap, jenis_kelamin, tanggal_lahir, no_telp, tgl_registrasi, status_aktif) VALUES (?,?,?,?,?,?,?,?)";
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtid.getText());
        stat.setString(2, txtkode.getText());
        stat.setString(3, txtnama.getText());
        
        String jk = rlaki.isSelected() ? "L" : "P";
        stat.setString(4, jk);
        
        SimpleDateFormat formatInput = new SimpleDateFormat("dd-mm-yyyy"); 
        SimpleDateFormat formatMySQL = new SimpleDateFormat("yyyy-mm-dd"); 
        
        String tglLahirMySQL = formatMySQL.format(formatInput.parse(tgllahir.getText()));
        String tglRegisMySQL = formatMySQL.format(formatInput.parse(tglregis.getText()));
        
        stat.setString(5, tglLahirMySQL);
        stat.setString(6, notlp.getText());
        stat.setString(7, tglRegisMySQL);
        
        String status = txtstatus.getSelectedItem().toString().equals("Aktif") ? "Aktif" : "Nonaktif";
        stat.setString(8, status);
        
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
        aktif();
        datatable();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Format tanggal salah! Gunakan format: DD-MM-YYYY (Contoh: 25-12-1999)");
    }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
    String sql = "UPDATE anggota SET kode_anggota=?, nama_lengkap=?, jenis_kelamin=?, tanggal_lahir=?, no_telp=?, tgl_registrasi=?, status_aktif=? WHERE id_anggota=?";
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtkode.getText());
        stat.setString(2, txtnama.getText());
        
        String jk = rlaki.isSelected() ? "L" : "P";
        stat.setString(3, jk);
        
        
        SimpleDateFormat formatInput = new SimpleDateFormat("dd-MM-yyyy"); 
        SimpleDateFormat formatMySQL = new SimpleDateFormat("yyyy-MM-dd"); 
        
        String tglLahirMySQL = formatMySQL.format(formatInput.parse(tgllahir.getText()));
        String tglRegisMySQL = formatMySQL.format(formatInput.parse(tglregis.getText()));
        
        stat.setString(4, tglLahirMySQL);
        stat.setString(5, notlp.getText());
        stat.setString(6, tglRegisMySQL);
        
        String status = txtstatus.getSelectedItem().toString().equals("Aktif") ? "Aktif" : "Nonaktif";
        stat.setString(7, status);
        stat.setString(8, txtid.getText()); 
        
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
        aktif();
        datatable();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Diubah: " + e.getMessage());
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Format tanggal salah! Gunakan format: DD-MM-YYYY (Contoh: 25-12-1999)");
    }
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
    int ok = JOptionPane.showConfirmDialog(null, "Hapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "DELETE FROM anggota WHERE id_anggota=?";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, txtid.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
                aktif();
                datatable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
    aktif();
    datatable();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
    dispose();  
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
    Object[] Baris = {"ID Anggota", "Kode", "Nama Lengkap", "Jenis Kelamin", "Tanggal Lahir", "No. Telp", "Tgl Registrasi", "Status"};
        tabmode = new DefaultTableModel(null, Baris);
        txttable.setModel(tabmode);
        
        String sql = "SELECT * FROM anggota WHERE id_anggota LIKE ? OR nama_lengkap LIKE ?";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, "%" + txtcari.getText() + "%");
            stat.setString(2, "%" + txtcari.getText() + "%");
            ResultSet hasil = stat.executeQuery();
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString("id_anggota"),
                    hasil.getString("kode_anggota"),
                    hasil.getString("nama_lengkap"),
                    hasil.getString("jenis_kelamin"),
                    hasil.getString("tanggal_lahir"),
                    hasil.getString("no_telp"),
                    hasil.getString("tgl_registrasi"),
                    hasil.getString("status_aktif")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian Gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void txttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttableMouseClicked
    int bar = txttable.getSelectedRow();
        txtid.setText(tabmode.getValueAt(bar, 0).toString());
        txtkode.setText(tabmode.getValueAt(bar, 1).toString());
        txtnama.setText(tabmode.getValueAt(bar, 2).toString());
        
        String jk = tabmode.getValueAt(bar, 3).toString();
        if (jk.equals("L")) { 
            rlaki.setSelected(true); 
        } else { 
            rperempuan.setSelected(true); 
        }
        
        tgllahir.setText(tabmode.getValueAt(bar, 4).toString());
        notlp.setText(tabmode.getValueAt(bar, 5).toString());
        tglregis.setText(tabmode.getValueAt(bar, 6).toString());
        
        String status = tabmode.getValueAt(bar, 7).toString();
        if (status.equalsIgnoreCase("Aktif")) { 
            txtstatus.setSelectedIndex(0); 
        } else { 
            txtstatus.setSelectedIndex(1); 
        }
    }//GEN-LAST:event_txttableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    try {
    UIManager.setLookAndFeel(new FlatIntelliJLaf());
    } catch(Exception ex) {
        System.err.println("gagal memuat tema");
    }

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Anggota().setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField notlp;
    private javax.swing.JRadioButton rlaki;
    private javax.swing.JRadioButton rperempuan;
    private javax.swing.JTextField tgllahir;
    private javax.swing.JTextField tglregis;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JComboBox<String> txtstatus;
    private javax.swing.JTable txttable;
    // End of variables declaration//GEN-END:variables
}
