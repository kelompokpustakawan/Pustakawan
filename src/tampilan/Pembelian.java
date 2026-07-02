package tampilan;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi; 
import java.text.SimpleDateFormat;
import java.util.Date;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class Pembelian extends javax.swing.JFrame {
    
    private Connection conn = koneksi.getKoneksi();
    private DefaultTableModel tabmode;

    public Pembelian() {
        initComponents();
        dataTable();
        aktif();
        aturSpinnerListener();
    }

    private void aktif() {
        nofaktur.setText("");
        idpetugas.setText("");
        idbuku.setText("");
        harga.setText("0");
        jumlah.setValue(0);
        total.setText("0");
        total.setEditable(false); // Total dihitung otomatis, tidak boleh diketik manual
        nofaktur.requestFocus();
        
    }
    
    public void setIdBuku(String id) {
        idbuku.setText(id);
    }
    
    public void setDataDariPopup(String id, String hargaBuku) {
        idbuku.setText(id);
        harga.setText(hargaBuku);
    }
    private void dataTable() {
        Object[] baris = {"No Faktur", "ID Buku", "ID Petugas", "Harga Beli", "Jumlah", "Subtotal", "Tanggal"};
        tabmode = new DefaultTableModel(null, baris);
        tblsub.setModel(tabmode);
        
        String sql = "SELECT pd.no_faktur, pd.id_buku, p.id_petugas, pd.harga_beli, pd.jumlah_beli, pd.subtotal, p.tanggal_beli "
                   + "FROM pembelian_detail pd "
                   + "JOIN pembelian p ON pd.no_faktur = p.no_faktur";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString("no_faktur"),
                    hasil.getString("id_buku"),
                    hasil.getString("id_petugas"),
                    hasil.getInt("harga_beli"),
                    hasil.getInt("jumlah_beli"),
                    hasil.getInt("subtotal"),
                    hasil.getDate("tanggal_beli")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data tabel: " + e.getMessage());
        }
    }

    // Menghitung otomatis Total Harga saat jumlah spinner atau harga berubah
    private void hitungTotal() {
        try {
            int hargaBeli = harga.getText().trim().isEmpty() ? 0 : Integer.parseInt(harga.getText().trim());
            int jumlahBeli = (Integer) jumlah.getValue();
            int subtotal = hargaBeli * jumlahBeli;
            total.setText(String.valueOf(subtotal));
        } catch (NumberFormatException e) {
            total.setText("0");
        }
    }

    private void aturSpinnerListener() {
        // 1. Otomatis hitung saat nilai JSpinner (Jumlah Beli) berubah
        jumlah.addChangeListener(e -> hitungTotal());

        // 2. Otomatis hitung saat teks di JTextField (Harga Beli) berubah/diketik
        harga.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                hitungTotal();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bsimpan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idbeli = new javax.swing.JTextField();
        idpetugas = new javax.swing.JTextField();
        idbuku = new javax.swing.JTextField();
        nofaktur = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jumlah = new javax.swing.JSpinner();
        total = new javax.swing.JTextField();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        tanggal = new de.wannawork.jcalendar.JCalendarPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsub = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Form Pembelian");

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID Pembelian");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ID Petugas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ID Buku");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("No Faktur");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tanggal");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Harga Beli");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Jumlah Beli");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Total Harga");

        jumlah.setModel(new javax.swing.SpinnerNumberModel());

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblsub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tblsub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsubMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblsub);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Sub Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idbeli, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(idpetugas)
                                    .addComponent(harga)
                                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(idbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(bsimpan)
                        .addGap(62, 62, 62)
                        .addComponent(bkeluar)
                        .addGap(56, 56, 56)
                        .addComponent(bbatal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(idbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nofaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(idbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(idpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bkeluar)
                    .addComponent(bbatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
// --- VALIDASI INPUT (Tambahan Keamanan) ---
    if (nofaktur.getText().trim().isEmpty() || 
        idpetugas.getText().trim().isEmpty() || 
        idbuku.getText().trim().isEmpty() || 
        harga.getText().trim().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Semua kolom input harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan eksekusi jika ada yang kosong
    }

    int jumlahBeli = (Integer) jumlah.getValue();
    if (jumlahBeli <= 0) {
        JOptionPane.showMessageDialog(this, "Jumlah beli harus lebih dari 0!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan eksekusi jika jumlah 0
    }
    // ------------------------------------------

    String sqlMaster = "INSERT INTO pembelian (no_faktur, tanggal_beli, id_petugas, total_bayar) VALUES (?,?,?,?)";
    String sqlDetail = "INSERT INTO pembelian_detail (no_faktur, id_buku, jumlah_beli, harga_beli, subtotal) VALUES (?,?,?,?,?)";
    
    // Konversi format tanggal JCalendarPanel ke String JDBC
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String tglStr = sdf.format(tanggal.getDate());

    try {
        conn.setAutoCommit(false);

        // 1. Simpan ke Tabel Pembelian (Master)
        PreparedStatement psMaster = conn.prepareStatement(sqlMaster);
        psMaster.setString(1, nofaktur.getText().trim());
        psMaster.setString(2, tglStr);
        psMaster.setInt(3, Integer.parseInt(idpetugas.getText().trim()));
        psMaster.setInt(4, Integer.parseInt(total.getText().trim()));
        psMaster.executeUpdate();

        // 2. Simpan ke Tabel Pembelian Detail (Detail)
        PreparedStatement psDetail = conn.prepareStatement(sqlDetail);
        psDetail.setString(1, nofaktur.getText().trim());
        psDetail.setInt(2, Integer.parseInt(idbuku.getText().trim()));
        psDetail.setInt(3, jumlahBeli);
        psDetail.setInt(4, Integer.parseInt(harga.getText().trim()));
        psDetail.setInt(5, Integer.parseInt(total.getText().trim()));
        psDetail.executeUpdate();

        // ====================================================================
        // 3. TAMBAHAN: OTOMATIS MENAMBAH STOK DI TABEL BUKU
        // ====================================================================
        String sqlUpdateStok = "UPDATE buku SET stok = stok + ? WHERE id_buku = ?";
        PreparedStatement psUpdateBuku = conn.prepareStatement(sqlUpdateStok);
        psUpdateBuku.setInt(1, jumlahBeli); // Jumlah yang baru dibeli akan menambah stok lama
        psUpdateBuku.setInt(2, Integer.parseInt(idbuku.getText().trim()));
        psUpdateBuku.executeUpdate();
        // ====================================================================

        conn.commit(); // Semua transaksi (Master, Detail, & Update Stok) sukses dikunci bersamaan
        JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan dan STOK BUKU BERHASIL BERTAMBAH!");
        
        dataTable();
        aktif();
        
    } catch (SQLException | NumberFormatException e) {
        try {
            conn.rollback(); // Kembalikan database jika gagal di tengah jalan
        } catch (SQLException ex) {
            System.err.println("Rollback gagal: " + ex.getMessage());
        }
        JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi: " + e.getMessage());
    } finally {
        try {
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
    aktif();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
    dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void tblsubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsubMouseClicked
    int baris = tblsub.getSelectedRow();
        if(baris != -1) {
            nofaktur.setText(tabmode.getValueAt(baris, 0).toString());
            idbuku.setText(tabmode.getValueAt(baris, 1).toString());
            idpetugas.setText(tabmode.getValueAt(baris, 2).toString());
            harga.setText(tabmode.getValueAt(baris, 3).toString());
            jumlah.setValue(Integer.parseInt(tabmode.getValueAt(baris, 4).toString()));
            total.setText(tabmode.getValueAt(baris, 5).toString());
        }
    }//GEN-LAST:event_tblsubMouseClicked

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed

    }//GEN-LAST:event_totalActionPerformed


    public static void main(String args[]) {
    try {
    UIManager.setLookAndFeel(new FlatIntelliJLaf());
    } catch(Exception ex) {
        System.err.println("gagal memuat tema");
    }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField idbeli;
    private javax.swing.JTextField idbuku;
    private javax.swing.JTextField idpetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jumlah;
    private javax.swing.JTextField nofaktur;
    private de.wannawork.jcalendar.JCalendarPanel tanggal;
    private javax.swing.JTable tblsub;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
