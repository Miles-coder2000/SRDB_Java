package addrec;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:records.db";

    // ✅ Create table if not exists
    public static void initDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
String sqlUsers = "CREATE TABLE IF NOT EXISTS users (" +
                  "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                  "username TEXT UNIQUE, " +
                  "password TEXT)";

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Insert Record
    public static void insertRecord(String id, String firstName, String lastName, String age, String address) {
        String sql = "INSERT INTO records (id, firstName, lastName, age, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, age);
            pstmt.setString(5, address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "⚠ Error inserting record: " + e.getMessage());
        }
    }

    // ✅ Update Record
    public static void updateRecord(String id, String firstName, String lastName, String age, String address) {
        String sql = "UPDATE records SET firstName=?, lastName=?, age=?, address=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, age);
            pstmt.setString(4, address);
            pstmt.setString(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "⚠ Error updating record: " + e.getMessage());
        }
    }

    // ✅ Delete Record
    public static void deleteRecord(String id) {
        String sql = "DELETE FROM records WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "⚠ Error deleting record: " + e.getMessage());
        }
    }

    // ✅ Load Data into Table
    public static void loadData(DefaultTableModel model) {
        model.setRowCount(0); // clear table first
        String sql = "SELECT * FROM records";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("age"),
                    rs.getString("address")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean login(String username, String password) {
    String sql = "SELECT * FROM users WHERE username=? AND password=?";
    try (Connection conn = DriverManager.getConnection(DB_URL);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        try (ResultSet rs = pstmt.executeQuery()) {
            return rs.next(); // ✅ true if a record exists
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "⚠ Error logging in: " + e.getMessage());
        return false;
    }
}

// ✅ Register New User
public static boolean register(String username, String password) {
    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
    try (Connection conn = DriverManager.getConnection(DB_URL);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "⚠ Error registering user: " + e.getMessage());
        return false;
    }
}
}
