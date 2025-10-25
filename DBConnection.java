
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {

    String url = "jdbc:mysql://localhost:3306/tu_base";
    String user = "root";
    String password = "";
    Connection conn;

    public DBConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;

        conn = null;
    }

    final Connection setConnection(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                return null;
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void createProcess(String name, String User, String pid, String description, String priority) {
        String sql = "INSERT INTO procesos (name, user, pid, description, priority) VALUES (?, ?, ?, ?, ?)";
        conn = setConnection(url, user, password);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, User);
            stmt.setString(3, pid);
            stmt.setString(4, description);
            stmt.setString(5, priority);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
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
