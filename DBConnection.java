
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

    public int createCatalog(int num, String name){
        String sql = "INSERT INTO catalog (process_catalog, catalog_name) VALUES (?, ?)";
        conn = setConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, num);
            stmt.setString(2, name);
            stmt.executeUpdate();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
            conn.close();
        } catch (SQLException | NullPointerException e) {
            System.out.println("error:" + e);
        }
        return -1;
    }

    public void createProcess(String name, String User, int pid, String description, int priority, int catalog_id) {
        String sql = "INSERT INTO process (name, user, pid, description, priority, catalog_id) VALUES (?, ?, ?, ?, ?, ?)";
        conn = setConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, User);
            stmt.setInt(3, pid);
            stmt.setString(4, description);
            stmt.setInt(5, priority);
            stmt.setInt(6, catalog_id);
            stmt.executeUpdate();
            conn.close();
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
