
package tampilan;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        master = new javax.swing.JMenu();
        mkategori = new javax.swing.JMenuItem();
        mbuku = new javax.swing.JMenuItem();
        mrak = new javax.swing.JMenuItem();
        mpetugas = new javax.swing.JMenuItem();
        manggota = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        transaksi = new javax.swing.JMenu();
        trpengembalian = new javax.swing.JMenuItem();
        trpeminjaman = new javax.swing.JMenuItem();
        trpembelian = new javax.swing.JMenuItem();
        trhilang = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        laporan = new javax.swing.JMenu();
        lpinjam = new javax.swing.JMenuItem();
        lkembali = new javax.swing.JMenuItem();
        lbeli = new javax.swing.JMenuItem();
        lhilang = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        nama = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat Datang ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Di Perpustakaan Digital");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/Perpus.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 153, 255));
        jMenuBar1.setBorder(null);

        master.setBorder(null);
        master.setText("Master");
        master.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        master.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterActionPerformed(evt);
            }
        });

        mkategori.setText("Kategori");
        mkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mkategoriActionPerformed(evt);
            }
        });
        master.add(mkategori);

        mbuku.setText("Buku");
        mbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbukuActionPerformed(evt);
            }
        });
        master.add(mbuku);

        mrak.setText("Rak");
        mrak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrakActionPerformed(evt);
            }
        });
        master.add(mrak);

        mpetugas.setText("Petugas");
        mpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpetugasActionPerformed(evt);
            }
        });
        master.add(mpetugas);

        manggota.setText("Anggota");
        manggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manggotaActionPerformed(evt);
            }
        });
        master.add(manggota);

        jMenuBar1.add(master);

        jMenu2.setText("       ");
        jMenuBar1.add(jMenu2);

        transaksi.setBorder(null);
        transaksi.setText("Transaksi");
        transaksi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiActionPerformed(evt);
            }
        });

        trpengembalian.setText("Pengembalian");
        trpengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trpengembalianActionPerformed(evt);
            }
        });
        transaksi.add(trpengembalian);

        trpeminjaman.setText("Peminjaman");
        trpeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trpeminjamanActionPerformed(evt);
            }
        });
        transaksi.add(trpeminjaman);

        trpembelian.setText("Pembelian");
        trpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trpembelianActionPerformed(evt);
            }
        });
        transaksi.add(trpembelian);

        trhilang.setText("Hilang & Rusak");
        trhilang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trhilangActionPerformed(evt);
            }
        });
        transaksi.add(trhilang);

        jMenuBar1.add(transaksi);

        jMenu4.setText("       ");
        jMenuBar1.add(jMenu4);

        laporan.setBorder(null);
        laporan.setText("Laporan");
        laporan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });

        lpinjam.setText("Laporan Peminjaman");
        lpinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpinjamActionPerformed(evt);
            }
        });
        laporan.add(lpinjam);

        lkembali.setText("Laporan Pengembalian");
        lkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lkembaliActionPerformed(evt);
            }
        });
        laporan.add(lkembali);

        lbeli.setText("Laporan Pembelian");
        lbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbeliActionPerformed(evt);
            }
        });
        laporan.add(lbeli);

        lhilang.setText("Laporan Hilang & Rusak");
        lhilang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lhilangActionPerformed(evt);
            }
        });
        laporan.add(lhilang);

        jMenuBar1.add(laporan);

        jMenu1.setText("       ");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Kelompok");
        jMenu3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        nama.setText("Nama");
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jMenu3.add(nama);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mkategoriActionPerformed
    Kategori formKategori = new Kategori();
    formKategori.setVisible(true);
    }//GEN-LAST:event_mkategoriActionPerformed

    private void mbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbukuActionPerformed
    Buku formBuku = new Buku();
    formBuku.setVisible(true);
    }//GEN-LAST:event_mbukuActionPerformed

    private void mpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpetugasActionPerformed
    Petugas formPetugas = new Petugas();
    formPetugas.setVisible(true);
    }//GEN-LAST:event_mpetugasActionPerformed

    private void masterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterActionPerformed

    }//GEN-LAST:event_masterActionPerformed

    private void transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiActionPerformed
    Peminjaman formPinjam = new Peminjaman();
    formPinjam.setVisible(true);
    }//GEN-LAST:event_transaksiActionPerformed

    private void trpengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trpengembalianActionPerformed
    Pengembalian formKembali = new Pengembalian();
    formKembali.setVisible(true);
    }//GEN-LAST:event_trpengembalianActionPerformed

    private void trpeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trpeminjamanActionPerformed
    Peminjaman formPinjam = new Peminjaman();
    formPinjam.setVisible(true);
    }//GEN-LAST:event_trpeminjamanActionPerformed

    private void trpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trpembelianActionPerformed
    Pembelian formBeli = new Pembelian();
    formBeli.setVisible(true);
    }//GEN-LAST:event_trpembelianActionPerformed

    private void trhilangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trhilangActionPerformed
    Hilangdanrusak formHilang = new Hilangdanrusak();
    formHilang.setVisible(true);
    }//GEN-LAST:event_trhilangActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed

    }//GEN-LAST:event_laporanActionPerformed

    private void lpinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpinjamActionPerformed
    try {
            InputStream reportPath = getClass().getResourceAsStream("/laporan/peminjaman.jasper");
            HashMap<String, Object> parameters = new HashMap<>(); 

            java.sql.Connection conn = koneksi.koneksi.getKoneksi(); 

            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn); 
            
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal membuka laporan peminjaman: " + e.getMessage());
        }
    }//GEN-LAST:event_lpinjamActionPerformed

    private void lkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lkembaliActionPerformed
    try {
            InputStream reportPath = getClass().getResourceAsStream("/laporan/pengembalian.jasper");
            HashMap<String, Object> parameters = new HashMap<>(); 
            java.sql.Connection conn = koneksi.koneksi.getKoneksi(); 
            
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn); 
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal membuka laporan pengembalian: " + e.getMessage());
        }
    }//GEN-LAST:event_lkembaliActionPerformed

    private void lbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbeliActionPerformed
    try {
            InputStream reportPath = getClass().getResourceAsStream("/laporan/pembelian.jasper");
            HashMap<String, Object> parameters = new HashMap<>(); 
            java.sql.Connection conn = koneksi.koneksi.getKoneksi(); 
            
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn); 
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal membuka laporan pembelian: " + e.getMessage());
        }
    }//GEN-LAST:event_lbeliActionPerformed

    private void lhilangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lhilangActionPerformed
    try {
            InputStream reportPath = getClass().getResourceAsStream("/laporan/Hilang.jasper");
            HashMap<String, Object> parameters = new HashMap<>(); 
            java.sql.Connection conn = koneksi.koneksi.getKoneksi(); 
            
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn); 
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Gagal membuka laporan hilang & rusak: " + e.getMessage());
        }
    }//GEN-LAST:event_lhilangActionPerformed

    private void mrakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrakActionPerformed
    Rak formRak = new Rak();
    formRak.setVisible(true);
    }//GEN-LAST:event_mrakActionPerformed

    private void manggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manggotaActionPerformed
    Anggota formAnggota = new Anggota();
    formAnggota.setVisible(true);
    }//GEN-LAST:event_manggotaActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
    Kelompok kelompok = new Kelompok();
    kelompok.setVisible(true);
    }//GEN-LAST:event_namaActionPerformed

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
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu laporan;
    private javax.swing.JMenuItem lbeli;
    private javax.swing.JMenuItem lhilang;
    private javax.swing.JMenuItem lkembali;
    private javax.swing.JMenuItem lpinjam;
    private javax.swing.JMenuItem manggota;
    private javax.swing.JMenu master;
    private javax.swing.JMenuItem mbuku;
    private javax.swing.JMenuItem mkategori;
    private javax.swing.JMenuItem mpetugas;
    private javax.swing.JMenuItem mrak;
    private javax.swing.JMenuItem nama;
    private javax.swing.JMenu transaksi;
    private javax.swing.JMenuItem trhilang;
    private javax.swing.JMenuItem trpembelian;
    private javax.swing.JMenuItem trpeminjaman;
    private javax.swing.JMenuItem trpengembalian;
    // End of variables declaration//GEN-END:variables
}
