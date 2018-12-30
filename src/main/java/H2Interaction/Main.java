package H2Interaction;

import java.sql.Connection;

public class Main {

    DatabaseConnection DBconnection;
    Connection connection;
    QueryExecutor executor;

    String createTable =  "CREATE TABLE   REGISTRATION " +
            "(id INTEGER(3) not NULL, " +
            " first VARCHAR(255), " +
            " last VARCHAR(255), " +
            " age INTEGER, " +
            " PRIMARY KEY ( id ))";
    String data = "INSERT INTO Registration " + "VALUES (100, 'Mark', 'Ledwold', 28)";
    String data2 = "INSERT INTO Registration " + "VALUES (101, 'John', 'Smith', 25)";
    String dropTable = "DROP TABLE REGISTRATION";
    String selectFromTable = "SELECT id, first, last, age FROM Registration";
    String updateRecord = "UPDATE registration SET age = 30 where id = 101";
    String deleteRecord = "DELETE FROM registration WHERE id = 101";

    public Main(){
        DBconnection = new DatabaseConnection();
        connection = DBconnection.getConnection();
        executor = new QueryExecutor(connection);
        executor.executeUpdate(dropTable);
        executor.executeUpdate(createTable);
        executor.executeUpdate(data);
        executor.executeUpdate(data2);
        executor.executeQuery(selectFromTable);
        executor.executeUpdate(updateRecord);
        executor.executeQuery(selectFromTable);
        executor.executeUpdate(deleteRecord);
        executor.executeQuery(selectFromTable);
        closeResources();
    }

    public void closeResources(){
        executor.closeStatement();
        DBconnection.closeConnection();
    }



    public static void main(String[] args) {
        Main main = new Main();
    }
}
