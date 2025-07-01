package DatabaseConnection;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.JOptionPane.*;
public class DatabaseConnection {
    public static Connection connect() {
        Connection conn =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_rumahmakan", "root", "");
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }
}
