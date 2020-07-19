package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection conecta() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bdcadastro", "root", "12345");
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

}
