package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;




public class Rak extends javax.swing.JFrame {
private Connection conn = koneksi.getKoneksi(); 
private DefaultTableModel tabmode;

public Rak() {
    initComponents();
    datatable(); 
}

protected void datatable() {
    Object[] Baris = {"ID Rak", "Nama Rak", "Lokasi"};
    tabmode = new DefaultTableModel(null, Baris);
    jTable1.setModel(tabmode);
    String sql = "SELECT * FROM rak"; // Ubah dari kategori ke rak
    try {
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while (hasil.next()) {
            String a = hasil.getString("id_rak");
            String b = hasil.getString("nama_rak");
            String c = hasil.getString("lokasi");
            String[] data = {a, b, c};
            tabmode.addRow(data);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal menampilkan data: " + e);
    }
}

private void kosong() {
    txtid.setText("");
    txtkategori.setText("");
    jComboBox1.setSelectedIndex(0);
    jTextField1.setText("");
    txtid.requestFocus();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtkategori = new javax.swing.JTextField();
        txtsimpan = new javax.swing.JButton();
        txtubah = new javax.swing.JButton();
        txtbatal = new javax.swing.JButton();
        txthapus = new javax.swing.JButton();
        txtkeluar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtcari = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Form Rak Buku");

        jLabel2.setText("ID Rak");

        jLabel3.setText("Nama Rak");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

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

        txtbatal.setText("Batal");
        txtbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbatalActionPerformed(evt);
            }
        });

        txthapus.setText("Hapus");
        txthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthapusActionPerformed(evt);
            }
        });

        txtkeluar.setText("Keluar");
        txtkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkeluarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtcari.setText("cari");
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcari)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setText("Lokasi");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lantai 1", "Lantai 2", "Lantai 3" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsimpan)
                                    .addComponent(jLabel4))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtubah)
                                        .addGap(33, 33, 33)
                                        .addComponent(txtbatal)
                                        .addGap(32, 32, 32)
                                        .addComponent(txthapus)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtkeluar))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtkategori)
                                        .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsimpan)
                    .addComponent(txtubah)
                    .addComponent(txtbatal)
                    .addComponent(txthapus)
                    .addComponent(txtkeluar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsimpanActionPerformed
    String sql = "INSERT INTO rak VALUES (?,?,?)";
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtid.getText());
        stat.setString(2, txtkategori.getText());
        stat.setString(3, jComboBox1.getSelectedItem().toString()); // Ambil data dari ComboBox
        
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        kosong();
        datatable(); 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e);
    }
    }//GEN-LAST:event_txtsimpanActionPerformed

    private void txtubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtubahActionPerformed
    String sql = "UPDATE rak SET nama_rak=?, lokasi=? WHERE id_rak=?";
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, txtkategori.getText());
        stat.setString(2, jComboBox1.getSelectedItem().toString());
        stat.setString(3, txtid.getText());
        
        stat.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        kosong();
        datatable(); 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data Gagal Diubah: " + e);
}    // TODO add your handling code here:
    }//GEN-LAST:event_txtubahActionPerformed

    private void txtbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbatalActionPerformed
    kosong();
    }//GEN-LAST:event_txtbatalActionPerformed

    private void txthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthapusActionPerformed
    int ok = JOptionPane.showConfirmDialog(null, "Hapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
    if (ok == 0) {
        String sql = "DELETE FROM rak WHERE id_rak = ?"; // Gunakan parameter ?
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtid.getText());
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            kosong(); // Gunakan method kosong agar semua field bersih
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e);
        }
    }
    }//GEN-LAST:event_txthapusActionPerformed

    private void txtkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkeluarActionPerformed
    dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_txtkeluarActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
    Object[] Baris = {"ID Rak", "Nama Rak", "Lokasi"}; // Sesuaikan jumlah kolom
    tabmode = new DefaultTableModel(null, Baris);
    jTable1.setModel(tabmode);
    
    // Gunakan query yang mencari di Nama atau ID
    String sql = "SELECT * FROM rak WHERE nama_rak LIKE ? OR id_rak LIKE ?";
    
    try {
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, "%" + jTextField1.getText() + "%");
        stat.setString(2, "%" + jTextField1.getText() + "%");
        ResultSet hasil = stat.executeQuery();
        
        while (hasil.next()) {
            tabmode.addRow(new Object[]{
                hasil.getString("id_rak"),
                hasil.getString("nama_rak"),
                hasil.getString("lokasi")
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Pencarian Gagal: " + e);
    }
    }//GEN-LAST:event_txtcariActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int bar = jTable1.getSelectedRow();
    String a = tabmode.getValueAt(bar, 0).toString(); 
    String b = tabmode.getValueAt(bar, 1).toString(); 
    String c = tabmode.getValueAt(bar, 2).toString();

    txtid.setText(a);
    txtkategori.setText(b);
    jComboBox1.setSelectedItem(c);
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton txtbatal;
    private javax.swing.JButton txtcari;
    private javax.swing.JButton txthapus;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtkategori;
    private javax.swing.JButton txtkeluar;
    private javax.swing.JButton txtsimpan;
    private javax.swing.JButton txtubah;
    // End of variables declaration//GEN-END:variables

}
