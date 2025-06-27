import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/StudentManagementSystem";
    private static final String userName = "postgres";
    private static final String password = "Islam2005";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url, userName, password);
    }

}
