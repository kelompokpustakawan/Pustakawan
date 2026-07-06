package koneksi;
import java.sql.*;

public class koneksi {

    public static Connection getKoneksi() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/perpustakaan";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Gagal Koneksi: " + e.getMessage());
            return null;
        }
    }
}