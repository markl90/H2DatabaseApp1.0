package H2Interaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static H2Interaction.Constants.*;

public class DatabaseConnection {

    Connection connection;

    public DatabaseConnection(){
        System.out.println("Connecting to database.");
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
