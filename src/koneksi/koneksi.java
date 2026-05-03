package koneksi;
import java.sql.*;

public class koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        // Cek jika koneksi belum dibuat atau sudah tertutup
        if (koneksi == null) {
            try {
                // Driver untuk MySQL versi terbaru (gunakan com.mysql.cj.jdbc.Driver jika MySQL 8.0+)
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost/perpustakaan";
                String user = "root";
                String password = "";

                Class.forName(driver);
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil Terhubung ke Database");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Gagal Koneksi: " + e.getMessage());
            }
        }
        return koneksi;
    }
}