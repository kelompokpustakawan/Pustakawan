package tampilan;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;


public class Pengembalian extends javax.swing.JFrame {
    private Connection conn = koneksi.getKoneksi();
    private DefaultTableModel tabmode;

    public Pengembalian() {
        initComponents();
        tampilDataTabel();
        this.setLocationRelativeTo(null);
        txtpengembalian.setText(generateIDPengembalian());
        txtkembali.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hitungDenda();
            }
        });
    }
    
    private void tampilDataTabel() {
        Object[] baris = {"ID Peminjaman", "ID Anggota", "Nama Anggota", "Tgl Pinjam", "Tgl Kembali", "Status"};
        tabmode = new DefaultTableModel(null, baris);
        tbldaftar.setModel(tabmode);
        
        String sql = "SELECT p.id_peminjaman, p.id_anggota, a.nama_lengkap, p.tanggal_pinjam, p.tanggal_kembali, p.status " +
                     "FROM peminjaman p JOIN anggota a ON p.id_anggota = a.id_anggota " +
                     "WHERE p.status = 'Dipinjam'";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String idPinjam = hasil.getString("id_peminjaman");
                String idAnggota = hasil.getString("id_anggota");
                String nama = hasil.getString("nama_lengkap");
                Date tglPinjam = hasil.getDate("tanggal_pinjam");
                Date tglKembali = hasil.getDate("tanggal_kembali");
                String status = hasil.getString("status");
                
                Object[] data = {idPinjam, idAnggota, nama, tglPinjam, tglKembali, status};
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data tabel: " + e.getMessage());
        }
    }

    private void hitungDenda() {
        try {
            java.util.Date tglHarusKembali = txtpinjam.getDate();
            java.util.Date tglDikembalikan = txtkembali.getDate(); 
            
            int baris = tbldaftar.getSelectedRow();
            if (baris != -1) {
                tglHarusKembali = (java.util.Date) tbldaftar.getValueAt(baris, 4);
            }

            long diffInMillies = tglDikembalikan.getTime() - tglHarusKembali.getTime();
            long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);

            if (diffInDays > 0) {
                long denda = diffInDays * 2000;
                txtdenda.setText(String.valueOf(denda));
            } else {
                txtdenda.setText("0");
            }
        } catch (Exception e) {
            txtdenda.setText("0");
        }
    }

    private String generateIDPengembalian() {
        try {
            String sql = "SELECT MAX(id_pengembalian) AS max_id FROM pengembalian";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                return String.valueOf(maxId + 1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "1";
    }

    private void bersihkanForm() {
        txtpeminjaman.setText("");
        txtpengembalian.setText(generateIDPengembalian());
        txtanggota.setText("");
        txtnama.setText("");
        txtpinjam.setDate(new java.util.Date());
        txtkembali.setDate(new java.util.Date());
        txtdenda.setText("");
        tbldaftar.clearSelection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldaftar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtpeminjaman = new javax.swing.JTextField();
        txtpengembalian = new javax.swing.JTextField();
        txtanggota = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtpinjam = new de.wannawork.jcalendar.JCalendarComboBox();
        txtkembali = new de.wannawork.jcalendar.JCalendarComboBox();
        txtdenda = new javax.swing.JTextField();
        bproses = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbldaftar.setModel(new javax.swing.table.DefaultTableModel(
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
        tbldaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldaftarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldaftar);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Daftar Buku Dipinjam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Form Pengembalian");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Peminjaman ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Pengembalian");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Anggota");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tanggal Pinjam");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tanggal Kembali");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Denda");

        bproses.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bproses.setText("Simpan");
        bproses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprosesActionPerformed(evt);
            }
        });

        bbatal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpeminjaman)
                            .addComponent(txtpengembalian)
                            .addComponent(txtanggota)
                            .addComponent(txtnama)
                            .addComponent(txtpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdenda)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(bproses)
                        .addGap(80, 80, 80)
                        .addComponent(bbatal)
                        .addGap(91, 91, 91)
                        .addComponent(bkeluar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtpengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7))
                    .addComponent(txtpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtdenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bproses)
                    .addComponent(bbatal)
                    .addComponent(bkeluar))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbldaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldaftarMouseClicked
    int baris = tbldaftar.getSelectedRow();
        if (baris != -1) {
            txtpeminjaman.setText(tabmode.getValueAt(baris, 0).toString());
            txtanggota.setText(tabmode.getValueAt(baris, 1).toString());
            txtnama.setText(tabmode.getValueAt(baris, 2).toString());
            
            txtpinjam.setDate((java.util.Date) tabmode.getValueAt(baris, 3));
            txtkembali.setDate(new java.util.Date());
            
            hitungDenda();
        }
    }//GEN-LAST:event_tbldaftarMouseClicked

    private void bprosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprosesActionPerformed
    String idPengembalian = txtpengembalian.getText();
        String idPeminjaman = txtpeminjaman.getText();
        String dendaStr = txtdenda.getText();
        
        if (idPeminjaman.isEmpty() || idPengembalian.isEmpty() || dendaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data peminjaman dari tabel terlebih dahulu!");
            return;
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String tglDikembalikan = sdf.format(txtkembali.getDate());
        int denda = Integer.parseInt(dendaStr);

        try {
            conn.setAutoCommit(false);

            String sqlInsert = "INSERT INTO pengembalian (id_pengembalian, id_peminjaman, tanggal_dikembalikan, denda) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
            psInsert.setInt(1, Integer.parseInt(idPengembalian));
            psInsert.setInt(2, Integer.parseInt(idPeminjaman));
            psInsert.setString(3, tglDikembalikan);
            psInsert.setInt(4, denda);
            psInsert.executeUpdate();

            String sqlUpdate = "UPDATE peminjaman SET status = 'Kembali' WHERE id_peminjaman = ?";
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, Integer.parseInt(idPeminjaman));
            psUpdate.executeUpdate();

            conn.commit();
            JOptionPane.showMessageDialog(this, "Proses Pengembalian Berhasil Terproses!");
            
            bersihkanForm();
            tampilDataTabel(); 
            
        } catch (SQLException e) {
            try {
                conn.rollback();
                JOptionPane.showMessageDialog(this, "Transaksi Gagal, Perubahan Dibatalkan: " + e.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_bprosesActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
    bersihkanForm();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
    int opsi = JOptionPane.showConfirmDialog(this, "Apakah Anda ingin keluar dari form ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_bkeluarActionPerformed

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
                new Pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bproses;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable tbldaftar;
    private javax.swing.JTextField txtanggota;
    private javax.swing.JTextField txtdenda;
    private de.wannawork.jcalendar.JCalendarComboBox txtkembali;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtpeminjaman;
    private javax.swing.JTextField txtpengembalian;
    private de.wannawork.jcalendar.JCalendarComboBox txtpinjam;
    // End of variables declaration//GEN-END:variables
}
