package addrec;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DatabaseHelper {

    // Path to your SQLite database (relative to project root)
    private static final String DB_URL = "jdbc:sqlite:records.db";

    // Connect to database
    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Create table if it doesn’t exist
    public static void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS records ("
                   + "id TEXT PRIMARY KEY, "
                   + "firstName TEXT NOT NULL, "
                   + "lastName TEXT NOT NULL, "
                   + "age INTEGER NOT NULL, "
                   + "address TEXT NOT NULL,"
                   + "course TEXT NOT NULL)";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Load all records into the JTable model
    public static void loadData(DefaultTableModel model) {
        if (model == null) {
            System.out.println("⚠ JTable model is NULL. Did you pass it correctly?");
            return;
        }

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM records")) {

            // Clear old rows first
            model.setRowCount(0);

            // Add rows from database
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("age"),
                    rs.getString("address")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a record
    public static void insertRecord(String id, String firstName, String lastName, int age, String address) {
        String sql = "INSERT INTO records(id, firstName, lastName, age, address) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, age);
            pstmt.setString(5, address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a record by ID
    public static void deleteRecord(String id) {
        String sql = "DELETE FROM records WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
