package koneksi;
import java.sql.*;

public class koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
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