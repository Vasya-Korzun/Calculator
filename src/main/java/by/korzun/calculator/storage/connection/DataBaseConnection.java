package by.korzun.calculator.storage.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnection {
    private final String url = "jdbc:postgresql://localhost:5432/shop";
    private final String user = "postgres";
    private final String password = "root";

    private Connection connection;

    public DataBaseConnection(){
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException{
        return connection.prepareStatement(sql);
    }

}
