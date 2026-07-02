package tampilan;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;


public class Buku extends javax.swing.JFrame {
    public Buku() {
        initComponents(); 
        tampil_kategori(); 
        tampil_rak();     
        datatable();      
    }

    private void tampil_kategori() {
        try {
            String sql = "SELECT nama_kategori FROM kategori";
            Connection conn = koneksi.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            txtkategori.removeAllItems(); 
            while (rs.next()) {
                txtkategori.addItem(rs.getString("nama_kategori"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Load Kategori: " + e.getMessage());
        }
    }

    private void tampil_rak() {
        try {
            String sql = "SELECT nama_rak FROM rak";
            Connection conn = koneksi.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            txtrak.removeAllItems();
            while (rs.next()) {
                txtrak.addItem(rs.getString("nama_rak"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Load Rak: " + e.getMessage());
        }
    }
    
    private void datatable() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Buku");
    model.addColumn("ISBN");
    model.addColumn("Judul");
    model.addColumn("Penulis");
    model.addColumn("Penerbit");
    model.addColumn("Tahun");
    model.addColumn("Stok");
    model.addColumn("Kategori");
    model.addColumn("Rak");

    try {
       
        String sql = "SELECT b.id_buku, b.isbn, b.judul, b.penulis, b.penerbit, b.tahun_terbit, b.stok, k.nama_kategori, r.nama_rak " +
                     "FROM buku b " +
                     "INNER JOIN kategori k ON b.id_kategori = k.id_kategori " +
                     "INNER JOIN rak r ON b.id_rak = r.id_rak";
        Connection conn = koneksi.getKoneksi();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_buku"),
                rs.getString("isbn"),
                rs.getString("judul"),
                rs.getString("penulis"),
                rs.getString("penerbit"),
                rs.getString("tahun_terbit"), 
                rs.getString("stok"),       
                rs.getString("nama_kategori"), 
                rs.getString("nama_rak")      
            });
        }
        tblbk.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data: " + e.getMessage());
    }
}
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtisbn = new javax.swing.JTextField();
        txtjudul = new javax.swing.JTextField();
        txtpenulis = new javax.swing.JTextField();
        txtpenerbit = new javax.swing.JTextField();
        txtkategori = new javax.swing.JComboBox<>();
        txtrak = new javax.swing.JComboBox<>();
        txttahun = new javax.swing.JSpinner();
        txtpersediaan = new javax.swing.JSpinner();
        txtsimpan = new javax.swing.JButton();
        txtubah = new javax.swing.JButton();
        txthapus = new javax.swing.JButton();
        txtbatal = new javax.swing.JButton();
        txtkeluar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtcari = new javax.swing.JTextField();
        tcari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbk = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Form Buku");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ID Buku");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ISBN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Judul");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Penulis");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Penerbit");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tahun Terbit");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Persediaan");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Kategori");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Rak Buku");

        txtkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horor", "Ilmiah", "Fiksi", "Aksi" }));

        txtrak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Albert", "Einstein", "Nicolas", "Tesla" }));

        txttahun.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(1900L), Long.valueOf(1900L), Long.valueOf(2100L), Long.valueOf(1L)));
        txttahun.setEditor(new javax.swing.JSpinner.NumberEditor(txttahun, "0000"));

        txtpersediaan.setModel(new javax.swing.SpinnerNumberModel());

        txtsimpan.setText("Simpan");
        txtsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsimpanActionPerformed(evt);
            }
        });

        txtubah.setText("Ubah");
        txtubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtubahActionPerformed(evt);
            }
        });

        txthapus.setText("Hapus");
        txthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthapusActionPerformed(evt);
            }
        });

        txtbatal.setText("Batal");
        txtbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbatalActionPerformed(evt);
            }
        });

        txtkeluar.setText("Keluar");
        txtkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkeluarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtcari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tcari.setText("Cari");
        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });

        tblbk.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        tblbk.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbk);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(txtsimpan)
                        .addGap(46, 46, 46)
                        .addComponent(txtubah)
                        .addGap(42, 42, 42)
                        .addComponent(txthapus)
                        .addGap(46, 46, 46)
                        .addComponent(txtbatal)
                        .addGap(48, 48, 48)
                        .addComponent(txtkeluar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(29, 29, 29))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtid)
                                        .addComponent(txtisbn)
                                        .addComponent(txtjudul)
                                        .addComponent(txtpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtrak, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtkategori, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtpersediaan, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttahun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jLabel1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpersediaan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsimpan)
                    .addComponent(txtubah)
                    .addComponent(txthapus)
                    .addComponent(txtbatal)
                    .addComponent(txtkeluar))
                .addGap(101, 101, 101))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Buku");
    model.addColumn("ISBN");
    model.addColumn("Judul");
    model.addColumn("Penulis");
    model.addColumn("Penerbit");
    model.addColumn("Tahun");
    model.addColumn("Stok");
    model.addColumn("Kategori");
    model.addColumn("Rak");

    try {
        String sql = "SELECT b.id_buku, b.isbn, b.judul, b.penulis, b.penerbit, b.tahun_terbit, b.stok, k.nama_kategori, r.nama_rak " +
                     "FROM buku b " +
                     "INNER JOIN kategori k ON b.id_kategori = k.id_kategori " +
                     "INNER JOIN rak r ON b.id_rak = r.id_rak " +
                     "WHERE b.judul LIKE ? OR b.penulis LIKE ?";
        
        Connection conn = koneksi.getKoneksi();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + txtcari.getText() + "%");
        pst.setString(2, "%" + txtcari.getText() + "%");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_buku"),
                rs.getString("isbn"),
                rs.getString("judul"),
                rs.getString("penulis"),
                rs.getString("penerbit"),
                rs.getString("tahun_terbit"),
                rs.getString("stok"),
                rs.getString("nama_kategori"),
                rs.getString("nama_rak")
            });
        }
        tblbk.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Pencarian Gagal: " + e.getMessage());
    }
    }//GEN-LAST:event_tcariActionPerformed

    private void tblbkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbkMouseClicked
    int baris = tblbk.rowAtPoint(evt.getPoint());
    
    String id = tblbk.getValueAt(baris, 0).toString();
    txtid.setText(id);
    txtid.setEditable(false);
    
    txtisbn.setText(tblbk.getValueAt(baris, 1).toString());
    txtjudul.setText(tblbk.getValueAt(baris, 2).toString());
    txtpenulis.setText(tblbk.getValueAt(baris, 3).toString());
    txtpenerbit.setText(tblbk.getValueAt(baris, 4).toString());
    
    txttahun.setValue(Integer.parseInt(tblbk.getValueAt(baris, 5).toString()));
    txtpersediaan.setValue(Integer.parseInt(tblbk.getValueAt(baris, 6).toString()));
    
    txtkategori.setSelectedItem(tblbk.getValueAt(baris, 7).toString());
    txtrak.setSelectedItem(tblbk.getValueAt(baris, 8).toString());
    }//GEN-LAST:event_tblbkMouseClicked

    private void txtkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkeluarActionPerformed
        dispose();
    }//GEN-LAST:event_txtkeluarActionPerformed

    private void txtbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbatalActionPerformed
    txtid.setText("");
    txtisbn.setText("");
    txtjudul.setText("");
    txtpenulis.setText("");
    txtpenerbit.setText("");
    txttahun.setValue(1900);
    txtpersediaan.setValue(0);
    txtkategori.setSelectedIndex(0);
    txtrak.setSelectedIndex(0);
    txtid.setEditable(true);
    txtid.requestFocus();
    }//GEN-LAST:event_txtbatalActionPerformed

    private void txthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthapusActionPerformed
    int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (ok == 0) {
        try {
            String sql = "DELETE FROM buku WHERE id_buku=?";
            Connection conn = koneksi.getKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtid.getText());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            datatable();
            txtbatalActionPerformed(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menghapus Data: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_txthapusActionPerformed

    private void txtubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtubahActionPerformed
    try {
        Connection conn = koneksi.getKoneksi();
        
        String sqlKategori = "SELECT id_kategori FROM kategori WHERE nama_kategori = ?";
        PreparedStatement pstK = conn.prepareStatement(sqlKategori);
        pstK.setString(1, txtkategori.getSelectedItem().toString());
        ResultSet rsK = pstK.executeQuery();
        int idKategori = 0;
        if(rsK.next()) { idKategori = rsK.getInt("id_kategori"); }

        
        String sqlRak = "SELECT id_rak FROM rak WHERE nama_rak = ?";
        PreparedStatement pstR = conn.prepareStatement(sqlRak);
        pstR.setString(1, txtrak.getSelectedItem().toString());
        ResultSet rsR = pstR.executeQuery();
        int idRak = 0;
        if(rsR.next()) { idRak = rsR.getInt("id_rak"); }

        
        String sql = "UPDATE buku SET isbn=?, judul=?, penulis=?, penerbit=?, tahun_terbit=?, stok=?, id_kategori=?, id_rak=? WHERE id_buku=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtisbn.getText());
        pst.setString(2, txtjudul.getText());
        pst.setString(3, txtpenulis.getText());
        pst.setString(4, txtpenerbit.getText());
        pst.setString(5, txttahun.getValue().toString());
        pst.setString(6, txtpersediaan.getValue().toString());
        pst.setInt(7, idKategori);
        pst.setInt(8, idRak);
        pst.setString(9, txtid.getText());
        
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        datatable();
        txtbatalActionPerformed(null);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal Mengubah Data: " + e.getMessage());
    }
    }//GEN-LAST:event_txtubahActionPerformed

    private void txtsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsimpanActionPerformed
    try {
        Connection conn = koneksi.getKoneksi();
        
        
        String sqlKategori = "SELECT id_kategori FROM kategori WHERE nama_kategori = ?";
        PreparedStatement pstK = conn.prepareStatement(sqlKategori);
        pstK.setString(1, txtkategori.getSelectedItem().toString());
        ResultSet rsK = pstK.executeQuery();
        int idKategori = 0;
        if(rsK.next()) { idKategori = rsK.getInt("id_kategori"); }

        
        String sqlRak = "SELECT id_rak FROM rak WHERE nama_rak = ?";
        PreparedStatement pstR = conn.prepareStatement(sqlRak);
        pstR.setString(1, txtrak.getSelectedItem().toString());
        ResultSet rsR = pstR.executeQuery();
        int idRak = 0;
        if(rsR.next()) { idRak = rsR.getInt("id_rak"); }

        
        String sql = "INSERT INTO buku (id_buku, isbn, judul, penulis, penerbit, tahun_terbit, stok, id_kategori, id_rak) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtid.getText());
        pst.setString(2, txtisbn.getText());
        pst.setString(3, txtjudul.getText());
        pst.setString(4, txtpenulis.getText());
        pst.setString(5, txtpenerbit.getText());
        pst.setString(6, txttahun.getValue().toString());
        pst.setString(7, txtpersediaan.getValue().toString());
        pst.setInt(8, idKategori);
        pst.setInt(9, idRak);
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        datatable(); 
        txtbatalActionPerformed(null);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal Simpan: " + e.getMessage());
    }
    }//GEN-LAST:event_txtsimpanActionPerformed

    
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
                new Buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbk;
    private javax.swing.JButton tcari;
    private javax.swing.JButton txtbatal;
    private javax.swing.JTextField txtcari;
    private javax.swing.JButton txthapus;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JComboBox<String> txtkategori;
    private javax.swing.JButton txtkeluar;
    private javax.swing.JTextField txtpenerbit;
    private javax.swing.JTextField txtpenulis;
    private javax.swing.JSpinner txtpersediaan;
    private javax.swing.JComboBox<String> txtrak;
    private javax.swing.JButton txtsimpan;
    private javax.swing.JSpinner txttahun;
    private javax.swing.JButton txtubah;
    // End of variables declaration//GEN-END:variables
}
