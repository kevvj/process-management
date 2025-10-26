
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    String url = "jdbc:mysql://localhost:3306/process-management";
    String user = "root";
    String password = "";
    Connection conn;

    public DBConnection() {
    }

    final Connection setConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException | NullPointerException e) {
            System.out.println("error"+ e);
            return null;
        }

    }

    public void createProcess(String name, String User, int pid, String description, int priority) {
        String sql = "INSERT INTO process (name, user, pid, description, priority, catalog_id) VALUES (?, ?, ?, ?, ?, ?)";
        conn = setConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, User);
            stmt.setInt(3, pid);
            stmt.setString(4, description);
            stmt.setInt(5, priority);
            stmt.setInt(6, 123);
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException | NullPointerException e) {
            System.out.println("error:" + e);
        }

    }

    public void a() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO procesos (nombre, prioridad) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "explorer.exe");
            stmt.setInt(2, 1);
            stmt.executeUpdate();
            conn.close();
            System.out.println("Dato insertado");
        } catch (SQLException | NullPointerException e) {
            System.out.println("error:" + e);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
